package be.strouwi.intake.restcontrollers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/insertOppervlak.sql")
public class OppervlakteControllerTest extends AbstractTransactionalJUnit4SpringContextTests{
    private final MockMvc mvc;

    public OppervlakteControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }
    private long idVanTestOppervlak(){
        return jdbcTemplate.queryForObject(
                "select id from oppervlakte where object = 'test'",Long.class);
    }
   @Test
   void onbestaandObjectLezen() throws Exception{
       mvc.perform(get("/oppervlakte/{id}", -1))
               .andExpect(status().isNotFound());
   }

    @Test
    void oppervlakLezen() throws Exception{
        var id = idVanTestOppervlak();
        mvc.perform(get("/oppervlakte/{id}",id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(id));
    }
}