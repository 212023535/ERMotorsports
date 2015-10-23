package za.ac.cput.ermotorsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/transaction/",method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> listAllTransactions(){
        List<Transaction> transaction = service.findAll();
        if(transaction.isEmpty())
        {
            return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
    }
}
