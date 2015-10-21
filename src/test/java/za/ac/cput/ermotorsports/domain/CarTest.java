package za.ac.cput.ermotorsports.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ermotorsports.conf.factory.CarFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class CarTest
{
    @Test
    public void setUp() throws Exception {
        
    }

    @Test
    public void createCar() throws Exception
    {
        Map<String,String> BMW = new HashMap<String, String>();
        BMW.put("brand","BMW");
        BMW.put("year","2015");
        BMW.put("model","F82 M4");
        BMW.put("colour","Alpine White");

        Car bmw = CarFactory.createCar(BMW);
        Assert.assertEquals("Alpine White",bmw.getColour());
        System.out.println(bmw);
    }

    @Test
    public void updateCar() throws Exception
    {
        Map<String,String> BMW = new HashMap<String, String>();
        BMW.put("brand","BMW");
        BMW.put("year","2015");
        BMW.put("model","F82 M4");
        BMW.put("colour","Alpine White");

        Car bmw = CarFactory.createCar(BMW);

        Car bmw2 = new Car.Builder(bmw.getColour()).copy(bmw).colour("Azure Blue").build();

        Assert.assertEquals("Alpine White",bmw.getColour());
        Assert.assertEquals("Azure Blue",bmw2.getColour());
    }
}
