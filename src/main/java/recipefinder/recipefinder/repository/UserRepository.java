package recipefinder.recipefinder.repository;

import org.springframework.stereotype.Repository;
import recipefinder.recipefinder.exception.DuplicateUserException;
import recipefinder.recipefinder.exception.UserNotFoundException;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.model.UserCredentials;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<String, User> userMap;

    UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public UserRepository() {
        this.userMap = new HashMap<>();
        createTestUsers();
    }

    private void createTestUsers() {
        userMap.put("kevin", new User(new UserCredentials("kevin", "jero")));
        userMap.put("dummy", new User(new UserCredentials("dummy", "jero")));
    }

    public User getUser(String username) throws UserNotFoundException {

        if (userMap.containsKey(username)) {
            return userMap.get(username);
        }
        throw new UserNotFoundException("User with given id does not exist");
    }

    public void addUser(User user) throws DuplicateUserException {

        if(!userMap.containsKey(user.getUserCredentials().getUsername())) {
            userMap.put(user.getUserCredentials().getUsername(), user);
        }
        else
            throw new DuplicateUserException("User already exists");
    }

    public void removeUser(String username) throws UserNotFoundException {

        if (userMap.containsKey(username)) {
            userMap.remove(username);
        }
        else {
            throw new UserNotFoundException("User with given id does not exist");
        }
    }
 }
