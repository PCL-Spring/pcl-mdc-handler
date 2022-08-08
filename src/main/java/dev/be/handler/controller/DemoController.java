package dev.be.handler.controller;

import org.slf4j.MDC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.be.handler.dto.DemoDTO;

@RestController
public class DemoController {

    @PostMapping("/demo")
    public String demo(DemoDTO demoDTO) {
        String userKey = MDC.get("userKey");
        System.out.println(userKey);
        System.out.println(MDC.get("clientOsVer"));
        return "demo";
    }

    @PostMapping("/demo2")
    public String demo2(String userKey) {
        return "demo";
    }
}
