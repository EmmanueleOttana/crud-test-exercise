package co.develhope.crud.entity;

import co.develhope.crud.controller.UserController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserController userController;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void controllEntity(){ assertThat(userController).isNotNull(); }

    @Test
    void getAll() throws Exception {
        this.mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void getSingleUser() throws Exception {
        this.mockMvc.perform(get("/users/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void createUser() throws Exception {
        User user = new User(1,"Aldo","Baglio",50);
        String userJson = objectMapper.writeValueAsString(user);
        this.mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void updateAgeUser() throws Exception {
        createUser();
        this.mockMvc.perform(put("/users/1")
                        .param("eta","51"))
                        .andDo(print())
                        .andExpect(status().isOk());

    }
    //https://reversecoding.net/spring-mvc-requestparam-binding-request-parameters/
    @Test
    void deleteUser() throws Exception {
        createUser();
        this.mockMvc.perform(delete("/users/1"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }

}