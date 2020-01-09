package recipefinder.recipefinder.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.model.UserCredentials;
import recipefinder.recipefinder.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    UserService userService;

    @InjectMocks
    private UserController userController = new UserController();

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User(new UserCredentials("kevin", "dummy"));
    }

    @Test
    void shouldGetUser() {
        when(userService.getUser("kevin")).thenReturn(testUser);
        User actual = userController.getUser("kevin");
        assertThat(actual).isEqualTo(testUser);
    }

    @Test
    void shouldAddUser() {
        userController.addUser(testUser);
        verify(userService).addUser(testUser);
    }

    @Test
    void shouldUpdateUser() {
        userController.updateUser(testUser);
        verify(userService).updateUser(testUser);
    }

    @Test
    void shouldRemoveUser() {
        String username = testUser.getUserCredentials().getUsername();
        userController.removeUser(username);
        verify(userService).removeUser(username);
    }
}