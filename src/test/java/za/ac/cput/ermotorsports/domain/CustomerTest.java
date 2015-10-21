package za.ac.cput.ermotorsports.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.ermotorsports.conf.factory.CustomerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class CustomerTest
{
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createCustomer() throws Exception
    {
        Map<String,String> customer1 = new HashMap<String, String>();
        customer1.put("fname","Chris");
        customer1.put("lname","Harris");
        customer1.put("number","0768848797");
        customer1.put("address", "87 Heath Street, Cape Town");

        Customer customer = CustomerFactory.createCustomer(customer1);
        Assert.assertEquals("Chris",customer.getFname());
    }

    @Test
    public void updateCustomer() throws Exception
    {
        Map<String,String> customer1 = new HashMap<String, String>();
        customer1.put("fname","Chris");
        customer1.put("lname","Harris");
        customer1.put("number","0768848797");
        customer1.put("address", "87 Heath Street, Cape Town");

        Customer customer = CustomerFactory.createCustomer(customer1);

        Customer customer2 = new Customer.Build(customer.getFname()).copy(customer).number("0768488797").build();

        Assert.assertEquals("Chris",customer.getFname());
        Assert.assertEquals("0768488797",customer2.getNumber());
    }
}
