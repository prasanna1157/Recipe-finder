package recipefinder.recipefinder.repository;

import org.springframework.stereotype.Repository;
import recipefinder.recipefinder.model.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Integer, User> userMap;

    UserRepository(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    public User getUserFromId(Integer id) throws Exception {
        if(userMap.containsKey(id))
            return userMap.get(id);
        else
            throw new Exception("User with given id does not exist");
    }

    public void addUser(User user) throws Exception {
        if(userMap.containsKey(user.getId()))
            userMap.put(user.getId(), user);
        else
            throw new Exception("User already exists");
    }

    public void deleteUser(Integer id) throws Exception {
        if(userMap.containsKey(id))
            userMap.remove(id);
        else
            throw new Exception("User with given id does not exist");
    }

    public void updateUser(Integer id, User user) throws Exception {
        if(userMap.containsKey(id))
            userMap.replace(id, user);
        else
            throw new Exception("User with given id does not exist");
    }
 }
