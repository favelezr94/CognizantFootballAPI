package co.com.favelezr.api.team;

import co.com.favelezr.api.team.responses.ErrorResponse;
import co.com.favelezr.api.team.responses.SuccessResponse;
import co.com.favelezr.api.team.validator.RequestValidator;
import co.com.favelezr.api.team.validator.TeamDTO;
import co.com.favelezr.model.Team;
import co.com.favelezr.model.exception.RepositoryException;
import co.com.favelezr.usecase.TeamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamHandler {

    private static final String NAME = "name";
    private final RequestValidator validator;
    private final TeamUseCase useCase;

    public Mono<ServerResponse> find(ServerRequest request) {
        return useCase.findByName(request.pathVariable(NAME))
                .flatMap(response -> ServerResponse.ok().bodyValue(response))
                .onErrorResume(RepositoryException.class,
                        exception -> ServerResponse.badRequest().bodyValue(buildErrorResponse(exception)));
    }

    public Mono<ServerResponse> findAll() {
        return useCase.findAll()
                .collectList()
                .flatMap(response -> ServerResponse.ok().bodyValue(buildSuccessResponse(response)));
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(TeamDTO.class)
                .flatMap(validator::isValidBody)
                .flatMap(useCase::create)
                .flatMap(response -> ServerResponse.ok().bodyValue(buildSuccessResponse(response)))
                .onErrorResume(RepositoryException.class,
                        exception -> ServerResponse.badRequest().bodyValue(buildErrorResponse(exception)));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return request.bodyToMono(TeamDTO.class)
                .flatMap(validator::isValidBody)
                .flatMap(useCase::update)
                .flatMap(response -> ServerResponse.ok().bodyValue(buildSuccessResponse(response)))
                .onErrorResume(RepositoryException.class,
                        exception -> ServerResponse.badRequest().bodyValue(buildErrorResponse(exception)));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return useCase.delete(request.pathVariable(NAME))
                .flatMap(response -> ServerResponse.ok().bodyValue(buildSuccessResponse(response)))
                .onErrorResume(RepositoryException.class,
                        exception -> ServerResponse.badRequest().bodyValue(buildErrorResponse(exception)));
    }

    private ErrorResponse buildErrorResponse(RepositoryException exception) {
        return ErrorResponse.builder()
                .code(exception.getRepositoryMessage().getCode())
                .message(exception.getRepositoryMessage().getMessage())
                .build();
    }

    private SuccessResponse buildSuccessResponse(Team response) {
        return SuccessResponse.builder()
                .data(List.of(response))
                .build();
    }

    private SuccessResponse buildSuccessResponse(List<Team> response) {
        return SuccessResponse.builder()
                .data(Collections.singletonList(response))
                .build();
    }

    private SuccessResponse buildSuccessResponse(String response) {
        return SuccessResponse.builder()
                .data(List.of(response))
                .build();
    }

}
