package com.arianit.maturabe.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDto{
    private Long id;
    private String nameOfSubject;
    private List<QuestionAnswerDto> questionAnswers;
}
