package Templates;

public class ProfileInfo {

    private String profileName = "";
    private String macAddress = "";
    private String stdinFormat = "";
    private String stdoutFormat = "";
    private boolean resampling = false;
    private boolean convolution = false;

    public ProfileInfo() {}
    public ProfileInfo(String profileName, String macAddress, String stdinFormat, String stdoutFormat, boolean resampling, boolean convolution) {
        this.profileName = profileName;
        this.macAddress = macAddress;
        this.stdinFormat = stdinFormat;
        this.stdoutFormat = stdoutFormat;
        this.resampling = resampling;
        this.convolution = convolution;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getMacAddress() {
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

    public boolean isResampling() {
        return resampling;
    }

    public void setResampling(boolean resampling) {
        this.resampling = resampling;
    }

    public boolean isConvolution() {
        return convolution;
    }

    public void setConvolution(boolean convolution) {
        this.convolution = convolution;
    }
}
