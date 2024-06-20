package com.pragra.spring_api_ravneet.service;

import com.pragra.spring_api_ravneet.dto.EmployeeDTO;
import com.pragra.spring_api_ravneet.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public void addEmployee(EmployeeDTO employeeDTO){
        employeeRepo.save(employeeDTO);
    }

    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public void deleteEmployeeById(Integer id){
        employeeRepo.deleteById(id);
    }

    public Optional<EmployeeDTO> getEmployeeById(Integer id){
        return  employeeRepo.findById(id);
    }

    public List<EmployeeDTO> getByFirstName(String name){
        return employeeRepo.getEmployeeDTOByFirstName(name);
    }

    public Page<EmployeeDTO> getEmployeesByPages(Integer page){
        Pageable pageable = PageRequest.of(page, 5);
        return employeeRepo.findAll(pageable);
    }
}
