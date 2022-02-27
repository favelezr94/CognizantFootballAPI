package co.com.favelezr.api.team.validator;

import co.com.favelezr.model.Team;
import co.com.favelezr.model.exception.RepositoryException;
import co.com.favelezr.model.exception.RepositoryMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.validation.Validator;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class RequestValidator {
    private final Validator validator;

    public Mono<Team> isValidBody(TeamDTO teamDTO) {
        return Mono.just(teamDTO)
                .map(validator::validate)
                .map(Set::isEmpty)
                .filter(validBody -> validBody && isCapacityOk(teamDTO.getTier(), teamDTO.getStadiumCapacity()))
                .map(valid -> toTeam(teamDTO))
                .switchIfEmpty(Mono.error(new RepositoryException(RepositoryMessage.VALIDATION_ERROR)));
    }

    private Team toTeam(TeamDTO teamDTO) {
        return Team.builder()
                .name(teamDTO.getName())
                .city(teamDTO.getCity())
                .competition(teamDTO.getCompetition())
                .creationDate(teamDTO.getCreationDate())
                .owner(teamDTO.getOwner())
                .playerNumber(teamDTO.getPlayerNumber())
                .stadiumCapacity(teamDTO.getStadiumCapacity())
                .tier(teamDTO.getTier())
                .build();
    }

    private boolean isCapacityOk(String tier, int capacity) {
        return TierCapacityMapping.capacityByTier.get(tier) < capacity;
    }
}
