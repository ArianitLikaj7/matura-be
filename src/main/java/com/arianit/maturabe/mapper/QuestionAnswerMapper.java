package com.arianit.maturabe.mapper;

import com.arianit.maturabe.dto.QuestionAnswerDto;
import com.arianit.maturabe.dto.request.QuestionAnswerRequest;
import com.arianit.maturabe.dto.request.UpdateQuestionAnswerRequest;
import com.arianit.maturabe.entity.QuestionAnswer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionAnswerMapper implements UpdateGenericMapper<
        QuestionAnswer, QuestionAnswerDto, QuestionAnswerRequest, UpdateQuestionAnswerRequest>{
    private final ModelMapper mapper;
    @Override
    public QuestionAnswerDto toDto(QuestionAnswer entity) {
        return mapper.map(entity, QuestionAnswerDto.class);
    }

    @Override
    public QuestionAnswer toEntity(QuestionAnswerRequest request) {
        return mapper.map(request, QuestionAnswer.class);
    }

    @Override
    public void toEntity(UpdateQuestionAnswerRequest updateRequest, QuestionAnswer entity) {
       mapper.map(updateRequest, entity);
    }
}
