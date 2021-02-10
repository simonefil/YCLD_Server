package IO;

import Init.Server;
import Support.Language;
import Templates.Profile;
import Templates.ProfileDetail;
import com.Utils.BaseClass;
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
        ProfileDetail tTempProfileDetail;
        Profile tTempProfile;
        String[] tSplittedLine;



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
                tTempProfileDetail = new ProfileDetail();

                tCurrentLine = tCustomConvertLines.get(tIndex);
                tOk = tOk && this.pParseProfileName(tCurrentLine, tTempProfileDetail);

                tIndex++;
                tCurrentLine = tCustomConvertLines.get(tIndex);
                tOk = tOk && this.pParseStdinStdoutMacAddr(tCurrentLine, tTempProfileDetail);

                tIndex++;
                tIndex++;
                tCurrentLine = tCustomConvertLines.get(tIndex);
                tOk = tOk && this.pParseCommand(tCurrentLine, tTempProfileDetail);
                tIndex++;
                tIndex++;

                if (tTempProfileDetail != null) {
                    tTempProfile.setProfileDetail(tTempProfileDetail);
                    tTempProfile.PopulateInfo();
                    Server.Application.GetProfilesList().addProfile(tTempProfile);
                }
            }
        }
        else
            this.pSetError(String.format(Language.ErrCustomConvertSyntax, this.pCustomConvertDir));

        return !this.HasError;
    }

    private void pWriteLMSCustomConvert() {

    }

    private boolean pParseProfileName(String parLine, ProfileDetail parProfileDetail) {
        boolean tOk = true;
        parLine = parLine.replace("# Profile name: ", "");
        parLine = parLine.replace(System.lineSeparator(), "");

        parProfileDetail.setProfileName(parLine);
        return tOk;
    }

    private boolean pParseStdinStdoutMacAddr(String parLine, ProfileDetail parProfileDetail) {
        boolean tOk = true;
        String[] tSplittedLine;

        tSplittedLine = parLine.split(" ");
        parProfileDetail.setStdinFormat(tSplittedLine[0]);
        parProfileDetail.setStdoutFormat(tSplittedLine[1]);
        parProfileDetail.setMacAddress(tSplittedLine[3]);
        return tOk;
    }

    private boolean pParseCommand(String parLine, ProfileDetail parProfileDetail) {
        boolean tOk = true;
        String[] tSplittedCommands;
        tSplittedCommands = parLine.split(" ");

        for (String tWord : tSplittedCommands){
            if (tWord.startsWith("--output-bit"))
                parProfileDetail.setBitDepth(tWord.replace("--output-bit=", ""));

            if (tWord.startsWith("--output-rate"))
                parProfileDetail.setSampleRate(tWord.replace("--output-rate=", ""));

            if (tWord.startsWith("--convolution"))
                parProfileDetail.setConvolutionImpulsesPath(tWord.replace("--convolution=", ""));
        }
        return tOk;
    }
}
