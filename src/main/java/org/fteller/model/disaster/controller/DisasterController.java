package org.fteller.model.disaster.controller;

import org.fteller.model.disaster.Disaster;
import org.fteller.model.disaster.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by Abdullah Al Amin on 4/11/2018.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/disaster")
public class DisasterController {

    @Autowired
    private DisasterService service;

    @PostMapping(path = "/save")
    public ResponseEntity<Object> createDisasterRecord(@Valid @RequestBody Disaster disasterRecord){
        if(disasterRecord != null){
            Disaster record = service.saveDisasterRecord(disasterRecord);
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(disasterRecord.getId()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/all")
    public List<Disaster> getAllDisasterRecords(){
        return service.getDisasterRecords();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteDisasterRecord(@PathVariable int id){
        Disaster deleted = service.deleteDisasterRecord(id);

    }

}