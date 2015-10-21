package za.ac.cput.ermotorsports.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.EngineFactory;
import za.ac.cput.ermotorsports.domain.Engine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edmund on 2015/10/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class EngineCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    @Autowired
    EngineRepository repository;

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

        Engine engine = EngineFactory.createEngine(en1);
        repository.save(engine);
        Assert.assertNotNull(engine.getId());
    }
}
