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

    @JsonCreator
    public Profile(String parProfileName, String parMacAddress, String parStdinFormat, String parStdoutFormat, String parSampleRate, String parBitDepth, String parConvolutionImpulsesPath) {
        this.pProfileName = parProfileName;
        this.pMacAddress = parMacAddress;
        this.pStdinFormat = parStdinFormat;
        this.pStdoutFormat = parStdoutFormat;
        this.pSampleRate = parSampleRate;
        this.pBitDepth = parBitDepth;
        this.pConvolutionImpulsesPath = parConvolutionImpulsesPath;
    }

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

    public String getpProfileName() {
        return pProfileName;
    }

    public void setpProfileName(String pProfileName) {
        this.pProfileName = pProfileName;
    }

    public String getpMacAddress() {
        if (pMacAddress == null || pMacAddress == "")
            return "*";
        else
            return pMacAddress;
    }

    public void setpMacAddress(String pMacAddress) {
        this.pMacAddress = pMacAddress;
    }

    public String getpStdinFormat() {
        return pStdinFormat;
    }

    public void setpStdinFormat(String pStdinFormat) {
        this.pStdinFormat = pStdinFormat;
    }

    public String getpStdoutFormat() {
        return pStdoutFormat;
    }

    public void setpStdoutFormat(String pStdoutFormat) {
        this.pStdoutFormat = pStdoutFormat;
    }

    public String getpSampleRate() {
        return pSampleRate;
    }

    public void setpSampleRate(String pSampleRate) {
        this.pSampleRate = pSampleRate;
    }

    public String getpBitDepth() {
        return pBitDepth;
    }

    public void setpBitDepth(String pBitDepth) {
        this.pBitDepth = pBitDepth;
    }

    public String getpConvolutionImpulsesPath() {
        return pConvolutionImpulsesPath;
    }

    public void setpConvolutionImpulsesPath(String pConvolutionImpulsesPath) {
        this.pConvolutionImpulsesPath = pConvolutionImpulsesPath;
    }

    //endregion

    //region Methods

    public String toCustomConvert() {
        String customConvertConfig = "";

        customConvertConfig += "# Profile name: " + this.getpProfileName() + System.lineSeparator();
        customConvertConfig += this.getpStdinFormat() + " " + this.getpStdoutFormat() + " * " + this.getpMacAddress() + System.lineSeparator();
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
