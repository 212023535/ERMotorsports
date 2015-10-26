package za.ac.cput.ermotorsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.ermotorsports.domain.Engine;
import za.ac.cput.ermotorsports.service.EngineService;

import java.util.List;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
@RestController
@RequestMapping("/Engine/**")
public class EnginePage
{
    @Autowired
    private EngineService service;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public List<Engine> getEngine(@PathVariable Long id)
    {
        return service.findAll();
    }

    //-------------------Retrieve Single Engine--------------------------------------------------------
    @RequestMapping(value = "/Engine/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Engine> getEngine(@PathVariable("id") long id)
    {
        System.out.println("Fetching Engine with id " + id);
        Engine engine = service.findById(id);

        if(engine == null)
        {
            System.out.println("Engine with id " + id + " not found");
            return new ResponseEntity<Engine>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Engine>(engine, HttpStatus.OK);
    }

    //-------------------Retrieve All Engine--------------------------------------------------------

    @RequestMapping(value = "/Engine/", method = RequestMethod.GET)
    public ResponseEntity<List<Engine>> listEngines() {
        List<Engine> Engine = service.findAll();
        if(Engine.isEmpty()){
            return new ResponseEntity<List<Engine>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Engine>>(Engine, HttpStatus.OK);
    }


    //-------------------Create a Engine--------------------------------------------------------

    @RequestMapping(value = "/Engine/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createEngine(@RequestBody Engine Engine,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Engine " + Engine.getId());

        service.save(Engine);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Engine/{id}").buildAndExpand(Engine.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Engine --------------------------------------------------------

    @RequestMapping(value = "/Engine/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Engine> updateEngine(@PathVariable("id") long id, @RequestBody Engine Engine2) {
        System.out.println("Updating Engine " + id);

        Engine Engine = service.findById(id);

        if (Engine==null) {
            System.out.println("List with id " + id + " not found");
            return new ResponseEntity<Engine>(HttpStatus.NOT_FOUND);
        }

        Engine updatedEngine = new Engine
                .Build(Engine.getModel())
                .copy(Engine)
                .build();
        service.update(updatedEngine);
        return new ResponseEntity<Engine>(updatedEngine, HttpStatus.OK);
    }

    //------------------- Delete a Engine --------------------------------------------------------

    @RequestMapping(value = "/Engine/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Engine> deleteEngine(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Engine with id " + id);

        Engine Engine = service.findById(id);
        if (Engine == null) {
            System.out.println("Unable to delete. Engine with id " + id + " not found");
            return new ResponseEntity<Engine>(HttpStatus.NOT_FOUND);
        }

        service.delete(Engine);
        return new ResponseEntity<Engine>(HttpStatus.NO_CONTENT);
    }
}
