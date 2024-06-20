package com.pragra.spring_api_ravneet.repository;

import com.pragra.spring_api_ravneet.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDTO, Integer> {
    List<EmployeeDTO> getEmployeeDTOByFirstName(String name);
}
