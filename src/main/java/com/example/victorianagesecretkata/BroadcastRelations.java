package com.example.victorianagesecretkata;

import java.util.ArrayList;
import java.util.List;

public class BroadcastRelations implements Relations {

    private final List<Player> friends = new ArrayList<>();

    @Override
    public void talk(Secret secret) {
        friends.forEach(it -> it.addSecret(secret.value()));
        secret.reset();
    }

    @Override
    public void addFriend(Player friend) {
        friends.add(friend);
    }
}
