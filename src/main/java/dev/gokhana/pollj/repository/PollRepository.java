package dev.gokhana.pollj.repository;

import dev.gokhana.pollj.entity.Poll;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface PollRepository extends ReactiveCrudRepository<Poll, Long> {
    Flux<Poll> findByIdIn(List<Long> pollIds);
}