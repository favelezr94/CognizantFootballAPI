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
    public Mono<Team> find(String name) {
        return repository.findByName(name)
                .map(this::toDTO);
    }

    @Override
    public Flux<Team> findAll() {
        return repository.findAll()
                .map(this::toDTO);
    }

    @Override
    public Mono<Team> create(Team team) {
        return repository.save(toEntity(team))
                .map(this::toDTO);
    }

    @Override
    public Mono<Team> update(Team team) {
        return repository.save(toEntity(team))
                .map(this::toDTO);
    }

    @Override
    public Mono<Void> delete(String name) {
        return repository.deleteByName(name);
    }

    private TeamEntity toEntity(Team team) {
        return TeamEntity.builder()
                .city(team.getCity())
                .competition(team.getCompetition())
                .creationDate(team.getCreationDate())
                .name(team.getName())
                .owner(team.getOwner())
                .playerNumber(team.getPlayerNumber())
                .stadiumCapacity(team.getStadiumCapacity())
                .tier(team.getTier())
                .build();
    }

    private Team toDTO(TeamEntity teamEntity) {
        return Team.builder()
                .name(teamEntity.getName())
                .city(teamEntity.getCity())
                .competition(teamEntity.getCompetition())
                .creationDate(teamEntity.getCreationDate())
                .owner(teamEntity.getOwner())
                .playerNumber(teamEntity.getPlayerNumber())
                .stadiumCapacity(teamEntity.getStadiumCapacity())
                .tier(teamEntity.getTier())
                .build();
    }
}
