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

    @Test
    void broadcastRelations() {
        Player ladyViolet = new Player("Lady Violet", new BroadcastRelations());
        Player mrBlue = new Player("Mr. Blue", new OneToOneRelations());
        Player mrBrown = new Player("Mr. Brown", new OneToOneRelations());
        kata.talksWith(ladyViolet, mrBlue);
        kata.talksWith(ladyViolet, mrBrown);
        kata.secret(ladyViolet, "Gossip5");
        kata.propagate();
        assertThat(kata.ask(mrBrown)).isEqualTo("Gossip5");
        assertThat(kata.ask(mrBlue)).isEqualTo("Gossip5");
        assertThat(kata.ask(ladyViolet)).isEqualTo("");
    }

    @Test
    void doctor() {
        Player drBlack = new Player("Dr.Black", new OneToOneRelations());
        Player mrBlue = new Player("Mr. Blue", new OneToOneRelations());
        Player mrPink = new Player("Mr. Pink", new OneToOneRelations());
        kata.talksWith(drBlack, mrBlue);
        kata.talksWith(drBlack, mrPink);
        kata.secret(drBlack, "Gossip6");
        kata.propagate();
        assertThat(kata.ask(mrBlue)).isEqualTo("Gossip6");
        assertThat(kata.ask(mrPink)).isEqualTo("");
        kata.secret(drBlack, "Gossip7");
        kata.propagate();
        assertThat(kata.ask(mrPink)).isEqualTo("Gossip6");
        kata.propagate();
        assertThat(kata.ask(mrBlue)).isEqualTo("Gossip7");
    }
}
