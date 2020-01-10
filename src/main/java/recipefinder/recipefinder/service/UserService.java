package recipefinder.recipefinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipefinder.recipefinder.exception.DuplicateUserException;
import recipefinder.recipefinder.exception.UserNotFoundException;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.repository.UserRepository;

@Service
public class UserService {

    UserService() {
    }

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username) throws UserNotFoundException {
        return userRepository.getUser(username);
    }

    public void addUser(User user) throws DuplicateUserException {
        userRepository.addUser(user);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public void removeUser(String username) throws UserNotFoundException {
        userRepository.removeUser(username);
    }
}