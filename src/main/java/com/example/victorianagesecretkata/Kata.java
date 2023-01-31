package com.example.victorianagesecretkata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Kata {

    private final List<Player> players = new ArrayList<>();

    public void talksWith(String player1Name, String player2Name) {
        Player player1 = findOrCreatePlayer(player1Name);
        Player player2 = findOrCreatePlayer(player2Name);
        player1.addFriend(player2);
    }

    public void secret(String player, String secret) {
        findOrCreatePlayer(player).addSecret(secret);
    }

    private Player findOrCreatePlayer(String player) {
        Optional<Player> first = players.stream().filter(it -> it.is(player)).findFirst();
        if(first.isEmpty()) {
            Player player1 = new Player(player);
            players.add(player1);
            return player1;
        }

        return first.get();
    }

    public String ask(String player) {
        return findOrCreatePlayer(player).getSecret();
    }

    public void propagate() {
        List<Player> playersWithSecret = players.stream().filter(Player::hasSecret).toList();
        playersWithSecret.forEach(Player::propagate);
    }
}
