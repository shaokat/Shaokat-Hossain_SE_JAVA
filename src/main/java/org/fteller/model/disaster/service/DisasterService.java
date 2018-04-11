package org.fteller.model.disaster.service;

import org.fteller.model.disaster.Disaster;
import org.fteller.model.disaster.repositories.DisasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abdullah on 4/11/18.
 */
@Service
public class DisasterService {
    @Autowired
    DisasterRepository repository;

    public boolean saveDisasterRecord(Disaster record){
        if(record != null){
            repository.save(record);
            return true;
        }else
            return false;
    }

    public List<Disaster> getDisasterRecords(){
        return repository.findAll();
    }

    public Disaster getDisasterById(int id){
        return repository.findOne(id);
    }
}
