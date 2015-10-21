package za.ac.cput.ermotorsports.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Rudi.Zeeman on 13.10.15.
 */
@Entity
public final class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fname;
    private String lname;
    private String number;
    private String address;


    private Customer()
    {

    }

    private Customer(Build build)
    {
        id = build.id;
        fname = build.fname;
        lname = build.lname;
        number = build.number;
        address = build.address;
    }

    public static class Build
    {

        private Long id;
        private String fname;
        private String lname;
        private String number;
        private String address;

        public Build copy(Customer customer)
        {
            this.id = customer.id;
            this.fname = customer.fname;
            this.lname = customer.lname;
            this.number = customer.number;
            this.address = customer.address;

            return this;
        }

        //Mandatory Builder
        public Build(String fName){this.fname = fName;}
        //Getters
        public Build id(Long id)
        {
            this.id = id;
            return this;
        }

        public Build lname(String lname)
        {
            this.lname = lname;
            return this;
        }

        public Build number(String number)
        {
            this.number = number;
            return this;
        }

        public Build address(String address)
        {
            this.address = address;
            return this;
        }

        public Customer build(){return new Customer(this);}
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id.equals(customer.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
