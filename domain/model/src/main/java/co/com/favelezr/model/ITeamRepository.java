package co.com.favelezr.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITeamRepository {

    public Mono<Team> find(String name);

    public Flux<Team> findAll();

    public Mono<Team> save(Team team);

    public Mono<Team> update(Team team);

    public Mono<String> delete(String name);
}
