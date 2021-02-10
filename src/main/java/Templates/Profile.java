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

    public void setMacAddress(String parMacAddress) {
        this.pMacAddress = parMacAddress;
    }

    public String getStdinFormat() {
        return this.pStdinFormat;
    }

    public void setStdinFormat(String parStdinFormat) {
        this.pStdinFormat = parStdinFormat;
    }

    public String getStdoutFormat() {
        return this.pStdoutFormat;
    }

    public void setStdoutFormat(String parStdoutFormat) {
        this.pStdoutFormat = parStdoutFormat;
    }

    public String getSampleRate() {
        return this.pSampleRate;
    }

    public void setSampleRate(String parSampleRate) {
        this.pSampleRate = parSampleRate;
    }

    public String getBitDepth() {
        return this.pBitDepth;
    }

    public void setBitDepth(String parBitDepth) {
        this.pBitDepth = parBitDepth;
    }

    public String getConvolutionImpulsesPath() {
        return this.pConvolutionImpulsesPath;
    }

    public void setConvolutionImpulsesPath(String parConvolutionImpulsesPath) {
        this.pConvolutionImpulsesPath = parConvolutionImpulsesPath;
    }

    public boolean isConvolutionEnabled() {
        return this.pConvolutionEnabled;
    }

    public void setConvolutionEnabled(boolean parConvolutionEnabled) {
        this.pConvolutionEnabled = parConvolutionEnabled;
    }

    public boolean isResamplingEnabled() {
        return this.pResamplingEnabled;
    }

    public void setResamplingEnabled(boolean parResamplingEnabled) {
        this.pResamplingEnabled = parResamplingEnabled;
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
