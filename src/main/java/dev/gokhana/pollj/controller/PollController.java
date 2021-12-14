package dev.gokhana.pollj.controller;

import dev.gokhana.pollj.dto.PollRequest;
import dev.gokhana.pollj.entity.Poll;
import dev.gokhana.pollj.service.PollService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    private PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping
    public Flux<Poll> getPolls(@AuthenticationPrincipal OAuth2User oauth2User) {
        return pollService.getAllPolls();
    }

    @PostMapping
    public Mono<Poll> createPoll(@RequestBody PollRequest pollRequest) {
        Mono<Poll> poll = pollService.createPoll(pollRequest);
        return poll;
    }
}