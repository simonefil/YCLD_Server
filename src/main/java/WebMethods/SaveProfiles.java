package WebMethods;

import Init.Server;
import Templates.ProfilesList;
import com.Utils.Serializers.Json;
import spark.Request;
import spark.Response;
import spark.Route;

public class SaveProfiles {
    public static Route saveProfiles = (Request request, Response response) -> {
        response.type("application/json");
        Server.Application.SetProfilesList(Json.serializer().fromJson(request.body(), ProfilesList.class));
        return null;
    };
}
