package com.arianit.maturabe.mapper;

import com.arianit.maturabe.dto.CustomQuestionAnswerDto;
import com.arianit.maturabe.dto.QuestionAnswerDto;
import com.arianit.maturabe.dto.TestDto;
import com.arianit.maturabe.dto.request.TestRequest;
import com.arianit.maturabe.dto.request.UpdateTestRequest;
import com.arianit.maturabe.entity.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestMapper implements UpdateGenericMapper<Test, TestDto, TestRequest, UpdateTestRequest> {
    private final ModelMapper  mapper;
    private final ObjectMapper objectMapper;

    @Override
    public TestDto toDto(Test entity) {
        TestDto dto = mapper.map(entity, TestDto.class);
        if (entity.getQuestionsAnswers() != null) {
            try {
                List<CustomQuestionAnswerDto> questionAnswers = objectMapper.readValue(entity.getQuestionsAnswers(),
                        new TypeReference<List<CustomQuestionAnswerDto>>() {});
                dto.setQuestionAnswerDtoList(questionAnswers);
            } catch (JsonProcessingException e) {
                log.error("Error deserializing questionsAnswers", e);
            }
        }
        return dto;
    }

    @Override
    public Test toEntity(TestRequest request) {
        return mapper.map(request, Test.class);
    }

    @Override
    public void toEntity(UpdateTestRequest updateRequest, Test entity) {
        mapper.map(updateRequest, entity);
    }

    public Test toEntity(TestRequest request, List<QuestionAnswerDto> questionAnswerDtoList) {
        Test test = mapper.map(request, Test.class);
        try {
            String questionsAnswersJson = objectMapper.writeValueAsString(questionAnswerDtoList);
            test.setQuestionsAnswers(questionsAnswersJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return test;
    }

    public Test convertRequestToTestWithSerializedQA(TestRequest request) {
        Test test = mapper.map(request, Test.class);
        try {
            String questionsAnswersJson = objectMapper.writeValueAsString(request.questionAnswers());
            test.setQuestionsAnswers(questionsAnswersJson);
        } catch (JsonProcessingException e) {
            log.error("Error serializing question answers", e);
            throw new RuntimeException("Error serializing question answers", e);
        }
        return test;
    }


}
