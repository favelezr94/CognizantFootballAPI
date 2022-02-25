package co.com.favelezr.h2.team;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamRepository extends ReactiveCrudRepository<TeamEntity, String> {

    @Query("SELECT * FROM TEAM ORDER BY stadium_capacity DESC")
    Flux<TeamEntity> findAllOrderByStadiumCapacity();

    Mono<Void> deleteByName(String name);
}
