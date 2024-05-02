package com.arianit.maturabe.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateTestRequest(
        @NotNull Long id,
        String nameOfTest
) {
}
