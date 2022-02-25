package co.com.favelezr.api.team;

import co.com.favelezr.model.Team;
import co.com.favelezr.usecase.TeamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class TeamHandler {

    private static final String NAME = "name";
    private final TeamUseCase useCase;

    public Mono<ServerResponse> find(ServerRequest request) {
        return useCase.findByName(request.pathVariable(NAME))
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> findAll() {
        return useCase.findAll()
                .collectList()
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(Team.class)
                .flatMap(useCase::create)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return request.bodyToMono(Team.class)
                .flatMap(useCase::update)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return useCase.delete(request.pathVariable(NAME))
                .then(ServerResponse.ok().bodyValue("Team Deleted!"));
    }

}
