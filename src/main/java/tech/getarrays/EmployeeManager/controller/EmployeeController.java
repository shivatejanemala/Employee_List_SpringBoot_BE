package tech.getarrays.EmployeeManager.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.EmployeeManager.EmployeeModel.Employee;
import tech.getarrays.EmployeeManager.service.EmployeeService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> empList =  employeeService.findAllEmployees();
        return new ResponseEntity<>(empList,HttpStatus.OK);
    }

    @GetMapping("/employee/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee emp =  employeeService.getEmployeeById(id);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
        Employee newEmployee =  employeeService.addEmployee(emp);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/employee/add/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
        Employee newEmployee =  employeeService.updateEmployee(emp);
        return new ResponseEntity<>(newEmployee,HttpStatus.OK);
    }
    
    @DeleteMapping("/employee/add/{id}")
    public ResponseEntity<?> deleteEmployee(@RequestBody Employee emp){
        employeeService.deleteEmployee(emp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
