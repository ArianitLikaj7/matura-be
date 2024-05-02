package com.arianit.maturabe.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateSubjectRequest(
        @NotNull Long id,
        String nameOfSubject
) {
}
