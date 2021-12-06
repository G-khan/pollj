package dev.gokhana.pollj.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PollRouter {
    @Bean
    public RouterFunction<ServerResponse> functionalRoutes(PollHandler pollHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/functional/mono")
                        , pollHandler::getPolls)
                .andRoute(RequestPredicates.GET("functional/flux")
                        , pollHandler::fluxMessage);
    }
}
