package za.ac.cput.ermotorsports.service;

import za.ac.cput.ermotorsports.domain.Transaction;

import java.util.List;

/**
 * Created by Edmund.Simons on 15/10/2015.
 */
public interface TransactionService
{
    List<Transaction> getTransactions();
}
