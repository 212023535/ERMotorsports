package za.ac.cput.ermotorsports.api.intergrations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Edmund.Simons on 27/10/2015.
 */
public class CustomerAPITest
{
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    public void setUP() throws Exception
    {
        template = new RestTemplate();
    }

    public void testRead() throws Exception
    {
        ResponseEntity<String> response = template.getForEntity(BASE_URL + "api/customer/readall", String.class);
        System.out.println("The response is "+response.getBody());
    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    private static void listAllCars()
    {
        System.out.println("Testing listAllCustomers API-------------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> CustomersMap = restTemplate.getForObject(REST_SERVICE_URI+"/customers/", List.class);

        if(CustomersMap!=null)
        {
            for(LinkedHashMap<String, Object> map: CustomersMap)
            {
                System.out.println("Customer: id = " + map.get("id") + ", First Name = " + map.get("fname") + ", Last Name = " + map.get("lname") + ", Number = " + map.get("number") + ", Address = " + map.get("address"));
            }
        }
        else
        {
            System.out.println("No Customers in the database");
        }
    }

    private static void getCustomer()
    {
        System.out.println("Testing getCustomers API-------------");

    }

    private static void createCustomer()
    {
        System.out.println("Testing createCustomers API-------------");

    }

    private static void updateCustomer()
    {
        System.out.println("Testing updateCustomers API-------------");

    }

    private static void deleteCustomer()
    {
        System.out.println("Testing deleteCustomers API-------------");

    }

    private static void deleteAllCustomer()
    {
        System.out.println("Testing deleteAllCustomers API-------------");

    }
}
