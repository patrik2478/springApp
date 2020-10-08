package hr.tvz.mede.studapp.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws  Exception{
        this.mockMvc
                .perform(get("/course").with(user("admin").password("test")
                        .roles("USER", "ADMIN")))
                .andExpect(status().isOk());

    }

    @Test
    void getByStudentJMBAG() throws Exception {
        final String jmbag = "0246077242";

        this.mockMvc.perform(get("/course/{jmbag}",jmbag)
                .with(user("admin")
                        .password("test")
                        .roles("ADMIN")
                )
        )
                .andExpect(status().isOk());
    }


}