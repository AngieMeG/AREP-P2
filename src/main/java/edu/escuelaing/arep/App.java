package edu.escuelaing.arep;

import static spark.Spark.*;

import java.util.HashMap;

import org.json.JSONObject;

import edu.escuelaing.arep.services.Matematica;
import spark.Request;
import spark.Response;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        port(getPort());
        staticFileLocation("/public");

        get("/", (req, res) -> {
            res.redirect("/login.html");
            res.status(200);
            return null;
        });

        get("/atan", (req, res) -> atanFunction(req, res));
        
        get("/In", (req, res) -> inFunction(req, res));

    }


    public static JSONObject atanFunction(Request req, Response res){
        res.type("application/json");
        JSONObject response = new JSONObject();
        response.put("operation", "atan");
        response.put("input", req.queryParams("value"));
        response.put("output", String.valueOf(Matematica.arcoTan(Double.parseDouble(req.queryParams("value")))));
        return response;
    }

    public static JSONObject inFunction(Request req, Response res){
        res.type("application/json");
        JSONObject response = new JSONObject();
        response.put("operation", "atan");
        response.put("input", req.queryParams("value"));
        response.put("output", String.valueOf(Matematica.logNatural(Double.parseDouble(req.queryParams("value")))));
        return response;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
