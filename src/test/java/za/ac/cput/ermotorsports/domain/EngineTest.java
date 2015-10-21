package za.ac.cput.ermotorsports.domain;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import za.ac.cput.ermotorsports.conf.factory.EngineFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class EngineTest
{
    int id = 1;
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createEngine() throws Exception
    {
        Map<String,String> en1 = new HashMap<String, String>();
        en1.put("cubicCapacity","4.0L");
        en1.put("units","3");
        en1.put("cylinders","8");
        en1.put("price","R47500.00");
        en1.put("brand","BMW");
        en1.put("model","S65 V8");

        Engine engine = EngineFactory.createEngine(en1);

        Assert.assertEquals("BMW",engine.getBrand());
    }

    @Test
    public void updateEngine() throws Exception
    {
        Map<String,String> en1 = new HashMap<String, String>();
        en1.put("cubicCapacity","4.0L");
        en1.put("units","3");
        en1.put("cylinders","8");
        en1.put("price","R47500.00");
        en1.put("brand","BMW");
        en1.put("model","S65 V8");

        Engine engine = EngineFactory.createEngine(en1);

        Engine engine1 = new Engine.Build(engine.getPrice()).copy(engine).price("R45000").build();

        Assert.assertEquals("BMW",engine.getBrand());
        Assert.assertEquals("R45000",engine1.getPrice());
    }
}
