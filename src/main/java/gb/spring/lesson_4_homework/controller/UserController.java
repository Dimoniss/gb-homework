package gb.spring.lesson_4_homework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private Integer age;

    @Value("${my.email}")
    private String email;

    @GetMapping("/user")
    public String get() {
        return "name: " + name + "; age: " + age + "; e-mail: " + email;
    }
}
