package za.ac.cput.ermotorsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.ermotorsports.domain.Extra;
import za.ac.cput.ermotorsports.service.ExtraService;

import java.util.List;

/**
 * Created by Rudi.Zeeman on 27.10.15.
 */
@RestController
@RequestMapping(value="/Extra/**")
public class ExtraPage
{
    @Autowired
    private ExtraService service;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public List<Extra> getExtras(@PathVariable Long id)
    {
        return service.findAll();
    }

    //-------------------Retrieve Single Extra--------------------------------------------------------
    @RequestMapping(value = "/Extra/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Extra> getExtras(@PathVariable("id") long id)
    {
        System.out.println("Fetching Extra with id " + id);
        Extra Extra = service.findById(id);

        if(Extra == null)
        {
            System.out.println("List with id " + id + " not found");
            return new ResponseEntity<Extra>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Extra>(Extra, HttpStatus.OK);
    }

    //-------------------Retrieve All Extras--------------------------------------------------------

    @RequestMapping(value = "/Extra/", method = RequestMethod.GET)
    public ResponseEntity<List<Extra>> listAllExtras() {
        List<Extra> ExtraList = service.findAll();
        if(ExtraList.isEmpty()){
            return new ResponseEntity<List<Extra>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Extra>>(ExtraList, HttpStatus.OK);
    }


    //-------------------Create a Extra--------------------------------------------------------

    @RequestMapping(value = "/Extra/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createList(@RequestBody Extra Extra,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating List " + Extra.getId());

        service.save(Extra);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Extra/{id}").buildAndExpand(Extra.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Extra --------------------------------------------------------

    @RequestMapping(value = "/Extra/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Extra> updateExtras(@PathVariable("id") long id, @RequestBody Extra Extras) {
        System.out.println("Updating Extra " + id);

        Extra Extra = service.findById(id);

        if (Extra==null) {
            System.out.println("List with id " + id + " not found");
            return new ResponseEntity<Extra>(HttpStatus.NOT_FOUND);
        }

        Extra updatedExtras = new Extra
                .Build(Extra.getBrand())
                .copy(Extra)
                .build();
        service.update(updatedExtras);
        return new ResponseEntity<Extra>(updatedExtras, HttpStatus.OK);
    }

    //------------------- Delete a Extra --------------------------------------------------------

    @RequestMapping(value = "/Extra/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Extra> deleteExtras(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Extra with id " + id);

        Extra Extra = service.findById(id);
        if (Extra == null) {
            System.out.println("Unable to delete. Extra with id " + id + " not found");
            return new ResponseEntity<Extra>(HttpStatus.NOT_FOUND);
        }

        service.delete(Extra);
        return new ResponseEntity<Extra>(HttpStatus.NO_CONTENT);
    }
}
