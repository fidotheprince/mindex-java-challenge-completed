package com.mindex.challenge.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private CompensationService compensationService;

    @PostMapping("/gencompensation/{id}")
    public Compensation create(@RequestBody String salary, @PathVariable String id) {
        LOG.debug("Received compensation create request for employee [{}]", id);

            try{
                compensationService.create(salary, id);
            } catch(Exception e) {
                System.out.println("Compensation for employee could not be generated");
            }

            return compensationService.create(salary, id);
            
    }


    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return compensationService.read(id);
    }

}
