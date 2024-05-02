package com.arianit.maturabe.serivce;

import com.arianit.maturabe.dao.TestRepository;

import com.arianit.maturabe.mapper.TestMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor

public class TestService {
    private final TestRepository testRepository;
    private final TestMapper mapper;
    private final QuestionAnswerService questionAnswerService;
    private final ObjectMapper objectMapper;



}
