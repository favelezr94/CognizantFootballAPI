package co.com.favelezr.h2.team;

import co.com.favelezr.model.ITeamRepository;
import co.com.favelezr.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TeamImpl implements ITeamRepository {

    @Autowired
    private TeamRepository repository;

    @Override
    public Mono<Team> find(Long id) {
//        return repository.findById(id);
        return null;
    }

    @Override
    public Flux<Team> findAll() {
//        return repository.findAll();
        return null;
    }

    @Override
    public Mono<Team> create(Team team) {
//        return repository.save(team);
        return null;
    }

    @Override
    public Mono<Team> update(Team team) {
//        return repository.save(team);
        return null;
    }

    @Override
    public Mono<Void> delete(Team team) {
//        return repository.delete(team);
        return null;
    }
}
