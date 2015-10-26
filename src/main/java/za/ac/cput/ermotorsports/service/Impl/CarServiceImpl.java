package za.ac.cput.ermotorsports.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ermotorsports.domain.Car;
import za.ac.cput.ermotorsports.repository.CarRepository;
import za.ac.cput.ermotorsports.service.CarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
@Service
public class CarServiceImpl implements CarService
{
    @Autowired
    private CarRepository repository;

    @Override
    public Car findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Car save(Car entity) {
        return repository.save(entity);
    }

    @Override
    public Car update(Car entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Car entity) {
        repository.delete(entity);
    }

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<Car>();
        Iterable<Car> car = repository.findAll();
        for(Car car1:car)
        {
            carList.add(car1);
        }
        return carList;
    }
}
