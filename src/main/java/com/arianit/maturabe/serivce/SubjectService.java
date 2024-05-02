package com.arianit.maturabe.serivce;

import com.arianit.maturabe.dao.SubjectRepository;
import com.arianit.maturabe.dto.SubjectDto;
import com.arianit.maturabe.dto.request.SubjectRequest;
import com.arianit.maturabe.dto.request.UpdateSubjectRequest;
import com.arianit.maturabe.entity.Subject;
import com.arianit.maturabe.exception.MismatchedInputException;
import com.arianit.maturabe.exception.ResourceNotFoundException;
import com.arianit.maturabe.mapper.SubjectMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.arianit.cityguidebe.dto.request.PageRequest;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper mapper;

    @Transactional
    public SubjectDto create(SubjectRequest request){
        Subject subject = mapper.toEntity(request);
        return mapper.toDto(subjectRepository.save(subject));
    }

    public SubjectDto getById(Long id){
       Subject subjectInDb = subjectRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException(
                       String.format("Subject with %s id not found",id)
               ));
       return mapper.toDto(subjectInDb);
    }



    public List<SubjectDto> getAll(){
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<SubjectDto> getAllPagable(@Valid PageRequest pageRequest){
        return subjectRepository.findAll(pageRequest.getPageable()).map(
               mapper::toDto
        );
    }

    public SubjectDto update(Long id, UpdateSubjectRequest request){
        if(!(id.equals(request.id()))){
            throw new MismatchedInputException("Ids dosent matchs");
        }
        Subject subjectInDb = subjectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("Subject with %s id not found",id)
                ));
        mapper.toEntity(request,subjectInDb);
        return mapper.toDto(subjectRepository.save(subjectInDb));
    }
    public void deleteById(Long id){
        Subject subjectInDb = subjectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("Subject with %s id not found",id)
                ));
        subjectRepository.deleteById(id);
    }
}
