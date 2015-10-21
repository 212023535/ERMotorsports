package za.ac.cput.ermotorsports.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.CustomerFactory;
import za.ac.cput.ermotorsports.domain.Customer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edmund on 2015/10/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CustomerCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    @Autowired
    private CustomerRepository repository;

    @Test
    public void create() throws Exception
    {
        Map<String,String> customer1 = new HashMap<String, String>();
        customer1.put("fname","Chris");
        customer1.put("lname","Harris");
        customer1.put("number","0768848797");
        customer1.put("address", "87 Heath Street, Cape Town");

        Customer customer = CustomerFactory.createCustomer(customer1);
        repository.save(customer);
        Assert.assertNotNull(customer.getId());
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception
    {
        Customer cust = (Customer)this.repository.findOne(this.id);
        Assert.assertNotNull(cust);
        Assert.assertEquals("Chris", cust.getFname());
    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception
    {
        Customer cust = (Customer)this.repository.findOne(this.id);
        Customer newCust = new Customer.Build(cust.getFname()).copy(cust).address("89 Heath Street, Cape Town").build();
        this.repository.save(newCust);

        Customer updatedCust = (Customer)this.repository.findOne(this.id);
        Assert.assertEquals("89 Heath Street, Cape Town", updatedCust.getAddress());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception
    {
        Customer cust = (Customer)this.repository.findOne(this.id);
        this.repository.delete(cust);

        Customer delCust = (Customer)this.repository.findOne(this.id);
        Assert.assertNull(delCust);

    }
}
