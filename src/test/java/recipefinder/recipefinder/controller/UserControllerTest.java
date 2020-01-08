package recipefinder.recipefinder.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @Test
    void shouldCreateUserSuccessfully() {

        //Given

        //When
        String actual = userController.foo();

        String expected = "User created successfully!";

        //Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturn200() throws Exception{
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk());
    }
}
