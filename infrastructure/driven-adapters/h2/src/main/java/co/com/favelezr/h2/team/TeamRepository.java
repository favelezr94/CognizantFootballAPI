package co.com.favelezr.h2.team;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TeamRepository extends ReactiveCrudRepository<TeamEntity, Long> {
    Mono<TeamEntity> findByName(String name);

    Mono<Void> deleteByName(String name);
}
