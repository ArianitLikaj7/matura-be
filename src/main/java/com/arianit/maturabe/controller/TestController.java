package com.arianit.maturabe.controller;

import com.arianit.maturabe.dto.TestDto;
import com.arianit.maturabe.dto.request.TestRequest;
import com.arianit.maturabe.entity.Test;
import com.arianit.maturabe.serivce.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping
    public ResponseEntity<TestDto> createTest(@RequestBody TestRequest request) {
        TestDto testDto = testService.createTest(request);
        return ResponseEntity.ok(testDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestDto> getTest(@PathVariable Long id) {
        TestDto testDto = testService.getTest(id);
        return ResponseEntity.ok(testDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        testService.deleteTest(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestDto> updateTest(@PathVariable Long id, @RequestBody TestRequest request) {
        TestDto updatedTest = testService.updateTest(id, request);
        return ResponseEntity.ok(updatedTest);
    }
}
