package com.example.demo;

import com.example.demo.controller.EmployeeController;
import com.example.demo.domain.Address;
import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {



    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);}

}
