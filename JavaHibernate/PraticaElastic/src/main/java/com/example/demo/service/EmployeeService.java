package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Product;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> findByAge(Integer age){

        return employeeRepository.findEmployeeByAge(age);
    }

    public Employee update(Employee employee, String id){
        Employee employeeOld = employeeRepository.findById(id).get();
        employeeOld.setFirstName(employee.getFirstName());
        employeeOld.setLastName(employee.getLastName());
        employeeOld.setAge(employee.getAge());
        employeeOld.setAddress(employee.getAddress());
        employeeRepository.save(employeeOld);
        return employee;
    }



}
