package za.ac.cput.ermotorsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.ermotorsports.domain.Transaction;
import za.ac.cput.ermotorsports.service.TransactionService;

import java.util.List;

/**
 * Created by Rudi.Zeeman on 22.10.15.
 */
@RestController
@RequestMapping("/api/**")
public class TransactionPage
{
    @Autowired
    TransactionService service;

    @RequestMapping(value = "transaction",method = RequestMethod.GET)
    public String Index(){return "This is a transaction page";}

    @RequestMapping(value = "/transaction",method = RequestMethod.GET)
    public Transaction getTransaction(){
        Transaction transaction = new Transaction.Build("R10000").car(1L).customer(2L).transNo(3L).build();

        return transaction;
    }

    @RequestMapping(value = "transactions",method = RequestMethod.GET)
    public List<Transaction> getTransactions(){return service.getTransactions();}
}
