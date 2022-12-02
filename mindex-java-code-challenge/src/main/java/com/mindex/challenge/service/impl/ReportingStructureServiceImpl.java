package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    /*
     * Collects the total number of reports per employee;
    */
    ArrayList<String> totalReports = new ArrayList<>();
    /**
     * Recursive function designed and implemented to find reports per employee;
     * @param count = employeeRepository.count();
     * @param id
     */
    private void findReportees (long count, String id) {

        /*
        * holds the id of each report that is discovered;
        */
        String reportId = "";
        /*
         * count variable established to end recursive behavior;
        */
        if(count <= 1) {
            return;
        } else {
            
            /*
             * Instantiate specific employee;
            */
            Employee employee = employeeRepository.findByEmployeeId(id);
            /*
             * If employee has no direct reports notify in terminal;
             */
            if(employee.getDirectReports() == null) {
                System.out.println("No reports");
            } else {
                /*
                 * When there are reports look through each one;
                 */
                for(int i = 0; i < employee.getDirectReports().size(); i++){
                    /*
                     * Gather the id of each report and set to reporteeId variable;
                     */
                    reportId = employee.getDirectReports().get(i).getEmployeeId();
                    /*
                     * Add that id to the totalReports array;
                     */
                    totalReports.add(reportId);
                    /*
                     * Repeat method for each found report;
                     */
                    findReportees(count -1, reportId);
                    /*
                     * Uncomment to view recursion in action!
                     * System.out.println("Loop Count: " + i + " Employee: " + employee.getFirstName() + " Reportee: " + reportId);
                     * System.out.println(totalReports.size());
                    */
             
                }

            }
        }

    }

    @Override
    public ReportingStructure read(String id) {

        
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        /*
         * recursive function for find reports per employee;
        */
        findReportees(employeeRepository.count(), id);
        /*
         * amount is the total from the totalReports array;
         */
        int amount = totalReports.size();
        /*
         * Builds the response data structure; 
         */
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployeeId(id);
        reportingStructure.setNumberOfReports(amount);
        /*
         * Reset total report count for the next request;
         */
        totalReports.clear();
        return reportingStructure;
    }
   
}