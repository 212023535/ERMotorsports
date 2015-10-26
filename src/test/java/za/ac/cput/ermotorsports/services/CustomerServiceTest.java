package za.ac.cput.ermotorsports.services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.CustomerFactory;
import za.ac.cput.ermotorsports.domain.Customer;
import za.ac.cput.ermotorsports.service.CustomerService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private CustomerService service;

    @Test
    public void create() throws Exception
    {
        Map<String,String> customer1 = new HashMap<String, String>();
        customer1.put("fname","Chris");
        customer1.put("lname","Harris");
        customer1.put("number","0768848797");
        customer1.put("address", "87 Heath Street, Cape Town");

        //Create customer
        Customer customer = CustomerFactory.createCustomer(customer1);

        //Save in database
        service.save(customer);

        //ID should not be null
        id = customer.getId();

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        //Get customer
        Customer customer = service.findById(id);
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        //Get customer
        Customer customer = service.findById(id);

        //Change customer
        Customer newCust = new Customer.Build(customer.getFname()).copy(customer).lname("Johnson").build();

        //Save it
        service.save(newCust);

        //Get updated customer
        Customer updatedCust = service.findById(id);

        Assert.assertNotNull(updatedCust);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        //Get customer
        Customer customer = service.findById(id);

        //Delete customer
        service.delete(customer);

        Customer deletedCust = service.findById(id);

        Assert.assertNotNull(deletedCust);
    }


}
