package recipefinder.recipefinder.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.model.UserCredentials;
import recipefinder.recipefinder.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserService();

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User(new UserCredentials("kevin", "dummy"));
    }

    @Test
    void shouldGetUser() {
        when(userRepository.getUser("kevin")).thenReturn(testUser);
        User actual = userService.getUser("kevin");
        assertThat(actual).isEqualTo(testUser);
    }

    @Test
    void shouldAddUser() {
        userService.addUser(testUser);
        verify(userRepository).addUser(testUser);
    }

    @Test
    void shouldRemoveUser() {
        String username = testUser.getUserCredentials().getUsername();
        userService.removeUser(username);
        verify(userRepository).removeUser(username);
    }
}