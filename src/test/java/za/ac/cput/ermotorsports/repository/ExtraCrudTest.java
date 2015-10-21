package za.ac.cput.ermotorsports.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.ExtraFactory;
import za.ac.cput.ermotorsports.domain.Extra;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edmund on 2015/10/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ExtraCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    @Autowired
    ExtraRepository repository;

    @Test
    public void create() throws Exception
    {
        Map<String,String> ex1 = new HashMap<String, String>();
        ex1.put("brand","Simota");
        ex1.put("price","R199");
        ex1.put("units","27");
        ex1.put("description", "Flat-Bed Air Filter");

        Extra extra = ExtraFactory.createExtra(ex1);
        repository.save(extra);
        Assert.assertNotNull(extra.getId());
    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception
    {
        Extra extra = (Extra)this.repository.findOne(this.id);
        Extra newExtra = new Extra.Build(extra.getBrand()).copy(extra).units("32").build();
        this.repository.save(newExtra);

        Extra updatedExtra = (Extra)this.repository.findOne(this.id);
        Assert.assertEquals("32", updatedExtra.getUnits());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception
    {
        Extra extra = (Extra)this.repository.findOne(this.id);
        this.repository.delete(extra);

        Extra deletedExtra = (Extra)this.repository.findOne(this.id);
        Assert.assertNull(deletedExtra);

    }
}
