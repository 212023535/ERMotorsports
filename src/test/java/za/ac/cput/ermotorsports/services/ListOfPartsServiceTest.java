package za.ac.cput.ermotorsports.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import za.ac.cput.ermotorsports.App;
import za.ac.cput.ermotorsports.conf.factory.ListOfPartFactory;
import za.ac.cput.ermotorsports.domain.ListOfParts;
import za.ac.cput.ermotorsports.repository.ListOfPartsRepository;
import za.ac.cput.ermotorsports.service.ListOfPartsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudi.Zeeman on 21.10.15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ListOfPartsServiceTest  extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private ListOfPartsService service;

    @Autowired
    private ListOfPartsRepository repository;


    @Test
    public void create() throws Exception
    {
        Long car = 1L;
        Long engine = 1L;
        Long extra = 1L;

        //Create a List of Parts
        ListOfParts listOfParts = ListOfPartFactory.createListOfParts(car,engine,extra);

        //Save in the database
        repository.save(listOfParts);

        //ID should be available
        id = listOfParts.getList_id();

        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        //Get list of parts
        ListOfParts listOfParts = (ListOfParts)this.repository.findOne(id);
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        //Get list of parts
        ListOfParts listOfParts = (ListOfParts)this.repository.findOne(this.id);

        //Change it
        ListOfParts newListOfParts = new ListOfParts.Build(listOfParts.getList_id()).copy(listOfParts).partID(2L).build();

        //Save it
        this.repository.save(newListOfParts);

        //Get updated LOP
        ListOfParts updatedListOfParts = repository.findOne(this.id);

        Assert.assertNotNull(updatedListOfParts);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        //Get list of parts
        ListOfParts listOfParts = repository.findOne(this.id);
        this.repository.delete(listOfParts);

        ListOfParts deletedLOP = repository.findOne(id);
        Assert.assertNull(deletedLOP);
    }

    @Test
    public void testGetListOfParts() throws Exception
    {
        List<ListOfParts> myList = service.getListOfParts();
        Assert.assertTrue(myList.size() >= 0);
    }
}
