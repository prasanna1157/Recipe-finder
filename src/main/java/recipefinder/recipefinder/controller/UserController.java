package recipefinder.recipefinder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    @GetMapping("/user")
    String foo() {
        return "User created successfully!";
    }
}
