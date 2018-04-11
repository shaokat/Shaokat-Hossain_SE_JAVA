package org.fteller.model.relief.service;

import org.fteller.model.relief.Organization;
import org.fteller.model.relief.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    public OrganizationRepository organizationRepository;

    public boolean createOrganization(Organization organization){
        if(organizationRepository !=null){
            organizationRepository.save(organization);
        }
        return false;
    }

    public List<Organization> getOrganization(){
        return organizationRepository.findAll();
    }
}
