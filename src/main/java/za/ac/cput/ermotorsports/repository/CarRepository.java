package za.ac.cput.ermotorsports.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.ermotorsports.domain.Car;

/**
 * Created by Edmund.Simons on 15/10/2015.
 */
public interface CarRepository extends CrudRepository<Car, Long>
{
}
