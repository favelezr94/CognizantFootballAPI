package co.com.favelezr.usecase;

import co.com.favelezr.model.ITeamRepository;
import co.com.favelezr.model.Team;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TeamUseCase {

    private final ITeamRepository repository;

    public Mono<Team> find(Long id) {
        return repository.find(id);
    }

    public Flux<Team> findAll() {
        return repository.findAll();
    }

    public Mono<Team> create(Team team) {
        return repository.create(team);
    }

    public Mono<Team> update(Team team) {
        return repository.update(team);
    }

    public Mono<Void> delete(Team team) {
        return repository.delete(team);
    }


}
