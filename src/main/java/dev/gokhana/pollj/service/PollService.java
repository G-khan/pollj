package dev.gokhana.pollj.service;

import dev.gokhana.pollj.dto.PollRequest;
import dev.gokhana.pollj.entity.Poll;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PollService {

    Flux<Poll> getAllPolls();

    Mono<Poll> createPoll(PollRequest pollRequest);
}
