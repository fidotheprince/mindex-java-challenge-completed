package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;


@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    /*
     * DAO for resources/static/compensation_database.json; 
     */
    @Autowired 
    private CompensationRepository compensationRepository;

    @Override
    public Compensation create(String salary, String id) {
        LOG.debug("Creating compensation for [{}]", id);
        System.out.println(salary);
        /*
         * Convert salary into an int;
         */
        String s = salary.replaceAll("\\D+","");
        int n = Integer.parseInt(s);
        /*
         * Create compensation for an employee;
        */
            Employee employee = employeeRepository.findByEmployeeId(id);
            Compensation compensation = new Compensation();

            compensation.setCompensationId(UUID.randomUUID().toString());
            compensation.setEmployee(employee);
            compensation.setSalary(n);
            compensation.setDate(LocalDate.now().toString());
        /*
         * Insert compensation into datastore;
        */
            compensationRepository.insert(compensation);

        return compensation;

    }

    @Override
    public Compensation read(String id) {
        LOG.debug("Reading employee with id [{}]", id);
        /*
         * Retrieve compensation from datastore
        */
        Compensation compensation = compensationRepository.findByCompensationId(id);
        
        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }
   
    
}
