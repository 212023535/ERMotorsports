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
        return service.getListOfParts();
    }

    //-------------------Retrieve Single Subject--------------------------------------------------------
    /*@RequestMapping(value = "/listOfParts/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListOfParts> getListOfParts(@PathVariable("id") long id)
    {
        System.out.println("Fetching Part List with id " + id);
        ListOfParts listOfParts = service.
    }*/


}
