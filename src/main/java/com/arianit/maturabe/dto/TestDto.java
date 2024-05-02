package com.arianit.maturabe.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDto {
    private Long id;
    private Long numberOfTest;
    private List<CustomQuestionAnswerDto> questionAnswerDtoList;
}
