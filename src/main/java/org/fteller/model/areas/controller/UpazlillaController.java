package org.fteller.model.areas.controller;

import javassist.NotFoundException;
import org.fteller.model.areas.District;
import org.fteller.model.areas.Upazilla;
import org.fteller.model.areas.services.DistrictService;
import org.fteller.model.areas.services.UpazillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "areas")
public class UpazlillaController {

    @Autowired
    UpazillaService upazillaService;
    @Autowired
    DistrictService districtService;

    @PostMapping(path = "/district/{id}/upazilla")
    public void addUpazilla(@PathVariable int id, @RequestBody Upazilla upazilla) throws NotFoundException {

        District district = districtService.getDistrictById(id);
        upazillaService.createUpazilla(upazilla.getName(),district);
    }

    @GetMapping(value = "/district/{id}/upazillas")
    @ResponseBody
    public List<Upazilla> getAllUP(@PathVariable District id) throws NotFoundException {
        return upazillaService.getUpazillasByDistrictId(id);
    }

}
