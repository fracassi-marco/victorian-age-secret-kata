package com.example.victorianagesecretkata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VictorianAgeSecretKataApplicationTests {
    private final Kata kata = new Kata();

    @Test
    void askSecretToPlayerWithSecret() {
        Player mrBlue = new Player("Mr. Blue", new OneToOneRelations());
        Player mrPink = new Player("Mr. Pink", new OneToOneRelations());
        kata.talksWith(mrBlue, mrPink);
        kata.secret(mrBlue, "Gossip1");
        assertThat(kata.ask(mrBlue)).isEqualTo("Gossip1");
    }

    @Test
    void propagateSecret() {
        Player mrBlue = new Player("Mr. Blue", new OneToOneRelations());
        Player mrPink = new Player("Mr. Pink", new OneToOneRelations());
        kata.talksWith(mrBlue, mrPink);
        kata.secret(mrBlue, "Gossip1");
        kata.propagate();
        assertThat(kata.ask(mrPink)).isEqualTo("Gossip1");
        assertThat(kata.ask(mrBlue)).isEqualTo("");
    }

    @Test
    void propagateToFirstFriendAndLoseSecretWhenIsPropagatedToAllFriends() {
        Player mrBlue = new Player("Mr. Blue", new OneToOneRelations());
        Player mrPink = new Player("Mr. Pink", new OneToOneRelations());
        Player mrBrown = new Player("Mr. Brown", new OneToOneRelations());
        kata.talksWith(mrBlue, mrPink);
        kata.secret(mrBlue, "Gossip1");
        kata.propagate();

        kata.talksWith(mrBlue, mrBrown);
        kata.secret(mrBlue, "Gossip2");
        kata.propagate();

        assertThat(kata.ask(mrPink)).isEqualTo("Gossip2");
        assertThat(kata.ask(mrBrown)).isEqualTo("");
        assertThat(kata.ask(mrBlue)).isEqualTo("Gossip2");
    }
}
