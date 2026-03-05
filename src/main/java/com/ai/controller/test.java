package com.ai.controller;

import com.ai.common.BaseResponse;
import com.ai.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ai.common.BaseResponse;

@RestController
@RequestMapping("/test")
public class test {
    @GetMapping("/")
    public BaseResponse<String> tests() {
        return ResultUtils.success("Hello World");
    }
}
