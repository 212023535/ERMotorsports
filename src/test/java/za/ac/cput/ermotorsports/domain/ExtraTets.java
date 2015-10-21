package za.ac.cput.ermotorsports.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.ermotorsports.conf.factory.ExtraFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 15.10.15.
 */
public class ExtraTets
{
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createExtra() throws Exception
    {
        Map<String,String> ex1 = new HashMap<String, String>();
        ex1.put("brand","Simota");
        ex1.put("price","R199");
        ex1.put("units","27");
        ex1.put("description","Flat-Bed Air Filter");

        Extra extra = ExtraFactory.createExtra(ex1);

        Assert.assertEquals("Simota",extra.getBrand());
    }

    @Test
    public void updateExtra() throws Exception
    {
        Map<String,String> ex1 = new HashMap<String, String>();
        ex1.put("brand","Simota");
        ex1.put("price","R199");
        ex1.put("units","27");
        ex1.put("description","Flat-Bed Air Filter");

        Extra extra = ExtraFactory.createExtra(ex1);

        Extra extra1 = new Extra.Build(extra.getPrice()).copy(extra).price("R220").build();

        Assert.assertEquals("Simota",extra.getBrand());
        Assert.assertEquals("R220",extra1.getPrice());
    }
}
