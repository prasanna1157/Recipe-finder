package recipefinder.recipefinder.controller;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipefinder.recipefinder.exception.DuplicateUserException;
import recipefinder.recipefinder.exception.UserNotFoundException;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    User getUser(@PathVariable("username") String username) {
        try {
            return userService.getUser(username);
        }
        catch(UserNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Not Found", e);
        }
    }

    @PostMapping("/")
    void addUser(@RequestBody User user) throws DuplicateUserException {
        Preconditions.checkNotNull(user);
        userService.addUser(user);
    }

    @DeleteMapping("/{username}")
    void removeUser(@PathVariable("username") String username) {
        try {
            userService.removeUser(username);
        }
        catch (UserNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Not Found", e);
        }
    }
}