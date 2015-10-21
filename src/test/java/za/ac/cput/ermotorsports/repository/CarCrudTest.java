package za.ac.cput.ermotorsports.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.CarFactory;
import za.ac.cput.ermotorsports.domain.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edmund.Simons on 16/10/2015.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CarCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private CarRepository repository;

    @Test
    public void create() throws Exception
    {
        Map<String, String> value = new HashMap<String, String>();
        value.put("brand", "BMW");
        value.put("year", "2015");
        value.put("model", "F82 M4");
        value.put("colour", "Alpine White");

        Car car = CarFactory.createCar(value);
        Assert.assertNotNull(car);
        System.out.println(car);

        repository.save(car);
        id = car.getId();
        Assert.assertNotNull(car);
    }
}