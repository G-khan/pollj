package dev.gokhana.pollj.repository;

import dev.gokhana.pollj.entity.Vote;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends ReactiveCrudRepository<Vote, Long> {

}
