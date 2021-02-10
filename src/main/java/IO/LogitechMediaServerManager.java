package IO;

import Init.Server;
import Support.Language;
import Templates.Profile;
import com.Utils.BaseClass;
import com.Utils.Serializers.Json;

import java.io.*;
import java.util.ArrayList;

public class LogitechMediaServerManager extends BaseClass {

    private String pCustomConvertDir;

    public LogitechMediaServerManager(String parCustomConvert) {
        this.pCustomConvertDir = parCustomConvert;
    }

    public boolean ReadLMSCustomConvert() throws IOException {
        File tCustomConvert;
        boolean tOk;
        BufferedReader tReader;
        String tLine;
        ArrayList<String> tCustomConvertLines = new ArrayList<>();
        int tIndex = 2;
        String tCurrentLine;
        Profile tTempProfile;


        // Open custom-convert.conf
        tCustomConvert = new File(this.pCustomConvertDir);

        // Check if the file exists
        tOk = tCustomConvert.exists();

        // Read the content and save it to tCustomConvertLines
        if (tOk) {
            tReader = new BufferedReader(new FileReader(tCustomConvert));
            while ((tLine = tReader.readLine()) != null) {
                tCustomConvertLines.add(tLine);
            }
        }

        // Check if the file is created by YCLD
        if (tOk && tCustomConvertLines.size() > 0 && !tCustomConvertLines.get(0).contains("# Created by YCLD_Server")) {
            tOk = tCustomConvert.delete();
            tCustomConvertLines.clear();
            tOk = false;
        }

        // Check if the file syntax is correct
        if (tOk && (tCustomConvertLines.size()-1) % 5 == 0) {
            while(tIndex < tCustomConvertLines.size()) {
                tTempProfile = new Profile();

                tCurrentLine = tCustomConvertLines.get(tIndex);
                tOk = tOk && this.pParseProfileName(tCurrentLine, tTempProfile);

                tIndex++;
                tCurrentLine = tCustomConvertLines.get(tIndex);
                tOk = tOk && this.pParseStdinStdoutMacAddr(tCurrentLine, tTempProfile);

                tIndex++;
                tIndex++;
                tCurrentLine = tCustomConvertLines.get(tIndex);
                tOk = tOk && this.pParseCommand(tCurrentLine, tTempProfile);
                tIndex++;
                tIndex++;

                tTempProfile.CalculateDependingFields();
                Server.Application.GetProfilesList().addProfile(tTempProfile);
            }
        }
        else
            this.pSetError(String.format(Language.ErrCustomConvertSyntax, this.pCustomConvertDir));

        return !this.HasError;
    }

    private void pWriteLMSCustomConvert() {

    }

    private boolean pParseProfileName(String parLine, Profile parProfile) {
        boolean tOk = true;
        parLine = parLine.replace("# Profile name: ", "");
        parLine = parLine.replace(System.lineSeparator(), "");

        parProfile.setProfileName(parLine);
        return tOk;
    }

    private boolean pParseStdinStdoutMacAddr(String parLine, Profile parProfile) {
        boolean tOk = true;
        String[] tSplittedLine;

        tSplittedLine = parLine.split(" ");
        parProfile.setStdinFormat(tSplittedLine[0]);
        parProfile.setStdoutFormat(tSplittedLine[1]);
        parProfile.setMacAddress(tSplittedLine[3]);
        return tOk;
    }

    private boolean pParseCommand(String parLine, Profile parProfile) {
        boolean tOk = true;
        String[] tSplittedCommands;
        tSplittedCommands = parLine.split(" ");

        for (String tWord : tSplittedCommands){
            if (tWord.startsWith("--output-bit"))
                parProfile.setBitDepth(tWord.replace("--output-bit=", ""));

            if (tWord.startsWith("--output-rate"))
                parProfile.setSampleRate(tWord.replace("--output-rate=", ""));

            if (tWord.startsWith("--convolution"))
                parProfile.setConvolutionImpulsesPath(tWord.replace("--convolution=", ""));
        }
        return tOk;
    }
}
