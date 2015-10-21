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

    public Transaction findById(Long ID) {
        return repository.findOne(ID);
    }

    public Transaction save(Transaction entity) {
        return repository.save(entity);
    }

    public Transaction update(Transaction entity) {
        return repository.save(entity);
    }

    public void delete(Transaction entity) {
        repository.delete(entity);
    }

    public List<Transaction> findAll() {
        List<Transaction> allTransactions = new ArrayList<Transaction>();
        Iterable<Transaction> transactions = repository.findAll();
        for(Transaction transaction:transactions)
        {
            allTransactions.add(transaction);
        }
        return allTransactions;
    }
}
