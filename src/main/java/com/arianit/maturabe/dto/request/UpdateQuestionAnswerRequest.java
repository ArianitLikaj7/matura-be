package com.arianit.maturabe.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateQuestionAnswerRequest(
        @NotNull Long id,
        Long subjectId,
        String [] question,
        String answer
) {
}
