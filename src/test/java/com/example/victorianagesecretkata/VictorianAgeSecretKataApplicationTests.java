package com.example.victorianagesecretkata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VictorianAgeSecretKataApplicationTests {
    private final Kata kata = new Kata();

    @Test
    void askSecretToPlayerWithSecret() {
        kata.talksWith("Mr. Blue", "Mr. Pink");
        kata.secret("Mr. Blue", "Gossip1");
        assertThat(kata.ask("Mr. Blue")).isEqualTo("Gossip1");
    }

    @Test
    void propagateSecret() {
        kata.talksWith("Mr. Blue", "Mr. Pink");
        kata.secret("Mr. Blue", "Gossip1");
        kata.propagate();
        assertThat(kata.ask("Mr. Pink")).isEqualTo("Gossip1");
        assertThat(kata.ask("Mr. Blue")).isEqualTo("");
    }

    @Test
    void propagateToFirstFriendAndLoseSecretWhenIsPropagatedToAllFriends() {
        kata.talksWith("Mr. Blue", "Mr. Pink");
        kata.secret("Mr. Blue", "Gossip1");
        kata.propagate();

        kata.talksWith("Mr. Blue", "Mr. Brown");
        kata.secret("Mr. Blue", "Gossip2");
        kata.propagate();

        assertThat(kata.ask("Mr. Pink")).isEqualTo("Gossip2");
        assertThat(kata.ask("Mr. Brown")).isEqualTo("");
        assertThat(kata.ask("Mr. Blue")).isEqualTo("Gossip2");
    }
}
