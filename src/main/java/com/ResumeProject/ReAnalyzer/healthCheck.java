package com.ResumeProject.ReAnalyzer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class healthCheck {

@GetMapping("/health-check")
public String healthCheck(){
    return "ok, this is ai resume analyzer";
}
}
