package hr.tvz.mede.studapp.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.mede.studapp.Command.StudentCommand;
import hr.tvz.mede.studapp.Domain.Student;
import hr.tvz.mede.studapp.Dto.StudentDTO;
import hr.tvz.mede.studapp.Service.StudentService;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    StudentService studentService;

    private List<StudentDTO> studentList;

    ObjectMapper objectMapper;


    @Test
    void getAll() throws Exception {
        this.mockMvc
                .perform(get("/student").with(user("admin").password("test")
                        .roles("USER", "ADMIN")))
                .andExpect(status().isOk());

    }



    @Test
    void getByJMBAG() throws  Exception{
        final String jmbag = "0246077242";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/{jmbag}",jmbag)
                .with(user("admin")
                        .password("test")
                        .roles("ADMIN")
                ).with(csrf())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
        .andExpect(status().isFound());
    }

    @Test
    void save() throws Exception{
        String date = "18-08-1995";
        LocalDate date1 = LocalDate.of(2017, 1, 13);


        mockMvc.perform(MockMvcRequestBuilders.post("/student").with(user("admin")
                .password("test")
                .roles("ADMIN")
        ).with(csrf())
                .content(asJsonString(new StudentCommand("Patrik", "Mede", "0192837465", 150)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    //Metoda za labos
    @Test
    void update() throws  Exception{
        mockMvc.perform( MockMvcRequestBuilders
                .put("/student/{JMBAG}", "0246077242").with(user("ADMIN")
                        .password("test")
                        .roles("ADMIN")
                ).with(csrf())
                .content(asJsonString(new StudentCommand("Patrik", "Mede", "", 150)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn().getResolvedException().getMessage();
    }


  @Test
  void delete()throws  Exception{

      final String jmbag = "0246077222";

      this.mockMvc.perform(MockMvcRequestBuilders.delete("/student/{jmbag}",jmbag).
              with(user("DELETER")
              .password("test")
              .roles("DELETER","ADMIN")
      ).with(csrf()))
              .andExpect(status().isNoContent());
    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}