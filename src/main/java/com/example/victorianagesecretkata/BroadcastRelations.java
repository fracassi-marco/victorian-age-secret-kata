package com.example.victorianagesecretkata;

import java.util.ArrayList;
import java.util.List;

public class BroadcastRelations implements Relations {

    private final List<Player> friends = new ArrayList<>();

    @Override
    public void talk(Secrets secrets) {
        friends.forEach(it -> it.addSecret(secrets.current()));
        secrets.reset();
    }

    @Override
    public void addFriend(Player friend) {
        friends.add(friend);
    }
}
