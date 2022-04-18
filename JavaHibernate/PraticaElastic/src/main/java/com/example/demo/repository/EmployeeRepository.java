package com.example.demo.repository;

import com.example.demo.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findAll();
    List<Employee> findEmployeeByAge(Integer age);
    Optional<Employee> findById(String id);
}
