package Templates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfilesList {
    List<Profile> profileList;

    public ProfilesList() { }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public void addProfile(Profile value) {
        if (this.profileList == null)
            this.profileList = new ArrayList<>(Collections.singletonList(value));
        else
            this.profileList.add(value);
    }
}
