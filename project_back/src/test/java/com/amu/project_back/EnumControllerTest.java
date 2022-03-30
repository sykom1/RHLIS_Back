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
public class EnumControllerTest {

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
    public void getCnuTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/cnu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

    @Test
    public void getcCnrsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/cnrs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

    @Test
    public void getComponentsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/components")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

    @Test
    public void getContractsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/contracts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

    @Test
    public void getDiplomasTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/diplomas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

    @Test
    public void getStatusTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

    @Test
    public void getStatesTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/states")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

    @Test
    public void getTutellesTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/tutelles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

    @Test
    public void getFinancesTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/enum/finances")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwt))
                .andExpect(status().isOk());
    }

}