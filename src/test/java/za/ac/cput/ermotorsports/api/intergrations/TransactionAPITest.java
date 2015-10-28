package za.ac.cput.ermotorsports.api.intergrations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.ermotorsports.domain.Transaction;

import java.net.URI;
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
        RestTemplate restTemplate = new RestTemplate();
        Transaction transaction = restTemplate.getForObject(REST_SERVICE_URI + "/transaction/1", Transaction.class);
        System.out.println(transaction);
    }

    private static void createTransaction()
    {
        System.out.println("Testing createTransaction API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Transaction transaction = new Transaction.Build("R5000").car(1L).customer(1L).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/transaction/create/", transaction, Transaction.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateTransaction()
    {
        System.out.println("Testing updateTransaction API-------------");
        RestTemplate restTemplate = new RestTemplate();
        Transaction transaction = new Transaction.Build("R5000").car(1L).customer(1L).build();
        restTemplate.put(REST_SERVICE_URI + "/transaction/update/1", transaction);
        System.out.println(transaction);
    }

    private static void deleteTransaction()
    {
        System.out.println("Testing deleteTransaction API-------------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/transaction/delete/3");
    }

    private static void deleteAllTransaction()
    {
        System.out.println("Testing deleteAllTransaction API-------------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/transaction/");
    }
}
