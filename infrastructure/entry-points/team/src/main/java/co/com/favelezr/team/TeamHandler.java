package co.com.favelezr.team;

import co.com.favelezr.usecase.TeamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class TeamHandler {

    private final TeamUseCase useCase;

    public Mono<ServerResponse> find(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> findAll() {
        return null;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return null;
    }
}
