package com.pragra.spring_api_ravneet;

import com.pragra.spring_api_ravneet.dto.EmployeeDTO;
import com.pragra.spring_api_ravneet.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringApiRavneetApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringApiRavneetApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        //Adding employee using Builder
        /*EmployeeDTO employee = EmployeeDTO.builder()
                .firstName("John")
                .lastName("Wick")
                .position("Senior Java Developer")
                .salary(150000)
                .build();
        employeeService.addEmployee(employee);*/

        employeeService.getAllEmployees().forEach(System.out::println);

    }

}
