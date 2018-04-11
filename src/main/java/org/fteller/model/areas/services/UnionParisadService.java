package org.fteller.model.areas.services;

import javassist.NotFoundException;
import org.fteller.model.areas.District;
import org.fteller.model.areas.UnionParisad;
import org.fteller.model.areas.Upazilla;
import org.fteller.model.areas.repositories.UnionRepository;
import org.fteller.model.areas.repositories.UpazillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UnionParisadService {
    @Autowired
    UnionRepository unionRepository;

    @Autowired
    UpazillaRepository upazillaRepository;
    @Transactional
    public boolean createUnion(String name, Upazilla upazilla){
        List<UnionParisad> existing = getUnionParisads();
        boolean exists = existing.stream().anyMatch(unionp->unionp.getName().toLowerCase().equals(name.toLowerCase()));
        if(!exists) {
            UnionParisad union = new UnionParisad();
            union.setName(name);
            union.setUpazilla(upazilla);
            saveUnion(union);
            return true;
        }else
            return false;
    }

    public void saveUnion(UnionParisad union) {
        unionRepository.save(union);
    }

    public List<UnionParisad> getUnionParisads() {
        return unionRepository.findAll();
    }

    public List<UnionParisad> getUnionparisadByUpazilla(Upazilla id) throws NotFoundException {

        List<UnionParisad> upazillas =  unionRepository.findByUpazilla(id);
        if (upazillas != null && !upazillas.isEmpty())
        {
            return upazillas;
        }
        else {
            throw new NotFoundException("No UnionParisad Available for Upazilla id: "+id);
        }
    }
    public Upazilla getUpazilla(int id) throws NotFoundException {
        Upazilla upazilla = upazillaRepository.findOne(id);
        if(upazilla != null){
            return upazilla;
        }
        else {
            throw new NotFoundException("Upzilla for id: "+id+" not Found");
        }

    }
}
