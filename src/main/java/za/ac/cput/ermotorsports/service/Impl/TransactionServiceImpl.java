package za.ac.cput.ermotorsports.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.ermotorsports.domain.Transaction;
import za.ac.cput.ermotorsports.repository.TransactionRepository;
import za.ac.cput.ermotorsports.service.TransactionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edmund.Simons on 15/10/2015.
 */
public class TransactionServiceImpl implements TransactionService
{
    @Autowired
    TransactionRepository repository;

    public List<Transaction> getTransactions() {
        List<Transaction> allTransactions = new ArrayList<Transaction>();
        Iterable<Transaction> transactions = repository.findAll();
        for(Transaction transaction:transactions)
        {
            allTransactions.add(transaction);
        }
        return allTransactions;
    }
}
