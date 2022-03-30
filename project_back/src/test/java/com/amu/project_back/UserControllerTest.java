package com.amu.project_back;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class UserControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    private String jwt;

    @BeforeEach
    public void setup() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        String body = "{\n" +
                "  \"email\": \"mohamed.takhchi@etu.univ-amu.fr\",\n" +
                "  \"password\": \"service\"\n" +
                "}";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/api/login").content(body).contentType(MediaType.APPLICATION_JSON)).andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.replace("{\"access_token\": \"", "");
        String token = response.replace("\"}", "");
        String[] temp = token.split(",");
        token = temp[0].split(":")[1].replace("\"","");
        jwt = token;
    }



    @Test
    public void loginTest() throws Exception {
        String body = "{\n" +
                    "  \"email\": \"mohamed.takhchi@etu.univ-amu.fr\",\n" +
                    "  \"password\": \"service\"\n" +
                    "}";
        mvc.perform(MockMvcRequestBuilders.post("/api/login")
                    .content(body).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    public void getUsersTest() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/api/users/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + jwt))
                    .andExpect(status().isOk());
    }
    @Test
    public void getUserTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/users/39")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + jwt))
                    .andExpect(status().isOk());
    }
    @Test
    public void getUsersFromRefTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/users/ref/2")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + jwt))
                    .andExpect(status().isOk());
    }
    @Test
    public void getNewUsersTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/users/new")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + jwt))
                    .andExpect(status().isOk());
    }



}

