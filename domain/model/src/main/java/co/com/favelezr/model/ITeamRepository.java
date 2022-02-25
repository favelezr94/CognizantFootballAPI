package co.com.favelezr.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITeamRepository {

    public Mono<Team> find(Long id);

    public Flux<Team> findAll();

    public Mono<Team> create(Team team);

    public Mono<Team> update(Team team);

    public Mono<Void> delete(Team team);
}
