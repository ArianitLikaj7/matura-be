package com.arianit.maturabe.dto.request;

import com.arianit.maturabe.dto.CustomQuestionAnswerDto;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TestRequest(
        @NotNull String nameOfTest,
        @NotNull  Long numberOfTest,
        List<CustomQuestionAnswerDto> questionAnswers
) {
}
