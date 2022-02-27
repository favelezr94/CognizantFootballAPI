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

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamHandler {

    private static final String NAME = "name";
    private static final String SUCCESS = "Success";
    private static final String ERROR = "Error";
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

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(TeamDTO.class)
                .flatMap(validator::isValidBody)
                .flatMap(useCase::save)
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
                .flatMap(response -> ServerResponse.ok().
                        bodyValue(new DeleteResponse(SUCCESS, request.pathVariable(NAME))))
                .onErrorResume(RepositoryException.class,
                        exception -> ServerResponse.badRequest()
                                .bodyValue(new DeleteResponse(ERROR, request.pathVariable(NAME))));
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
                .data(response)
                .build();
    }

    @RequiredArgsConstructor
    static class DeleteResponse {
        private final String status;
        private final String name;
    }
}
