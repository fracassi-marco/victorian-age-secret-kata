package com.example.victorianagesecretkata;

import java.util.ArrayList;
import java.util.List;

public class OneToOneRelations  implements Relations {

    private final List<Player> propagation = new ArrayList<>();
    private final List<Player> friends = new ArrayList<>();

    public void addFriend(Player friend) {
        friends.add(friend);
    }

    public void clear() {
        propagation.clear();
    }

    public void talk(String secret) {
        for (Player it : friends) {
            if (!propagation.contains(it)) {
                it.addSecret(secret);
                propagation.add(it);
                break;
            }
        }
    }

    public boolean talkedWithAll() {
        return propagation.size() == friends.size();
    }
}
