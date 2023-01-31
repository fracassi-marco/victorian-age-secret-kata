package com.example.victorianagesecretkata;

import java.util.ArrayList;
import java.util.List;

import static com.example.victorianagesecretkata.Secret.emptySecret;

public class Player {

    private final String name;
    private final Secret secret = emptySecret();
    private final List<Player> propagation = new ArrayList<>();
    private final List<Player> friends = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void addFriend(Player friend) {
        friends.add(friend);
    }

    public boolean is(String player) {
        return name.equals(player);
    }

    public void addSecret(String secret) {
        this.secret.change(secret);
        this.propagation.clear();
    }

    public String getSecret() {
        return secret.value();
    }

    public void propagate() {
        boolean propagate = secret.propagate();
        if(propagate){
            for (Player it : friends) {
                if (!propagation.contains(it)) {
                    it.addSecret(secret.value());
                    propagation.add(it);
                    break;
                }
            }
            if(propagation.size() == friends.size()) {
                secret.reset();
            }
        }
    }

    public boolean hasSecret() {
        return secret.isNotEmpty();
    }
}
