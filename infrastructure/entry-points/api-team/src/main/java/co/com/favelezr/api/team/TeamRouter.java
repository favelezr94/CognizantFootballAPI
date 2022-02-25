package co.com.favelezr.api.team;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@RequiredArgsConstructor
public class TeamRouter {

    private static final String FIND = "/find/{name}";
    private static final String FIND_ALL = "/findAll";
    private static final String CREATE = "/create";
    private static final String UPDATE = "/update";
    private static final String DELETE = "/delete/{name}";

    @Bean
    public RouterFunction<ServerResponse> router(TeamHandler handler) {
        return RouterFunctions.route()
                .GET(FIND, handler::find)
                .GET(FIND_ALL, request -> handler.findAll())
                .POST(CREATE, accept(APPLICATION_JSON), handler::create)
                .PUT(UPDATE, accept(APPLICATION_JSON), handler::update)
                .DELETE(DELETE, handler::delete)
                .build();

    }
}
