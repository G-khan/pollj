package dev.gokhana.pollj.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PollRouter {

    private final static String apiPrefix = "/api/polls";

    @Bean
    public RouterFunction<ServerResponse> functionalRoutes(PollHandler pollHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET(apiPrefix), pollHandler::getPolls)
                .andRoute(RequestPredicates.GET(apiPrefix + "/{id}"), pollHandler::getPollById)
                .andRoute(RequestPredicates.POST(apiPrefix), pollHandler::createPoll)
                .andRoute(RequestPredicates.GET(apiPrefix + "/{pollId}/votes"), pollHandler::castVote);
    }
}
