package Templates;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Profile {

    //region Private Variables
    private String pProfileName = "";
    private String pMacAddress = "";
    private String pStdinFormat = "";
    private String pStdoutFormat = "";
    private String pSampleRate = "";
    private String pBitDepth = "";
    private String pConvolutionImpulsesPath = "";
    private boolean pConvolutionEnabled = false;
    private boolean pResamplingEnabled = false;

    //endregion

    //region Constructor

    public Profile() {}

    //endregion

    //region Methods

    public void CalculateDependingFields()
    {
        if (!this.pConvolutionImpulsesPath.equals(""))
            this.pConvolutionEnabled = true;

        if (!this.pBitDepth.equals("-1") || !this.pSampleRate.equals("-1"))
            this.pResamplingEnabled = true;
    }

    //endregion

    //region Getters and Setters

    public String getProfileName() {
        return pProfileName;
    }

    public void setProfileName(String pProfileName) {
        this.pProfileName = pProfileName;
    }

    public String getMacAddress() {
        if (pMacAddress == null || pMacAddress == "")
            return "*";
        else
            return pMacAddress;
    }

    public void setMacAddress(String pMacAddress) {
        this.pMacAddress = pMacAddress;
    }

    public String getStdinFormat() {
        return pStdinFormat;
    }

    public void setStdinFormat(String pStdinFormat) {
        this.pStdinFormat = pStdinFormat;
    }

    public String getStdoutFormat() {
        return pStdoutFormat;
    }

    public void setStdoutFormat(String pStdoutFormat) {
        this.pStdoutFormat = pStdoutFormat;
    }

    public String getSampleRate() {
        return pSampleRate;
    }

    public void setSampleRate(String pSampleRate) {
        this.pSampleRate = pSampleRate;
    }

    public String getBitDepth() {
        return pBitDepth;
    }

    public void setBitDepth(String pBitDepth) {
        this.pBitDepth = pBitDepth;
    }

    public String getConvolutionImpulsesPath() {
        return pConvolutionImpulsesPath;
    }

    public void setConvolutionImpulsesPath(String pConvolutionImpulsesPath) {
        this.pConvolutionImpulsesPath = pConvolutionImpulsesPath;
    }

    public boolean ispConvolutionEnabled() {
        return pConvolutionEnabled;
    }

    public void setpConvolutionEnabled(boolean pConvolutionEnabled) {
        this.pConvolutionEnabled = pConvolutionEnabled;
    }

    public boolean ispResamplingEnabled() {
        return pResamplingEnabled;
    }

    public void setpResamplingEnabled(boolean pResamplingEnabled) {
        this.pResamplingEnabled = pResamplingEnabled;
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
                "profileName='" + pProfileName + '\'' +
                ", macAddress='" + pMacAddress + '\'' +
                ", stdinFormat='" + pStdinFormat + '\'' +
                ", stdoutFormat='" + pStdoutFormat + '\'' +
                ", sampleRate=" + pSampleRate +
                ", bitDepth=" + pBitDepth +
                ", convolutionImpulsesPath='" + pConvolutionImpulsesPath + '\'' +
                '}';
    }

    //endregion

}
