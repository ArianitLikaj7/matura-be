package com.arianit.maturabe.serivce;

import com.arianit.maturabe.dao.TestRepository;

import com.arianit.maturabe.dto.QuestionAnswerDto;
import com.arianit.maturabe.dto.TestDto;
import com.arianit.maturabe.dto.request.TestRequest;
import com.arianit.maturabe.entity.Test;
import com.arianit.maturabe.mapper.TestMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor

public class TestService {
    private final TestRepository testRepository;
    private final TestMapper mapper;
    private final QuestionAnswerService questionAnswerService;
    private final ObjectMapper objectMapper;


     @Transactional
     public TestDto createTest(TestRequest request) {
       Test test = mapper.convertRequestToTestWithSerializedQA(request);
       Test savedTest = testRepository.save(test);
       return mapper.toDto(savedTest);
    }

    public TestDto getTest(Long id) {
        return testRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + id));
    }

    @Transactional
    public void deleteTest(Long id) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + id));
        testRepository.delete(test);
    }

    @Transactional
    public TestDto updateTest(Long id, TestRequest request) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + id));
        updateTestFromRequest(test, request);
        Test updatedTest = testRepository.save(test);
        return mapper.toDto(updatedTest);
    }

    public void updateTestFromRequest(Test test, TestRequest request) {
        test.setNameOfTest(request.nameOfTest());
        test.setNumberOfTest(request.numberOfTest());
    }




}
