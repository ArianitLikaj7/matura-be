package com.arianit.maturabe.dto.request;

import jakarta.validation.constraints.NotNull;

public record QuestionAnswerRequest(
        @NotNull Long subjectId,
        @NotNull String [] question,
        @NotNull String answer,
        @NotNull String urlOfPhoto
) {
}
