package com.example.victorianagesecretkata;

import java.util.ArrayList;
import java.util.List;

public class BroadcastRelations implements Relations {

    private final List<Player> friends = new ArrayList<>();

    @Override
    public void talk(String secret) {
        friends.forEach(it -> it.addSecret(secret));
    }

    @Override
    public void addFriend(Player friend) {
        friends.add(friend);
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean talkedWithAll() {
        return true;
    }
}
