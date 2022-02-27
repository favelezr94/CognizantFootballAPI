package co.com.favelezr.usecase;

import co.com.favelezr.model.ITeamRepository;
import co.com.favelezr.model.Team;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TeamUseCase {

    private final ITeamRepository repository;

    public Mono<Team> findByName(String name) {
        return repository.find(name);
    }

    public Flux<Team> findAll() {
        return repository.findAll();
    }

    public Mono<Team> save(Team team) {
        return repository.save(team);
    }

    public Mono<Team> update(Team team) {
        return repository.update(team);
    }

    public Mono<String> delete(String name) {
        return repository.delete(name);
    }


}
