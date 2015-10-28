package za.ac.cput.ermotorsports.api.intergrations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.ermotorsports.domain.Car;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Edmund.Simons on 27/10/2015.
 */
public class CarAPITest
{
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    public void setUP() throws Exception
    {
        template = new RestTemplate();
    }

    public void testRead() throws Exception
    {
        ResponseEntity<String> response = template.getForEntity(BASE_URL + "api/car/readall", String.class);
        System.out.println("The response is "+response.getBody());
    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    private static void listAllCars()
    {
        System.out.println("Testing listAllCars API-------------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> CarsMap = restTemplate.getForObject(REST_SERVICE_URI+"/cars/", List.class);

        if(CarsMap!=null)
        {
            for(LinkedHashMap<String, Object> map: CarsMap)
            {
                System.out.println("Car: id = " + map.get("id") + ", Brand = " + map.get("brand") + ", Model = " + map.get("model") + ", Colour = " + map.get("colour") + ", Year = " + map.get("year"));
            }
        }
        else
        {
            System.out.println("No Cars in the database");
        }
    }

    private static void getCar()
    {
        System.out.println("Testing getCar API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Car car = restTemplate.getForObject(REST_SERVICE_URI + "/car/1", Car.class);
        System.out.println(car);
    }

    private static void createCar()
    {
        System.out.println("Testing createCar API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Car car = new Car.Builder("Mercedes Benz").model("S Class").year("2013").colour("Black").build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/car/create/", car, Car.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateCar()
    {
        System.out.println("Testing updateCar API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Car car = new Car.Builder("Mercedes Benz").model("S Class").year("2013").colour("Black").build();
        restTemplate.put(REST_SERVICE_URI + "/car/update/1", car);
        System.out.println(car);
    }

    private static void deleteCar()
    {
        System.out.println("Testing deleteCar API-------------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/car/delete/3");
    }

    private static void deleteAllCars()
    {
        System.out.println("Testing deleteAllCars API-------------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/car/");
    }
}
