package com.arianit.maturabe.controller;

import com.arianit.maturabe.dto.QuestionAnswerDto;
import com.arianit.maturabe.dto.request.QuestionAnswerRequest;
import com.arianit.maturabe.dto.request.UpdateQuestionAnswerRequest;
import com.arianit.maturabe.serivce.QuestionAnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question-answers")
public class QuestionAnswerController {

    private final QuestionAnswerService questionAnswerService;

    @PostMapping
    public ResponseEntity<QuestionAnswerDto> createQuestionAnswer(@Valid @RequestBody QuestionAnswerRequest request) {
        QuestionAnswerDto createdQuestionAnswer = questionAnswerService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestionAnswer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionAnswerDto> getQuestionAnswerById(@PathVariable Long id) {
        QuestionAnswerDto questionAnswer = questionAnswerService.getById(id);
        return ResponseEntity.ok(questionAnswer);
    }

    @GetMapping
    public ResponseEntity<List<QuestionAnswerDto>> getAllQuestionAnswers() {
        List<QuestionAnswerDto> questionAnswers = questionAnswerService.getAll();
        return ResponseEntity.ok(questionAnswers);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<QuestionAnswerDto>> getAllSubjectsPaged(@Valid com.arianit.cityguidebe.dto.request.PageRequest pageRequest) {
        Page<QuestionAnswerDto> questionAnswerPage = questionAnswerService.getAllPagable(pageRequest);
        return ResponseEntity.ok(questionAnswerPage);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuestionAnswerDto> updateQuestionAnswer(@PathVariable Long id, @Valid @RequestBody UpdateQuestionAnswerRequest request) {
        QuestionAnswerDto updatedQuestionAnswer = questionAnswerService.update(id, request);
        return ResponseEntity.ok(updatedQuestionAnswer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionAnswerById(@PathVariable Long id) {
        questionAnswerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
