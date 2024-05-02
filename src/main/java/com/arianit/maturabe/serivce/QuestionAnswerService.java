package com.arianit.maturabe.serivce;

import com.arianit.maturabe.dao.QuestionAnswerRepository;
import com.arianit.maturabe.dto.QuestionAnswerDto;
import com.arianit.maturabe.dto.SubjectDto;
import com.arianit.maturabe.dto.request.QuestionAnswerRequest;
import com.arianit.maturabe.dto.request.UpdateQuestionAnswerRequest;
import com.arianit.maturabe.entity.QuestionAnswer;
import com.arianit.maturabe.exception.MismatchedInputException;
import com.arianit.maturabe.exception.ResourceNotFoundException;
import com.arianit.maturabe.mapper.QuestionAnswerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.arianit.cityguidebe.dto.request.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionAnswerService {
    private final QuestionAnswerRepository questionAnswerRepository;
    private final QuestionAnswerMapper mapper;
    private final SubjectService subjectService;


    public QuestionAnswerDto create (QuestionAnswerRequest request){
     QuestionAnswer questionAnswer = mapper.toEntity(request);
     setQuestionAnswerMappingOnCreate(request,questionAnswer);
     QuestionAnswer questionAnswerInDb = questionAnswerRepository.save(questionAnswer);
     return mapper.toDto(questionAnswerInDb);
    }

    public QuestionAnswerDto getById(Long id){
        QuestionAnswer questionAnswerInDb = questionAnswerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("QuesntionAnswer with %s id not found",id)
                ));
        return mapper.toDto(questionAnswerInDb);
    }

    public List<QuestionAnswerDto> getAll(){
        List<QuestionAnswer> questionAnswers = questionAnswerRepository.findAll();
        return questionAnswers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public List<QuestionAnswerDto> getBySubjectIds(List<Long> ids){
        List<QuestionAnswer> subjects = questionAnswerRepository.findBySubjectIdIn(ids);
        return subjects.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<QuestionAnswerDto> getBySubjectId(Long id){
        List<QuestionAnswer> subjects = questionAnswerRepository.findBySubjectId(id);
        return subjects.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public QuestionAnswerDto update(Long id, UpdateQuestionAnswerRequest updateRequest){
        if(!(id.equals(updateRequest.id()))){
            throw new MismatchedInputException("Ids dosent matchs");
        }
        QuestionAnswer questionAnswerInDb = questionAnswerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("QuesntionAnswer with %s id not found",id)
                ));
        mapper.toEntity(updateRequest,questionAnswerInDb);
        setQuestionAnswerMappingOnUpdate(updateRequest, questionAnswerInDb);
        return mapper.toDto(questionAnswerInDb);
    }
    public Page<QuestionAnswerDto> getAllPagable(@Valid PageRequest pageRequest){
        return questionAnswerRepository.findAll(pageRequest.getPageable()).map(
                mapper::toDto
        );
    }
    public void deleteById(Long id){
        QuestionAnswer questionAnswerInDb = questionAnswerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("QuesntionAnswer with %s id not found",id)
                ));
        questionAnswerRepository.deleteById(id);
    }

    private void setQuestionAnswerMappingOnCreate(QuestionAnswerRequest request, QuestionAnswer questionAnswer) {
        SubjectDto subjectDto = subjectService.getById(request.subjectId());
        questionAnswer.setSubjectId(subjectDto.getId());
    }
    private void setQuestionAnswerMappingOnUpdate(UpdateQuestionAnswerRequest request, QuestionAnswer questionAnswer) {
        if(request.subjectId()!= null){
           SubjectDto subjectDto = subjectService.getById(request.subjectId());
           questionAnswer.setSubjectId(subjectDto.getId());
        }
    }
}
