package com.arianit.maturabe.dto.request;

import jakarta.validation.constraints.NotNull;

public record SubjectRequest(
        @NotNull String nameOfSubject
) {
}
