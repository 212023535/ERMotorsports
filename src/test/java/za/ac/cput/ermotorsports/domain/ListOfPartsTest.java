package za.ac.cput.ermotorsports.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.ermotorsports.conf.factory.CarFactory;
import za.ac.cput.ermotorsports.conf.factory.EngineFactory;
import za.ac.cput.ermotorsports.conf.factory.ExtraFactory;
import za.ac.cput.ermotorsports.conf.factory.ListOfPartFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class ListOfPartsTest
{
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createListOfParts() throws Exception
    {
        //Create Part
        Map<String,String> ex1 = new HashMap<String, String>();
        ex1.put("brand","Simota");
        ex1.put("price","R199");
        ex1.put("units","27");
        ex1.put("description","Flat-Bed Air Filter");
        Extra extra = ExtraFactory.createExtra(ex1);

        //Create Engine
        Map<String,String> en1 = new HashMap<String, String>();
        en1.put("cubicCapacity","4.0L");
        en1.put("units","3");
        en1.put("cylinders","8");
        en1.put("price","R47500.00");
        en1.put("brand","BMW");
        en1.put("model","S65 V8");

        Engine engine = EngineFactory.createEngine(en1);

        //Create Car
        Map<String,String> BMW = new HashMap<String, String>();
        BMW.put("brand","BMW");
        BMW.put("year","2015");
        BMW.put("model","F82 M4");
        BMW.put("colour","Alpine White");

        Car bmw = CarFactory.createCar(BMW);

        ListOfParts listOfParts = ListOfPartFactory.createListOfParts(bmw.getId(), engine.getId(), extra.getId());

        Assert.assertNotNull(listOfParts);
    }

    @Test
    public void updateListOfParts() throws Exception
    {
        //Create Part
        Map<String,String> ex1 = new HashMap<String, String>();
        ex1.put("brand","Simota");
        ex1.put("price","R199");
        ex1.put("units","27");
        ex1.put("description","Flat-Bed Air Filter");
        Extra extra = ExtraFactory.createExtra(ex1);

        //Create Engine
        Map<String,String> en1 = new HashMap<String, String>();
        en1.put("cubicCapacity","4.0L");
        en1.put("units","3");
        en1.put("cylinders","8");
        en1.put("price","R47500.00");
        en1.put("brand","BMW");
        en1.put("model","S65 V8");
        Engine engine = EngineFactory.createEngine(en1);

        //Create Engine
        Map<String,String> en2 = new HashMap<String, String>();
        en2.put("cubicCapacity","6.0L");
        en2.put("units","8");
        en2.put("cylinders","8");
        en2.put("price","R45500.00");
        en2.put("brand","Chevrolet");
        en2.put("model","LS6");
        Engine engine2 = EngineFactory.createEngine(en2);

        //Create Car
        Map<String,String> BMW = new HashMap<String, String>();
        BMW.put("brand","BMW");
        BMW.put("year","2015");
        BMW.put("model","F82 M4");
        BMW.put("colour","Alpine White");
        Car bmw = CarFactory.createCar(BMW);

        ListOfParts listOfParts = ListOfPartFactory.createListOfParts(bmw.getId(), engine.getId(), extra.getId());

        //ListOfParts listOfParts1 = new ListOfParts.Build(listOfParts.getId()).copy(listOfParts).id(engine2).build();

        Assert.assertNotNull(listOfParts);
        //Assert.assertNotNull(listOfParts1);
    }
}
