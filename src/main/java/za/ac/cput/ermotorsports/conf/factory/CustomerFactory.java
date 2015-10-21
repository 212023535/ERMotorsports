package za.ac.cput.ermotorsports.conf.factory;

import za.ac.cput.ermotorsports.domain.Customer;

import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class CustomerFactory
{
    public static Customer createCustomer(Map<String,String> value)
    {
        Customer customer = new Customer.Build(value.get("fname"))
                .address(value.get("address"))
                .lname(value.get("lname"))
                .number(value.get("number")).build();
        return customer;
    }
}
