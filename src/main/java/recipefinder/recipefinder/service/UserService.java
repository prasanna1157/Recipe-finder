package recipefinder.recipefinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserFromId(Integer id) throws Exception {
        return userRepository.getUserFromId(id);
    }

    public void addUser(User user) throws Exception {
        userRepository.addUser(user);
    }

    public void deleteUser(Integer id) throws Exception {
        userRepository.deleteUser(id);
    }

    public void updateUser(Integer id, User user) throws Exception {
        userRepository.updateUser(id, user);
    }
}
