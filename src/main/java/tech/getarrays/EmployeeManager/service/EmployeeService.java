package tech.getarrays.EmployeeManager.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.EmployeeManager.EmployeeModel.Employee;
import tech.getarrays.EmployeeManager.Exception.UserNotFoundException;
import tech.getarrays.EmployeeManager.repo.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee emp){
        emp.setEmployeeCode(UUID.randomUUID().toString());;
        employeeRepo.save(emp);
        return emp;
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
    }

    public Employee updateEmployee(Employee emp){
        return employeeRepo.save(emp);
    }
    public void deleteEmployee(Employee emp){
        employeeRepo.delete(emp);
    }

    public void deleteEmployeeById(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
    



}
