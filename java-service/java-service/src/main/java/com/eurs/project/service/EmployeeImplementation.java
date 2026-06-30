package com.eurs.project.service;

import com.eurs.project.model.Department;
import com.eurs.project.model.Employee;
import com.eurs.project.repository.DepartmentRepository;
import com.eurs.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public String registerEmployee(Employee theEmployee) {
        if(employeeRepository.findByEmail(theEmployee.getEmail()).isPresent())
            return "Employee Already Exist";
        theEmployee.setRole("Employee");
        theEmployee.setStatus("Pending");
        Department dept =
                departmentRepository.findById(
                        theEmployee.getDepartment().getId()
                ).orElseThrow();

        theEmployee.setDepartment(dept);
        employeeRepository.save(theEmployee);
        return theEmployee.toString();
    }
}
