package za.ac.cput.ermotorsports.api.intergrations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Edmund.Simons on 27/10/2015.
 */
public class TransactionAPITest
{
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    public void setUP() throws Exception
    {
        template = new RestTemplate();
    }

    public void testRead() throws Exception
    {
        ResponseEntity<String> response = template.getForEntity(BASE_URL + "api/transaction/readall", String.class);
        System.out.println("The response is "+response.getBody());
    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    private static void listAllTransaction()
    {
        System.out.println("Testing listAllTransaction API-------------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> Transaction = restTemplate.getForObject(REST_SERVICE_URI+"/transactions/", List.class);

        if(Transaction!=null)
        {
            for(LinkedHashMap<String, Object> map: Transaction)
            {
                System.out.println("Transaction: id = " + map.get("id") + ", Amount = " + map.get("amount") + ", Car = " + map.get("car_id") + ", Customer = " + map.get("cust_id"));
            }
        }
        else
        {
            System.out.println("No Transactions in the database");
        }
    }

    private static void getTransaction()
    {
        System.out.println("Testing getTransaction API-------------");

    }

    private static void createTransaction()
    {
        System.out.println("Testing createTransaction API-------------");

    }

    private static void updateTransaction()
    {
        System.out.println("Testing updateTransaction API-------------");

    }

    private static void deleteTransaction()
    {
        System.out.println("Testing deleteTransaction API-------------");

    }

    private static void deleteAllTransaction()
    {
        System.out.println("Testing deleteAllTransaction API-------------");

    }
}
