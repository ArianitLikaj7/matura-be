package com.arianit.maturabe.controller;

import com.arianit.maturabe.dto.TestDto;
import com.arianit.maturabe.dto.request.TestRequest;
import com.arianit.maturabe.entity.Test;
import com.arianit.maturabe.serivce.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

}
