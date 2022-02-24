package co.com.favelezr.h2.team;

import co.com.favelezr.model.ITeamRepository;
import co.com.favelezr.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class TeamImpl implements ITeamRepository {

    private final TeamRepository repository;

    @Override
    public Mono<Team> find(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Team> create(Team team) {
        return repository.save(team);
    }

    @Override
    public Mono<Team> update(Team team) {
        return repository.save(team);
    }

    @Override
    public Mono<Void> delete(Team team) {
        return repository.delete(team);
    }
}
