package za.ac.cput.ermotorsports.api.intergrations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.ermotorsports.domain.Engine;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Edmund.Simons on 27/10/2015.
 */
public class EngineAPITest
{
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    public void setUP() throws Exception
    {
        template = new RestTemplate();
    }

    public void testRead() throws Exception
    {
        ResponseEntity<String> response = template.getForEntity(BASE_URL + "api/engine/readall", String.class);
        System.out.println("The response is "+response.getBody());
    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    private static void listAllEngine()
    {
        System.out.println("Testing listAllEngine API-------------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> EngineMap = restTemplate.getForObject(REST_SERVICE_URI+"/engines/", List.class);

        if(EngineMap!=null)
        {
            for(LinkedHashMap<String, Object> map: EngineMap)
            {
                System.out.println("Transaction: id = " + map.get("id") + ", CubicCapacity = " + map.get("cubicCapacity") + ", Units = " + map.get("units") + ", Cylinders = " + map.get("cylinders") + ", Price = " + map.get("price") + ", Brand = " + map.get("brand") + ", Model = " + map.get("model"));
            }
        }
        else
        {
            System.out.println("No Engines in the database");
        }
    }

    private static void getEngine()
    {
        System.out.println("Testing getEngine API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Engine engine = restTemplate.getForObject(REST_SERVICE_URI + "/engine/1", Engine.class);
        System.out.println(engine);
    }

    private static void createEngine()
    {
        System.out.println("Testing createEngine API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Engine engine = new Engine.Build("BMW").cubicCapacity("3.5").units("12").cylinders("6").price("R45000").model("S64 V6").build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/engine/create/", engine, Engine.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateEngine()
    {
        System.out.println("Testing updateEngine API-------------");

    }

    private static void deleteEngine()
    {
        System.out.println("Testing deleteEngine API-------------");

    }

    private static void deleteAllEngine()
    {
        System.out.println("Testing deleteAllEngine API-------------");

    }
}
