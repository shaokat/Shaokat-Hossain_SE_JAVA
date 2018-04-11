package org.fteller.model.areas.controller;

import javassist.NotFoundException;
import org.fteller.model.areas.UnionParisad;
import org.fteller.model.areas.Upazilla;
import org.fteller.model.areas.repositories.UnionRepository;
import org.fteller.model.areas.services.AreaService;
import org.fteller.model.areas.services.UnionParisadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnionController {

    @Autowired
    UnionParisadService unionParisadService;

    @GetMapping(value = "/upazilla/{id}/uinion")
    @ResponseBody
    public List<UnionParisad> getAllUnion(@PathVariable Upazilla id) throws NotFoundException {
        return unionParisadService.getUnionparisadByUpazilla(id);
    }
    @PostMapping(path = "/upazilla/{id}/union")
    public void addUpazilla(@PathVariable int id, @RequestBody UnionParisad unionParisad) throws NotFoundException {

        Upazilla upazilla = unionParisadService.getUpazilla(id);
        unionParisadService.createUnion(unionParisad.getName(),upazilla);
    }
}