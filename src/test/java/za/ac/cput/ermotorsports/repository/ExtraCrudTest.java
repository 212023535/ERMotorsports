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
}
