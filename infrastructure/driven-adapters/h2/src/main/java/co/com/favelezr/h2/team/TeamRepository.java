package co.com.favelezr.h2.team;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamRepository extends ReactiveCrudRepository<TeamEntity, String> {

    @Query("SELECT * FROM TEAM ORDER BY stadium_capacity DESC")
    Flux<TeamEntity> findAllOrderByStadiumCapacity();

    @Modifying
    @Query("DELETE FROM TEAM where name = $1 ")
    Mono<Integer> deleteByName(String name);
}
