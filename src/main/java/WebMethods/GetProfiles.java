package WebMethods;

import Init.Server;
import com.Utils.Serializers.Json;
import spark.Request;
import spark.Response;
import spark.Route;

public class GetProfiles {

    public static Route getProfiles = (Request request, Response response) -> {
        response.type("application/json");
        return Json.serializer().toString(Server.Application.GetProfilesList());
    };
}
