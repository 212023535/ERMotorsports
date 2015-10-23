package za.ac.cput.ermotorsports.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ermotorsports.domain.Transaction;
import za.ac.cput.ermotorsports.repository.TransactionRepository;
import za.ac.cput.ermotorsports.service.TransactionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edmund.Simons on 15/10/2015.
 */
@Service
public class TransactionServiceImpl implements TransactionService
{
    @Autowired
    private TransactionRepository repository;

    @Override
    public Transaction findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Transaction save(Transaction entity) {
        return repository.save(entity);
    }

    @Override
    public Transaction update(Transaction entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Transaction entity) {
        repository.delete(entity);
    }

    @Override
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
