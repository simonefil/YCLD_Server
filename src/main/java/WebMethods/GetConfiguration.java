package WebMethods;

import Init.Server;
import com.Utils.Serializers.Json;
import spark.Request;
import spark.Response;
import spark.Route;

public class GetConfiguration {

    public static Route getConfiguration = (Request request, Response response) -> {
        response.type("application/json");
        return Json.serializer().toString(Server.Application.GetConfiguration());
    };
}
