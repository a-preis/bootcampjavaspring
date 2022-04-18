package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Product;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Não funciona aqui, só pelo elasticsearch
    @PostMapping("/employee/new")
    public String save(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "Iai";
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> list= employeeService.findAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/employee/{age}")
    public ResponseEntity<List<Employee>> findByAge(@PathVariable Integer age){
        List<Employee> list= employeeService.findByAge(age);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/employee/{id}/")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id,
                                                   @RequestBody Employee employee){
        employeeService.update(employee, id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
