package com.arianit.maturabe.mapper;

import com.arianit.maturabe.dto.QuestionAnswerDto;
import com.arianit.maturabe.dto.SubjectDto;
import com.arianit.maturabe.dto.request.SubjectRequest;
import com.arianit.maturabe.dto.request.UpdateSubjectRequest;
import com.arianit.maturabe.entity.Subject;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SubjectMapper implements
        UpdateGenericMapper<Subject, SubjectDto, SubjectRequest, UpdateSubjectRequest>{
    private final ModelMapper mapper;

    @Override
    public SubjectDto toDto(Subject subject) {
        SubjectDto subjectDto = mapper.map(subject, SubjectDto.class);
        if (subject.getQuestionAnswerList() != null) {
            subjectDto.setQuestionAnswers(subject.getQuestionAnswerList()
                    .stream()
                    .map(questionAnswer -> mapper.map(questionAnswer, QuestionAnswerDto.class))
                    .collect(Collectors.toList()));
        }
        return subjectDto;
    }

    @Override
    public Subject toEntity(SubjectRequest request) {
        return mapper.map(request, Subject.class);
    }

    @Override
    public void toEntity(UpdateSubjectRequest updateRequest, Subject entity) {
        mapper.map(updateRequest,entity);
    }
}
