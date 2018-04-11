package org.fteller.model.relief.Controller;

import org.fteller.model.relief.service.ReliefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReliefController {
    @Autowired
    ReliefService reliefService;
}
