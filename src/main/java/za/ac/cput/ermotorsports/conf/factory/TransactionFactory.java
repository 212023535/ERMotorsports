package za.ac.cput.ermotorsports.conf.factory;

import za.ac.cput.ermotorsports.domain.Customer;
import za.ac.cput.ermotorsports.domain.Transaction;

import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class TransactionFactory
{
    public static Transaction createTransaction(String amount, Long car_id, Long cust_id)
    {
        Transaction transaction = new Transaction.Build(amount)
                .car(car_id)
                .customer(cust_id).build();
        return transaction;
    }
}
