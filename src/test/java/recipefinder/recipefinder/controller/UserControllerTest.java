package recipefinder.recipefinder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.model.UserCredentials;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserController userController;

    @Test
    void shouldCreateUserSuccessfully() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new User())))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturn200() throws Exception{
        mockMvc.perform(get("/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateUserSuccessfully() throws Exception {
        mockMvc.perform(put("/user/{id}")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new User())))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldDeleteUserSucessfully() throws Exception{
        mockMvc.perform(get("/user/{id}", 1))
                .andExpect(status().isOk());
    }
}
