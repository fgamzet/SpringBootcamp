package yte.intern.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello \uD83D\uDC96  \uD83D\uDE08 \uD83D\uDC7D";
    }
}
