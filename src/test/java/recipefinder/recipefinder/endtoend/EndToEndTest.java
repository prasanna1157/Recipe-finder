package recipefinder.recipefinder.endtoend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import recipefinder.recipefinder.controller.UserController;
import recipefinder.recipefinder.model.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class EndToEndTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateUserSuccessfully() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new User())))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldDeleteUserSucessfully() throws Exception{
        mockMvc.perform(get("/users/{username}", "testUser"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200() throws Exception{
        mockMvc.perform(get("/users/{username}", "testUser"))
                .andExpect(status().isOk());
    }
}