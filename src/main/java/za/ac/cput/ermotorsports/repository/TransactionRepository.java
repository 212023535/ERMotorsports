package za.ac.cput.ermotorsports.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.ermotorsports.domain.Transaction;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long>
{

}
