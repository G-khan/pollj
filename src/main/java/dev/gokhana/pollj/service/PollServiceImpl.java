package dev.gokhana.pollj.service;

import dev.gokhana.pollj.dto.PollRequest;
import dev.gokhana.pollj.entity.Poll;
import dev.gokhana.pollj.repository.PollRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Service
public class PollServiceImpl implements PollService {


    private final PollRepository pollRepository;

    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;

    }

    @Override
    public Flux<Poll> getAllPolls() {
        // Retrieve Polls
        Flux<Poll> polls = pollRepository.findAll();
        return polls;
    }

    @Override
    public Mono<Poll> createPoll(PollRequest pollRequest) {
        Poll poll = new Poll();
        poll.setQuestion(pollRequest.getQuestion());

        Instant now = Instant.now();
        Instant expirationDateTime = now.plus(Duration.ofDays(pollRequest.getPollLength().getDays()))
                .plus(Duration.ofHours(pollRequest.getPollLength().getHours()));

        poll.setExpirationDateTime(expirationDateTime);

        return pollRepository.save(poll);
    }

}
