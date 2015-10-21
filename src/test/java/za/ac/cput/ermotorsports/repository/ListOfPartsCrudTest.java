package za.ac.cput.ermotorsports.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.CarFactory;
import za.ac.cput.ermotorsports.conf.factory.EngineFactory;
import za.ac.cput.ermotorsports.conf.factory.ExtraFactory;
import za.ac.cput.ermotorsports.conf.factory.ListOfPartFactory;
import za.ac.cput.ermotorsports.domain.Car;
import za.ac.cput.ermotorsports.domain.Engine;
import za.ac.cput.ermotorsports.domain.Extra;
import za.ac.cput.ermotorsports.domain.ListOfParts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edmund on 2015/10/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ListOfPartsCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    @Autowired
    private ListOfPartsRepository repository;

    @Test
    public void create() throws Exception
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
        repository.save(listOfParts);
        id = listOfParts.getList_id();
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception
    {
        ListOfParts list = (ListOfParts)this.repository.findOne(this.id);
        Assert.assertNotNull(list);
    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception
    {
        ListOfParts list = (ListOfParts)this.repository.findOne(this.id);
        ListOfParts newList = new ListOfParts.Build(list.getCar_id()).copy(list).engineNo(1L).build();
        this.repository.save(newList);

        //ListOfParts updatedList = (ListOfParts)this.repository.findOne(this.id);
        //Assert.assertEquals(1L, updatedList.getEngineNo());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception
    {
        ListOfParts list = (ListOfParts)this.repository.findOne(this.id);
        this.repository.delete(list);

        ListOfParts deletedList = (ListOfParts)this.repository.findOne(this.id);
        Assert.assertNull(deletedList);

    }
}
