package com.codegym.busmanagement.Controller;

import com.codegym.busmanagement.model.Bus;
import com.codegym.busmanagement.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BusController {

    @Autowired
    BusService busService;

    @RequestMapping(value = "/buses", method = RequestMethod.GET)
    public ResponseEntity<List<Bus>> listAllBus(){
        List<Bus> busList = busService.findAll();
        if(busList.isEmpty()){
            return new ResponseEntity<List<Bus>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Bus>>(busList,HttpStatus.OK);
    }

    @RequestMapping(value = "/buses", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers="Accept=application/json")
    public ResponseEntity<Void> createBus(@RequestBody Bus bus){
        busService.save(bus);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/buses/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bus> findBusById(@PathVariable("id") Integer id){
        Bus bus = busService.findById(id);
        if(bus == null){
            System.out.println("Bus with id " + id + " not found");
            return new ResponseEntity<Bus>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bus>(bus,HttpStatus.OK);
    }

    @RequestMapping(value = "/buses/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Bus> updateBus(@PathVariable("id") Integer id, @RequestBody Bus bus){
        System.out.println("updating bus " + id);
        Bus currentBus = busService.findById(id);
        if(bus == null) {
            return new ResponseEntity<Bus>(HttpStatus.NOT_FOUND);
        }
        busService.save(bus);
        return new ResponseEntity<Bus>(currentBus,HttpStatus.OK);
    }

    @RequestMapping(value = "/buses/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Bus> deleteBus(@PathVariable("id") Integer id){
        System.out.println("Fetching & Deleting Bus width id " + id);

        Bus bus = busService.findById(id);
        if(bus == null) {
            return new ResponseEntity<Bus>(HttpStatus.NOT_FOUND);
        }

        busService.delete(id);
        return new ResponseEntity<Bus>(HttpStatus.NO_CONTENT);
    }

}
