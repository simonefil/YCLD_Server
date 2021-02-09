package Init;

import IO.LogitechMediaServerManager;
import Templates.Configuration;
import Templates.ProfilesList;
import WebMethods.GetConfiguration;
import WebMethods.GetProfiles;
import WebMethods.SaveProfiles;
import com.Utils.Serializers.Xml;

import static spark.Spark.*;

public class Server {

    public static Server Application;
    private Configuration pConfiguration;
    private ProfilesList pProfilesList;
    private LogitechMediaServerManager pLMSManager;

    public static void main(String[] args) {
        int tThreadNumber = 8;
        Application = new Server();
        Application.pConfiguration = new Configuration();
        Application.pProfilesList = new ProfilesList();
        Application.pLMSManager = new LogitechMediaServerManager("C:\\Users\\Simone\\new.txt");

        try {
            // Read config
            ClassLoader classLoader = Server.class.getClassLoader();
            Application.SetConfiguration(Xml.serializer().fromInputStream(classLoader.getResourceAsStream("ycld-config.xml"), Configuration.class));
            Application.pLMSManager.ReadLMSCustomConvert();

            // WebServer config
            port(6969);
            threadPool(tThreadNumber);
            staticFileLocation("/public");
            init();

            // Define routes
            get("/getConfiguration", GetConfiguration.getConfiguration);
            get("/getProfiles", GetProfiles.getProfiles);
            post("/saveProfiles", SaveProfiles.saveProfiles);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ProfilesList GetProfilesList() {
        return this.pProfilesList;
    }

    public void SetProfilesList(ProfilesList value){
        this.pProfilesList = value;
    }

    public Configuration GetConfiguration() {
        return this.pConfiguration;
    }

    public void SetConfiguration (Configuration value) {
        this.pConfiguration = value;
    }
}

