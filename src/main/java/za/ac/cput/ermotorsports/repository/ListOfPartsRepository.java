package za.ac.cput.ermotorsports.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.ermotorsports.domain.ListOfParts;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public interface ListOfPartsRepository extends CrudRepository<ListOfParts,Long> {
}
