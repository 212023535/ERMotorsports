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
}
