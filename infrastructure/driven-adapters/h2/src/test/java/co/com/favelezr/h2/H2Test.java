package co.com.favelezr.h2;

import co.com.favelezr.h2.team.TeamEntity;
import co.com.favelezr.h2.team.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class H2Test {

    @Autowired
    private TeamRepository repository;

    @Test
    public void whenDeleteAll_then0IsExpected() {
        repository.findByName("Liverpo")
                .as(StepVerifier::create)
                .expectNextCount(1);
    }
}
