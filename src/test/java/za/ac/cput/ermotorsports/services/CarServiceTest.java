package za.ac.cput.ermotorsports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.CarFactory;
import za.ac.cput.ermotorsports.domain.Car;
import za.ac.cput.ermotorsports.service.CarService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CarServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private CarService service;

    @Test
    public void create() throws Exception
    {
        Map<String,String> BMW = new HashMap<String, String>();
        BMW.put("brand","BMW");
        BMW.put("year","2015");
        BMW.put("model","F82 M4");
        BMW.put("colour","Alpine White");

        //Create Car
        Car bmw = CarFactory.createCar(BMW);

        //Save Car
        service.save(bmw);

        //ID Should not be null
        id = bmw.getId();

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        //Get car
        Car car = service.findById(id);

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        //Get car
        Car car = service.findById(id);

        //Change car
        Car newCar = new Car.Builder(car.getBrand()).copy(car).colour("Azure Blue").build();

        //Save it
        service.save(newCar);

        //Get updatedCar
        Car updatedCar = service.findById(id);

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        //Get car
        Car car = service.findById(id);

        //Delete car
        service.delete(car);

        //Get deleted car
        Car deletedCar = service.findById(id);

        Assert.assertNull(deletedCar);
    }
}
