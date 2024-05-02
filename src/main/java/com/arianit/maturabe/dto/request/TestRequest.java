package com.arianit.maturabe.dto.request;

import com.arianit.maturabe.entity.QuestionAnswer;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TestRequest(
        @NotNull String nameOfTest,
        @NotNull  Long numberOfTest,
        List<QuestionAnswer> questionAnswers
) {
}
