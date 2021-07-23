package com.example.demo.index.controller;


import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emp")
public class EmpController {

    @GetMapping(value = "/list", produces = MediaTypes.HAL_JSON_VALUE)
    public String test() {
        return "test";

    }
}
