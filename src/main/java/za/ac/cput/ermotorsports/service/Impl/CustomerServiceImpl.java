package za.ac.cput.ermotorsports.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.ermotorsports.domain.Customer;
import za.ac.cput.ermotorsports.repository.CustomerRepository;
import za.ac.cput.ermotorsports.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer update(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Customer entity) {
        repository.delete(entity);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> allCustomers = new ArrayList<Customer>();
        Iterable<Customer> list = repository.findAll();

        for(Customer cust: list)
        {
            allCustomers.add(cust);
        }
        return allCustomers;
    }
}
