package com.arianit.maturabe.controller;

import com.arianit.maturabe.dto.SubjectDto;
import com.arianit.maturabe.dto.request.SubjectRequest;
import com.arianit.maturabe.dto.request.UpdateSubjectRequest;
import com.arianit.maturabe.serivce.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@Valid @RequestBody SubjectRequest request) {
        SubjectDto createdSubject = subjectService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable Long id) {
        SubjectDto subject = subjectService.getById(id);
        return ResponseEntity.ok(subject);
    }

    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAllSubjects() {
        List<SubjectDto> subjects = subjectService.getAll();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<SubjectDto>> getAllSubjectsPaged(@Valid com.arianit.cityguidebe.dto.request.PageRequest pageRequest) {
        Page<SubjectDto> subjectsPage = subjectService.getAllPagable(pageRequest);
        return ResponseEntity.ok(subjectsPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> updateSubject(@PathVariable Long id, @Valid @RequestBody UpdateSubjectRequest request) {
        SubjectDto updatedSubject = subjectService.update(id, request);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubjectById(@PathVariable Long id) {
        subjectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

