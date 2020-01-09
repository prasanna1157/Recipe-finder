package recipefinder.recipefinder.endtoend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import recipefinder.recipefinder.model.User;
import recipefinder.recipefinder.model.UserCredentials;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EndToEndTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateUserSuccessfully() throws Exception {
        User user = new User(new UserCredentials("pietersen", "jero"));

        mockMvc.perform(MockMvcRequestBuilders
                .post("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteUserSucessfully() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/users/{username}", "kevin"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/{username}", "kevin"))
                .andExpect(status().isOk());
    }
}