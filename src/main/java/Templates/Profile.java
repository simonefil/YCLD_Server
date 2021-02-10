package Templates;

public class Profile {

    private ProfileInfo profileInfo;
    private ProfileDetail profileDetail;

    public Profile() { }

    public void PopulateInfo(){
        if (this.profileDetail != null) {
            ProfileInfo tInfo = new ProfileInfo();
            tInfo.setProfileName(this.profileDetail.getProfileName());
            tInfo.setMacAddress(this.profileDetail.getMacAddress());
            tInfo.setStdinFormat(this.profileDetail.getStdinFormat());
            tInfo.setStdoutFormat(this.profileDetail.getStdoutFormat());
            tInfo.setResampling(this.profileDetail.getBitDepth() != "-1" || this.profileDetail.getSampleRate() != "-1");
            tInfo.setConvolution(this.profileDetail.getConvolutionImpulsesPath() != "");
            this.profileInfo = tInfo;
        }
    }

    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }

    public ProfileDetail getProfileDetail() {
        return profileDetail;
    }

    public void setProfileDetail(ProfileDetail profileDetail) {
        this.profileDetail = profileDetail;
    }
}
