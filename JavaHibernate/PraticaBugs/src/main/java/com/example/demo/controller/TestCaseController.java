package com.example.demo.controller;

import com.example.demo.models.TestCase;
import com.example.demo.models.TestCaseDTO;
import com.example.demo.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<TestCaseDTO> saveTestCase(@RequestBody TestCase testCase) {
        testCase.setLastUpdate(LocalDate.now());
        testCaseService.saveTestCase(testCase);
        TestCaseDTO dto = new TestCaseDTO(testCase.getId_case(), "TestCase salvo!");
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases/")
    public ResponseEntity<List<TestCase>> allTestCases(){
        List<TestCase> listTestCases = testCaseService.listTestCase();
        return ResponseEntity.ok(listTestCases);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id){
        TestCase testCase = testCaseService.findTestCaseById(id);
        return ResponseEntity.ok(testCase);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCaseById(@PathVariable Long id,
                                                          @RequestBody TestCase testCase){
        TestCase testCaseUpdated = testCaseService.updateTestCaseById(id, testCase);
        TestCaseDTO dto = new TestCaseDTO(testCaseUpdated.getId_case(), "TestCase Atualizado!");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDTO> deleteTestCase(@PathVariable Long id){
        testCaseService.deleteTestCaseById(id);
        TestCaseDTO dto = new TestCaseDTO(id, "TestCase deletado!");
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCase>> findTestCaseByLastUpdate(@RequestParam(name = "lastUpdate") String date) throws ParseException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formatedDate = LocalDate.parse(date, format);
        System.out.println(formatedDate);
        return ResponseEntity.ok(testCaseService.findTestCaseByDate(formatedDate));
    }
}
