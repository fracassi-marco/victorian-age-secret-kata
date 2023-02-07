package com.example.victorianagesecretkata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Kata {

    private final List<Player> players = new ArrayList<>();

    public void talksWith(Player player1Name, Player player2Name) {
        Player player1 = findOrCreatePlayer(player1Name);
        Player player2 = findOrCreatePlayer(player2Name);
        player1.addFriend(player2);
    }

    public void secret(Player player, String secret) {
        findOrCreatePlayer(player).addSecret(new Secret(secret));
    }

    private Player findOrCreatePlayer(Player player) {
        Optional<Player> first = players.stream().filter(it -> it.is(player)).findFirst();
        if(first.isEmpty()) {
            players.add(player);
            return player;
        }

        return first.get();
    }

    public String ask(Player player) {
        return findOrCreatePlayer(player).getSecret().value();
    }

    public void propagate() {
        List<Player> playersWithSecret = players.stream().filter(Player::hasSecret).toList();
        playersWithSecret.forEach(Player::propagate);
    }
}
