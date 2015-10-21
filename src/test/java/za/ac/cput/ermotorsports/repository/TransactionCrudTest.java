package za.ac.cput.ermotorsports.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.TransactionFactory;
import za.ac.cput.ermotorsports.domain.Transaction;

/**
 * Created by Edmund on 2015/10/18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TransactionCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    @Autowired
    private TransactionRepository repository;

    @Test
    public void create() throws Exception
    {
        Long car_id = 0L;
        Long cust_id = 0L;
        Transaction transaction = TransactionFactory.createTransaction("R10000", car_id, cust_id);

        repository.save(transaction);
        Assert.assertNotNull(transaction);
        //Assert.assertEquals("R10000",transaction.getAmount());
    }
}
