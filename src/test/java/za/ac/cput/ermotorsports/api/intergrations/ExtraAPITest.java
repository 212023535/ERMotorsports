package za.ac.cput.ermotorsports.api.intergrations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.ermotorsports.domain.Extra;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Edmund.Simons on 27/10/2015.
 */
public class ExtraAPITest
{
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    public void setUP() throws Exception
    {
        template = new RestTemplate();
    }

    public void testRead() throws Exception
    {
        ResponseEntity<String> response = template.getForEntity(BASE_URL + "api/extra/readall", String.class);
        System.out.println("The response is "+response.getBody());
    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    private static void listAllExtra()
    {
        System.out.println("Testing listAllExtra API-------------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> ExtrasMap = restTemplate.getForObject(REST_SERVICE_URI+"/extras/", List.class);

        if(ExtrasMap!=null)
        {
            for(LinkedHashMap<String, Object> map: ExtrasMap)
            {
                System.out.println("Extra: id = " + map.get("id") + ", Brand = " + map.get("brand") + ", Price = " + map.get("price") + ", Units = " + map.get("units") + ", Description = " + map.get("description"));
            }
        }
        else
        {
            System.out.println("No Extras in the database");
        }
    }

    private static void getExtra()
    {
        System.out.println("Testing getExtra API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Extra extra = restTemplate.getForObject(REST_SERVICE_URI + "/extra/1", Extra.class);
        System.out.println(extra);
    }

    private static void createExtra()
    {
        System.out.println("Testing createExtra API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Extra extra = new Extra.Build("Simota").price("R220").units("45").description("Air filter").build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/extra/create/", extra, Extra.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateExtra()
    {
        System.out.println("Testing updateExtra API-------------");

    }

    private static void deleteExtra()
    {
        System.out.println("Testing deleteExtra API-------------");

    }

    private static void deleteAllExtra()
    {
        System.out.println("Testing deleteAllExtra API-------------");

    }
}
