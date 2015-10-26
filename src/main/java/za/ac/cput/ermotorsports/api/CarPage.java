package za.ac.cput.ermotorsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.ermotorsports.domain.Car;
import za.ac.cput.ermotorsports.service.CarService;

import java.util.List;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
@RestController
@RequestMapping(value="/Car/**")
public class CarPage
{
    @Autowired
    CarService service;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public List<Car> getCar (@PathVariable Long id)
    {
        return service.findAll();
    }

    //-------------------Retrieve Single Car--------------------------------------------------------
    @RequestMapping(value = "/Car/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCar(@PathVariable("id") long id)
    {
        System.out.println("Fetching Car with id " + id);
        Car Car = service.findById(id);

        if(Car == null)
        {
            System.out.println("Car with id " + id + " not found");
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Car>(Car, HttpStatus.OK);
    }

    //-------------------Retrieve All Car--------------------------------------------------------

    @RequestMapping(value = "/Car/", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> listAllCars() {
        List<Car> carList = service.findAll();
        if(carList.isEmpty()){
            return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
    }


    //-------------------Create a Car--------------------------------------------------------

    @RequestMapping(value = "/Car/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCar(@RequestBody Car Car,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating List " + Car.getId());

        service.save(Car);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Car/{id}").buildAndExpand(Car.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Car --------------------------------------------------------

    @RequestMapping(value = "/Car/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Car> updateCar(@PathVariable("id") long id, @RequestBody Car Car) {
        System.out.println("Updating Car " + id);

        Car Car2 = service.findById(id);

        if (Car2==null) {
            System.out.println("Car with id " + id + " not found");
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }

        Car updatedCar = new Car
                .Builder(Car2.getBrand())
                .copy(Car2)
                .build();
        service.update(updatedCar);
        return new ResponseEntity<Car>(updatedCar, HttpStatus.OK);
    }

    //------------------- Delete a Car --------------------------------------------------------

    @RequestMapping(value = "/Car/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Car> deleteCar(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Car with id " + id);

        Car Car = service.findById(id);
        if (Car == null) {
            System.out.println("Unable to delete. Car with id " + id + " not found");
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }

        service.delete(Car);
        return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
    }
}
