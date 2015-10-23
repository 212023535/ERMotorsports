package za.ac.cput.ermotorsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.ermotorsports.domain.ListOfParts;
import za.ac.cput.ermotorsports.service.ListOfPartsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Rudi.Zeeman on 22.10.15.
 */
@RestController
@RequestMapping(value="/listOfParts/**")
public class ListOfPartsPage
{
    @Autowired
    private ListOfPartsService service;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public List<ListOfParts> getPartsList(@PathVariable Long id)
    {
        return service.findAll();
    }

    //-------------------Retrieve Single List of Parts--------------------------------------------------------
    @RequestMapping(value = "/listOfParts/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListOfParts> getListOfParts(@PathVariable("id") long id)
    {
        System.out.println("Fetching Part List with id " + id);
        ListOfParts listOfParts = service.findById(id);

        if(listOfParts == null)
        {
            System.out.println("List with id " + id + " not found");
            return new ResponseEntity<ListOfParts>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ListOfParts>(listOfParts, HttpStatus.OK);
    }

    //-------------------Retrieve All Lists of Parts--------------------------------------------------------

    @RequestMapping(value = "/listOfParts/", method = RequestMethod.GET)
    public ResponseEntity<List<ListOfParts>> listAllListsOfParts() {
        List<ListOfParts> partsList = service.findAll();
        if(partsList.isEmpty()){
            return new ResponseEntity<List<ListOfParts>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ListOfParts>>(partsList, HttpStatus.OK);
    }


    //-------------------Create a ListOfParts--------------------------------------------------------

    @RequestMapping(value = "/listOfParts/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createList(@RequestBody ListOfParts listOfParts,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating List " + listOfParts.getList_id());

        service.save(listOfParts);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/listOfParts/{id}").buildAndExpand(listOfParts.getList_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a List Of Parts --------------------------------------------------------

    @RequestMapping(value = "/listOfParts/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ListOfParts> updateListOfParts(@PathVariable("id") long id, @RequestBody ListOfParts listOfPart) {
        System.out.println("Updating listOfParts " + id);

        ListOfParts listOfParts = service.findById(id);

        if (listOfParts==null) {
            System.out.println("List with id " + id + " not found");
            return new ResponseEntity<ListOfParts>(HttpStatus.NOT_FOUND);
        }

        ListOfParts updatedListOfParts = new ListOfParts
                .Build(listOfParts.getList_id())
                .copy(listOfParts)
                .build();
        service.update(updatedListOfParts);
        return new ResponseEntity<ListOfParts>(updatedListOfParts, HttpStatus.OK);
    }

    //------------------- Delete a List --------------------------------------------------------

    @RequestMapping(value = "/listOfParts/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ListOfParts> deleteListOfParts(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting listOfParts with id " + id);

        ListOfParts listOfParts = service.findById(id);
        if (listOfParts == null) {
            System.out.println("Unable to delete. listOfParts with id " + id + " not found");
            return new ResponseEntity<ListOfParts>(HttpStatus.NOT_FOUND);
        }

        service.delete(listOfParts);
        return new ResponseEntity<ListOfParts>(HttpStatus.NO_CONTENT);
    }

}
