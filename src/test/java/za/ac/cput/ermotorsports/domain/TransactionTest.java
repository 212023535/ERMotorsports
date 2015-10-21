package za.ac.cput.ermotorsports.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.ermotorsports.conf.factory.TransactionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class TransactionTest
{
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void createTransaction() throws Exception
    {
        Long car_id = 0L;
        Long cust_id = 0L;
        Transaction transaction = TransactionFactory.createTransaction("R10000", car_id, cust_id);

        Assert.assertNotNull(transaction);
        Assert.assertEquals("R10000",transaction.getAmount());
    }

    @Test
    public void updateTransaction() throws Exception
    {
        Long car_id = 0L;
        Long cust_id = 0L;
        Transaction transaction = TransactionFactory.createTransaction("R10000", car_id, cust_id);

        Assert.assertNotNull(transaction);
        Assert.assertEquals("R10000",transaction.getAmount());
        Transaction transaction1 = new Transaction.Build(transaction.getAmount()).copy(transaction).amount("R5000").build();

        Assert.assertNotNull(transaction);
        Assert.assertEquals("R10000", transaction.getAmount());
        Assert.assertNotNull(transaction1);
        Assert.assertEquals("R5000", transaction1.getAmount());
        System.out.println("Before " + transaction.getAmount());
        System.out.println("After " + transaction1.getAmount());
    }
}
