package Templates;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ProfileDetail {

    //region Private Variables
    private String profileName;
    private String macAddress;
    private String stdinFormat;
    private String stdoutFormat;
    private String sampleRate;
    private String bitDepth;
    private String convolutionImpulsesPath;

    //endregion

    //region Constructor

    @JsonCreator
    public ProfileDetail(String parProfileName, String parMacAddress, String parStdinFormat, String parStdoutFormat, String parSampleRate, String parBitDepth, String parConvolutionImpulsesPath) {
        this.profileName = parProfileName;
        this.macAddress = parMacAddress;
        this.stdinFormat = parStdinFormat;
        this.stdoutFormat = parStdoutFormat;
        this.sampleRate = parSampleRate;
        this.bitDepth = parBitDepth;
        this.convolutionImpulsesPath = parConvolutionImpulsesPath;
    }

    public ProfileDetail() {}

    //endregion

    //region Getters and Setters

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getMacAddress() {
        if (macAddress == null || macAddress == "")
            return "*";
        else
            return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getStdinFormat() {
        return stdinFormat;
    }

    public void setStdinFormat(String stdinFormat) {
        this.stdinFormat = stdinFormat;
    }

    public String getStdoutFormat() {
        return stdoutFormat;
    }

    public void setStdoutFormat(String stdoutFormat) {
        this.stdoutFormat = stdoutFormat;
    }

    public String getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getBitDepth() {
        return bitDepth;
    }

    public void setBitDepth(String bitDepth) {
        this.bitDepth = bitDepth;
    }

    public String getConvolutionImpulsesPath() {
        return convolutionImpulsesPath;
    }

    public void setConvolutionImpulsesPath(String convolutionImpulsesPath) {
        this.convolutionImpulsesPath = convolutionImpulsesPath;
    }

    //endregion

    //region Methods

    public String toCustomConvert() {
        String customConvertConfig = "";

        customConvertConfig += "# Profile name: " + this.getProfileName() + System.lineSeparator();
        customConvertConfig += this.getStdinFormat() + " " + this.getStdoutFormat() + " * " + this.getMacAddress() + System.lineSeparator();
        customConvertConfig += "    # IFT:{START=--skip=%t}U:{END=--until=%v}" + System.lineSeparator();

        return customConvertConfig;
    }

    //endregion

    //region Overrides

    @Override
    public String toString() {
        return "Profile{" +
                "profileName='" + profileName + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", stdinFormat='" + stdinFormat + '\'' +
                ", stdoutFormat='" + stdoutFormat + '\'' +
                ", sampleRate=" + sampleRate +
                ", bitDepth=" + bitDepth +
                ", convolutionImpulsesPath='" + convolutionImpulsesPath + '\'' +
                '}';
    }

    //endregion

}
