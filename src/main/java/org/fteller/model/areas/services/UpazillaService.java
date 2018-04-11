package org.fteller.model.areas.services;

import javassist.NotFoundException;
import org.fteller.model.areas.District;
import org.fteller.model.areas.Upazilla;
import org.fteller.model.areas.repositories.UpazillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Component
public class UpazillaService {
    @Autowired
    UpazillaRepository upazillaRepository;


    @Transactional
    public boolean createUpazilla(String name, District district){
        List<Upazilla> existing = getUpazillas();
        boolean exists = existing.stream().anyMatch(upz->upz.getName().toLowerCase().equals(name.toLowerCase()));
        if(!exists) {
            Upazilla upazilla = new Upazilla();
            upazilla.setName(name);
            upazilla.setUnionParisads(new HashSet<>());
            upazilla.setDistrict(district);
            saveUpazilla(upazilla);
            return true;
        }else
            return false;
    }

    public void saveUpazilla(Upazilla upazilla) {
        upazillaRepository.save(upazilla);
    }

    public List<Upazilla> getUpazillas() {
        return upazillaRepository.findAll();
    }
    public List<Upazilla> getUpazillasByDistrictId(District id) throws NotFoundException {

        List<Upazilla> upazillas = upazillaRepository.findByDistrict(id);
        if (upazillas != null && !upazillas.isEmpty()) {
            return upazillas;
        } else {
            throw new NotFoundException("No Upazilla Available for District id: " + id);
        }
    }
}
