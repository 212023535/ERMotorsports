package za.ac.cput.ermotorsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.ermotorsports.domain.Transaction;
import za.ac.cput.ermotorsports.service.TransactionService;

import java.util.List;

/**
 * Created by Rudi.Zeeman on 22.10.15.
 */
@RestController
@RequestMapping("/transaction/**")
public class TransactionPage
{
    @Autowired
    private TransactionService service;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public List<Transaction> getTransaction(@PathVariable Long id)
    {
        return service.findAll();
    }

    //-------------------Retrieve Single Transaction--------------------------------------------------------
    @RequestMapping(value = "/transaction/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> getTransaction(@PathVariable("id") long id)
    {
        System.out.println("Fetching transaction with id " + id);
        Transaction transaction = service.findById(id);

        if(transaction == null)
        {
            System.out.println("transaction with id " + id + " not found");
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }

    //-------------------Retrieve All Transaction--------------------------------------------------------

    @RequestMapping(value = "/transaction/", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> listTransactions() {
        List<Transaction> transactions = service.findAll();
        if(transactions.isEmpty()){
            return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
    }


    //-------------------Create a Transaction--------------------------------------------------------

    @RequestMapping(value = "/transaction/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createTransactions(@RequestBody Transaction transaction,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating transaction " + transaction.getTransNo());

        service.save(transaction);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/transaction/{id}").buildAndExpand(transaction.getTransNo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Transaction --------------------------------------------------------

    @RequestMapping(value = "/transaction/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction2) {
        System.out.println("Updating transaction " + id);

        Transaction transaction = service.findById(id);

        if (transaction==null) {
            System.out.println("List with id " + id + " not found");
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }

        Transaction updatedtransaction = new Transaction
                .Build(transaction.getAmount())
                .copy(transaction)
                .build();
        service.update(updatedtransaction);
        return new ResponseEntity<Transaction>(updatedtransaction, HttpStatus.OK);
    }

    //------------------- Delete a Transaction --------------------------------------------------------

    @RequestMapping(value = "/transaction/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting transaction with id " + id);

        Transaction transaction = service.findById(id);
        if (transaction == null) {
            System.out.println("Unable to delete. transaction with id " + id + " not found");
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }

        service.delete(transaction);
        return new ResponseEntity<Transaction>(HttpStatus.NO_CONTENT);
    }
}
