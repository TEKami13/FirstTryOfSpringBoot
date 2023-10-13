package no.tobias.firstspringboot;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PartsServerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void shouldGetListOfParts() throws Exception{
        mockMvc
                .perform(get("/api/parts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("cog")));
    }

    @Test
    @Order((2))
    void shouldEditPart() throws Exception{
        mockMvc
                .perform(put("/api/parts/wrench").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"cog\"}"))
                .andExpect(status().isOk());
        mockMvc
                .perform(get("/api/parts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("wrench")));
    }

    @Test
    @Order(3)
    void shouldPostPart() throws Exception{
        mockMvc
                .perform(post("/api/parts").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"screw\"}"))
                .andExpect(status().isOk());
        mockMvc
                .perform(get("/api/parts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("screw")));
    }

    @Test
    @Order(4)
    void shouldDeletePart() throws Exception{
        mockMvc
                .perform(delete("/api/parts/cog"))
                .andExpect(status().isOk());
        mockMvc
                .perform(get("/api/parts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(not("cog")));
    }
}
