package recipefinder.recipefinder.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipefinder.recipefinder.exception.DuplicateUserException;
import recipefinder.recipefinder.exception.UserNotFoundException;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.model.UserCredentials;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryTest {

    private Map<String, User> testUsersMap = new HashMap<>();
    private User user1;
    private User user2;
    private UserRepository userRepository = new UserRepository(testUsersMap);

    @BeforeEach
    void init() {
        user1 = new User(new UserCredentials("kevin", "jero"));
        user2 = new User(new UserCredentials("dummy", "jero"));
        createTestUsers();
    }

    private void createTestUsers() {
        testUsersMap.put("kevin", user1);
        testUsersMap.put("dummy", user2);
    }

    @Test
    void shouldGetUser() {
        User actual = userRepository.getUser("kevin");
        assertThat(actual).isEqualTo(user1);
    }

    @Test
    void shouldThrowExceptionWhenGetUserIsCalledWithUserThatDoesNotExist() {
        User user = new User(new UserCredentials("lara", "jero"));
        UserNotFoundException exception =
                assertThrows(UserNotFoundException.class,
                        () -> userRepository.getUser(user.getUserCredentials().getUsername()),
                        "Expected UserNotFoundException() to be thrown, but it didn't");

        assertTrue(exception.getMessage().contains("User with given id does not exist"));
    }

    @Test
    void shouldAddUser() {
        User user = new User(new UserCredentials("lara", "jero"));
        userRepository.addUser(user);
        assertThat(testUsersMap.get(user.getUserCredentials().getUsername())).isEqualTo(user);
    }

    @Test
    void shouldThrowExceptionWhenAddUserIsCalledWithUserThatAlreadyExists() {
        DuplicateUserException exception =
                assertThrows(DuplicateUserException.class,
                        () -> userRepository.addUser(user1),
                        "Expected DuplicateUserException() to be thrown, but it didn't");

        assertTrue(exception.getMessage().contains("User already exists"));
    }

    @Test
    void shouldRemoveUser() {
        userRepository.removeUser(user2.getUserCredentials().getUsername());
        assertThat(testUsersMap.containsKey(user2.getUserCredentials().getUsername())).isEqualTo(false);
    }

    @Test
    void shouldThrowExceptionWhenRemoveUserIsCalledWithUserThatDoesNotExist() {
        User user = new User(new UserCredentials("lara", "jero"));

        UserNotFoundException exception =
                assertThrows(UserNotFoundException.class,
                        () -> userRepository.removeUser(user.getUserCredentials().getUsername()),
                        "Expected UserNotFoundException() to be thrown, but it didn't");

        assertTrue(exception.getMessage().contains("User with given id does not exist"));
    }
}