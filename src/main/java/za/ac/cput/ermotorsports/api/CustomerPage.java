package za.ac.cput.ermotorsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.ermotorsports.domain.Customer;
import za.ac.cput.ermotorsports.service.CustomerService;

import java.util.List;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
@RestController
@RequestMapping(value="/Customer/**")
public class CustomerPage
{
    @Autowired
    CustomerService service;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public List<Customer> getCustomer (@PathVariable Long id)
    {
        return service.findAll();
    }

    //-------------------Retrieve Single Customer--------------------------------------------------------
    @RequestMapping(value = "/Customer/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id)
    {
        System.out.println("Fetching Customer with id " + id);
        Customer customer = service.findById(id);

        if(customer == null)
        {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    //-------------------Retrieve All Customers--------------------------------------------------------

    @RequestMapping(value = "/Customer/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomer() {
        List<Customer> customerList = service.findAll();
        if(customerList.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }


    //-------------------Create a Customer--------------------------------------------------------

    @RequestMapping(value = "/Customer/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating List " + customer.getId());

        service.save(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Customer --------------------------------------------------------

    @RequestMapping(value = "/Customer/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        System.out.println("Updating Customer " + id);

        Customer customer2 = service.findById(id);

        if (customer2==null) {
            System.out.println("customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        Customer updatedCustomer = new Customer
                .Build(customer2.getFname())
                .copy(customer2)
                .build();
        service.update(updatedCustomer);
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }

    //------------------- Delete a Customer --------------------------------------------------------

    @RequestMapping(value = "/Customer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Customer customer = service.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        service.delete(customer);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}
