package za.ac.cput.ermotorsports.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Rudi.Zeeman on 13.10.15.
 */
@Entity
public final class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String amount;
    private Long car_id;
    private Long cust_id;

    private Transaction()
    {
    }

    private Transaction(Build build)
    {
        id = build.id;
        amount = build.amount;
        car_id = build.car_id;
        cust_id = build.cust_id;
    }

    public static class Build
    {
        private Long id;
        private String amount;
        private Long car_id;
        private Long cust_id;

        public Build copy(Transaction transaction)
        {
            this.id = transaction.id;
            this.amount = transaction.amount;
            this.car_id = transaction.car_id;
            this.cust_id = transaction.cust_id;

            return this;
        }

        //Mandatory builder
        public Build(String amount){this.amount = amount;}

        //Getters
        public Build transNo(Long id)
        {
            this.id = id;
            return this;
        }

        public Build amount(String amount)
        {
            this.amount = amount;
            return this;
        }

        public Build car(Long car_id)
        {
            this.car_id = car_id;
            return this;
        }

        public Build customer(Long cust_id)
        {
            this.cust_id = cust_id;
            return this;
        }

        public Transaction build(){return new Transaction(this);}
    }

    //Getters

    public Long getTransNo() {
        return id;
    }

    public String getAmount() {
        return amount;
    }

    public Long getCar_id() {
        return car_id;
    }

    public Long getCust_id() {
        return cust_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction transaction = (Transaction) o;

        return id.equals(transaction.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount='" + amount + '\'' +
                ", car_id=" + car_id +
                ", cust_id=" + cust_id +
                '}';
    }
}
