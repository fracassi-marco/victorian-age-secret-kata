package com.example.victorianagesecretkata;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private String oldSecret = "";
    private String secret = "";
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
        if(oldSecret.equals("")) {
            oldSecret = secret;
        }
        this.secret = secret;
        this.propagation.clear();
    }

    public String getSecret() {
        return secret;
    }

    public void propagate() {
        if(oldSecret.equals(secret)){
            for (Player it : friends) {
                if (!propagation.contains(it)) {
                    it.addSecret(secret);
                    propagation.add(it);
                    break;
                }
            }
            if(propagation.size() == friends.size()) {
                secret = "";
                oldSecret = "";
            }
        }
        else {
            oldSecret = secret;
        }
    }

    public boolean hasSecret() {
        return !secret.equals("");
    }
}
