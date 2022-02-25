package co.com.favelezr.h2;

import co.com.favelezr.h2.team.TeamData;
import co.com.favelezr.h2.team.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class H2Test {

    @Autowired
    private TeamRepository repository;

    @Test
    public void whenDeleteAll_then0IsExpected() {
        repository.save(new TeamData()).subscribe(System.out::println);
        System.out.println();

    }
}
