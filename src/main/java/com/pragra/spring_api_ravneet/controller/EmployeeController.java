package com.pragra.spring_api_ravneet.controller;

import com.pragra.spring_api_ravneet.dto.EmployeeDTO;
import com.pragra.spring_api_ravneet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String helloWorld(){
        return "Hello World!!";
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/searchbyid/{id}")
    public Optional<EmployeeDTO> getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.addEmployee(employeeDTO);
        return "Employee added successfully";
    }

    @DeleteMapping("deletebyid/{id}")
    public String deleteEmployeeById(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
        return "Employee deleted successfully";
    }

    @GetMapping("/searchbyfirstname/{name}")
    public List<EmployeeDTO> getByFirstName(@PathVariable String name){
        return employeeService.getByFirstName(name);
    }

    //Viewing Employees on different pages. Limiting to 5 records per page.
    @GetMapping("/all/{page}")
    public Page<EmployeeDTO> getEmployeesByPage(@PathVariable Integer page){
        return employeeService.getEmployeesByPages(page);
    }
}
