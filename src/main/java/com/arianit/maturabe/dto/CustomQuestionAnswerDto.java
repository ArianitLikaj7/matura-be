package com.arianit.maturabe.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomQuestionAnswerDto {
    private Long subjectId;
    private String [] question;
    private String answer;
    private String urlOfPhoto;
}
