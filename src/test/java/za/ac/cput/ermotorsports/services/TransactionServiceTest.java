package za.ac.cput.ermotorsports.services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.TransactionFactory;
import za.ac.cput.ermotorsports.domain.Transaction;
import za.ac.cput.ermotorsports.repository.TransactionRepository;
import za.ac.cput.ermotorsports.service.TransactionService;

/**
 * Created by Rudi.Zeeman on 21.10.15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TransactionServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    TransactionService service;

    @Autowired
    TransactionRepository repository;

    @Test
    public void create() throws Exception
    {

        String amount = "R10000";
        Long car_id = null;
        Long cust_id = null;

        //Create a Transaction
        Transaction transaction = TransactionFactory.createTransaction(amount,car_id,cust_id);

        //Save in the database
        repository.save(transaction);

        //ID should be available
        id = transaction.getTransNo();

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        //Get transaction
        Transaction transaction = (Transaction)this.repository.findOne(id);
        Assert.assertEquals("R10000",transaction.getAmount());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Long car_id = null;
        Long cust_id = null;

        //Get transaction
        Transaction transaction = repository.findOne(id);

        //Change it
        Transaction newTransaction = new Transaction.Build(transaction.getAmount()).copy(transaction).amount("R5000").build();

        //Save it
        this.repository.save(newTransaction);

        //Get updated transaction
        Transaction updatedTransaction = repository.findOne(id);

        Assert.assertEquals("R5000",updatedTransaction.getAmount());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        //Get transaction
        Transaction transaction = repository.findOne(id);
        this.repository.delete(transaction);
        Transaction deletedTransaction = repository.findOne(id);
        Assert.assertNull(deletedTransaction);
    }
}
