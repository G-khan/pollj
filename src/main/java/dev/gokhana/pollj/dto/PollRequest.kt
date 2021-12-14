package dev.gokhana.pollj.dto


data class PollRequest(
    var question: String,
    var pollLength: PollExpiration
)