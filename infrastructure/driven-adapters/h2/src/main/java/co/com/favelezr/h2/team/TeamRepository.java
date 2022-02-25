package co.com.favelezr.h2.team;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TeamRepository extends ReactiveCrudRepository<TeamData, Long> {
}
