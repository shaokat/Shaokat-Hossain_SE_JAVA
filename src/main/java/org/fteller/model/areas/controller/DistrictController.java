package org.fteller.model.areas.controller;

import javassist.NotFoundException;
import org.fteller.model.areas.District;
import org.fteller.model.areas.Division;
import org.fteller.model.areas.services.DistrictService;
import org.fteller.model.areas.services.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "areas")
public class DistrictController
{
    @Autowired
    DistrictService districtService;
    @Autowired
    DivisionService divisionService;

    @GetMapping(path = "/division/{id}/districts")
    public List<District> getAllDistrictsByDivision(@PathVariable Division id) throws NotFoundException {
        return districtService.getDsitrictsByDivisionId(id);
    }

    @PostMapping(path = "/division/{id}/district")
    public void createDistrict(@Valid @PathVariable int id, @RequestBody District district) throws NotFoundException {

        Division division = divisionService.findDivisionById(id);
        if(division!=null){
            districtService.createDistrict(district.getName(),division);
        }

    }
}
