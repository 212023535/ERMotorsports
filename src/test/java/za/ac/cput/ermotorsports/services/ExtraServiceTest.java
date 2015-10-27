package za.ac.cput.ermotorsports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.ExtraFactory;
import za.ac.cput.ermotorsports.domain.Extra;
import za.ac.cput.ermotorsports.service.ExtraService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi.Zeeman on 27.10.15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ExtraServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private ExtraService service;

    @Test
    public void create() throws Exception
    {
        //Create Extra
        Map<String,String> ex1 = new HashMap<String, String>();
        ex1.put("brand","Simota");
        ex1.put("price","R199");
        ex1.put("units","27");
        ex1.put("description","Flat-Bed Air Filter");

        Extra extra = ExtraFactory.createExtra(ex1);

        //Save to DB
        service.save(extra);

        //Get Extra
        id = extra.getId();

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        //Get extra
        Extra extra = service.findById(id);

        //Test not null
        Assert.assertNotNull(extra);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        //Get extra
        Extra extra = service.findById(id);

        //Change extra
        Extra newExtra = new Extra.Build(extra.getBrand()).copy(extra).price("R299").build();

        //Save
        service.save(newExtra);

        //Get updated extra
        Extra updatedExtra = service.findById(id);

        Assert.assertNotNull(updatedExtra);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        //Get extra
        Extra extra = service.findById(id);

        service.delete(extra);

        //Get deleted extra
        Extra deletedExtra = service.findById(id);

        Assert.assertNull(deletedExtra);
    }
}
