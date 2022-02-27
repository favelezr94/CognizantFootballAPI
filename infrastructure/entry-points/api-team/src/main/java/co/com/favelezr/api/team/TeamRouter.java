package co.com.favelezr.api.team;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

@Configuration
@RequiredArgsConstructor
public class TeamRouter {

    private static final String FIND = "/find/{name}";
    private static final String FIND_ALL = "/findAll";
    private static final String SAVE = "/save";
    private static final String UPDATE = "/update";
    private static final String DELETE = "/delete/{name}";

    @Bean
    public RouterFunction<ServerResponse> router(TeamHandler handler) {
        return route()
                .GET(FIND, handler::find, TeamOpenAPI::findByName)
                .GET(FIND_ALL, request -> handler.findAll(), TeamOpenAPI::findAll)
                .POST(SAVE, accept(APPLICATION_JSON), handler::save, TeamOpenAPI::save)
                .PUT(UPDATE, accept(APPLICATION_JSON), handler::update, TeamOpenAPI::update)
                .DELETE(DELETE, handler::delete, TeamOpenAPI::delete)
                .build();

    }
}
