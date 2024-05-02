package com.arianit.maturabe.mapper;

import com.arianit.maturabe.dto.QuestionAnswerDto;
import com.arianit.maturabe.dto.TestDto;
import com.arianit.maturabe.dto.request.TestRequest;
import com.arianit.maturabe.dto.request.UpdateTestRequest;
import com.arianit.maturabe.entity.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestMapper implements UpdateGenericMapper<Test, TestDto, TestRequest, UpdateTestRequest> {
    private final ModelMapper  mapper;
    private final ObjectMapper objectMapper;
    @Override
    public TestDto toDto(Test entity) {
        return mapper.map(entity, TestDto.class);
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
}
