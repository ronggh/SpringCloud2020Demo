package cn.alan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/testSleuth")
    public String testSleuth() {
        return "Hi， I'm from Sleuth!";
    }
}
