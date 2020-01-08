package recipefinder.recipefinder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    // TO-DO: Needs to change to POST and method contents added. Unit test needs to change accordingly.
    @GetMapping("/user")
    String foo() {
        return "User created successfully!";
    }
}
