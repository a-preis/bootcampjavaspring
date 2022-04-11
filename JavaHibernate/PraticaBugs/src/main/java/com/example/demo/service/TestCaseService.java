package com.example.demo.service;

import com.example.demo.models.TestCase;
import com.example.demo.models.TestCaseDTO;
import com.example.demo.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    public void saveTestCase(TestCase testCase) {
        testCaseRepository.save(testCase);
    }

    public List<TestCase> listTestCase() {
        return testCaseRepository.findAll();
    }

    public TestCase findTestCaseById(Long id){
        return testCaseRepository.findById(id).get();
    }

    public TestCase updateTestCaseById(Long id, TestCase testCase) {
        TestCase testCaseUpdate = testCaseRepository.findById(id).get();
        testCaseUpdate.setDescription(testCase.getDescription());
        testCaseUpdate.setTested(testCase.getTested());
        testCaseUpdate.setPassed(testCase.getPassed());
        testCaseUpdate.setNumber_of_tries(testCase.getNumber_of_tries());
        testCaseUpdate.setLastUpdate(testCase.getLastUpdate());
        return testCaseRepository.save(testCaseUpdate);
    }

    public void deleteTestCaseById(Long id){
        testCaseRepository.deleteById(id);
    }

    public List<TestCase> findTestCaseByDate(LocalDate date) {
        return testCaseRepository.findByLastUpdate(date);
    }
}
