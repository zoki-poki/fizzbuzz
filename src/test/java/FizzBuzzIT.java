import org.example.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Application.class})
@SpringBootTest(
        classes = Application.class)
@AutoConfigureMockMvc
public class FizzBuzzIT {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenEntry3_whenGetResults_thenStatus200()
            throws Exception {

        mvc.perform(get("/fizzbuzz?entry=3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("fizz"));
    }
    @Test
    public void givenEntry5_whenGetResults_thenStatus200()
            throws Exception {

        mvc.perform(get("/fizzbuzz?entry=5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("buzz"));
    }

    @Test
    public void givenEntry15_whenGetResults_thenStatus200()
            throws Exception {

        mvc.perform(get("/fizzbuzz?entry=15")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("fizzbuzz"));
    }

    @Test
    public void givenEmptyEntry_whenGetResults_thenStatus200()
            throws Exception {

        mvc.perform(get("/fizzbuzz?entry=")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenMissingEntry_whenGetResults_thenStatus400()
            throws Exception {

        mvc.perform(get("/fizzbuzz?entry")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenNotIntEntry_whenGetResults_thenStatus400()
            throws Exception {

        mvc.perform(get("/fizzbuzz?entry")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
