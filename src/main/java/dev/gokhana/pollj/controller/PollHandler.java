package dev.gokhana.pollj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class PollHandler {

    public Mono<ServerResponse> getPolls(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(
                        Mono.just("Welcome to pollJ"), String.class
                );
    }
    /**
     * Serves a JSON stream
     */
    public Mono<ServerResponse> fluxMessage(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Flux.just("Welcome ", "to ", "pollJ")
                                .delayElements(Duration.ofSeconds(1)).log(), String.class
                );
    }
}