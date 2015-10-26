package za.ac.cput.ermotorsports.services;

import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.EngineFactory;
import za.ac.cput.ermotorsports.domain.Engine;
import za.ac.cput.ermotorsports.service.EngineService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class EngineServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private EngineService service;

    @Test
    public void create() throws Exception
    {
        Map<String,String> en1 = new HashMap<String, String>();
        en1.put("cubicCapacity","4.0L");
        en1.put("units","3");
        en1.put("cylinders","8");
        en1.put("price","R47500.00");
        en1.put("brand","BMW");
        en1.put("model","S65 V8");

        //Create engine
        Engine engine = EngineFactory.createEngine(en1);

        //Save engine
        service.save(engine);

        //ID should not be null
        id = engine.getId();

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        //Get engine
        Engine engine = service.findById(id);

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        //Get engine
        Engine engine = service.findById(id);

        //Change engine
        Engine newEngine = new Engine.Build(engine.getBrand()).copy(engine).cylinders("10").build();

        //Save it
        service.save(newEngine);

        Engine updateEngine = service.findById(id);

        Assert.assertNotNull(updateEngine);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        //Get engine
        Engine engine = service.findById(id);

        //Delete engine
        service.delete(engine);

        //Get deleted engine
        Engine deletedEngine = service.findById(id);

        Assert.assertNull(deletedEngine);
    }
}
