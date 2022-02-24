package co.com.favelezr.h2.team;

import co.com.favelezr.model.Team;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TeamRepository extends ReactiveCrudRepository<Team, String> {
}
