package co.com.favelezr.h2.team;

import co.com.favelezr.model.ITeamRepository;
import co.com.favelezr.model.Team;
import co.com.favelezr.model.exception.RepositoryException;
import co.com.favelezr.model.exception.RepositoryMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TeamImpl implements ITeamRepository {

    private static final Logger log = LoggerFactory.getLogger(TeamImpl.class);

    @Autowired
    private TeamRepository repository;

    @Override
    public Mono<Team> find(String name) {
        log.info("Requesting team with name: {}", name);
        return repository.findById(name)
                .map(this::toDTO)
                .switchIfEmpty(Mono.error(new RepositoryException(RepositoryMessage.TEAM_NOT_FOUND)));
    }

    @Override
    public Flux<Team> findAll() {
        log.info("Requesting all teams");
        return repository.findAllOrderByStadiumCapacity()
                .map(this::toDTO);
    }

    @Override
    public Mono<Team> create(Team team) {
        log.info("Creating team: {}", team);
        TeamEntity entity = toEntity(team);
        entity.setNew(true);
        return repository.save(entity)
                .onErrorMap(Exception.class,
                        err -> new RepositoryException(RepositoryMessage.CREATE_TEAM_GENERAL_ERROR))
                .map(this::toDTO);
    }

    @Override
    public Mono<Team> update(Team team) {
        log.info("Updating team: {}", team);
        TeamEntity entity = toEntity(team);
        entity.setNew(false);
        return repository.save(entity)
                .onErrorMap(Exception.class,
                        err -> new RepositoryException(RepositoryMessage.UPDATE_TEAM_GENERAL_ERROR))
                .map(this::toDTO);
    }

    @Override
    public Mono<String> delete(String name) {
        log.info("Deleting team: {}", name);
        return repository.deleteByName(name)
                .filter(rowsAffected -> rowsAffected > 0)
                .map(success -> name)
                .switchIfEmpty(Mono.error(new RepositoryException(RepositoryMessage.DELETE_TEAM_NOT_FOUND)));
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
