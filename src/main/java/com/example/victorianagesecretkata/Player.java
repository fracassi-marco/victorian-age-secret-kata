package com.example.victorianagesecretkata;


import static com.example.victorianagesecretkata.Secret.emptySecret;

public class Player {

    private final String name;
    private final Secret secret = emptySecret();
    private final Relations relations;

    public Player(String name, Relations relations) {
        this.name = name;
        this.relations = relations;
    }

    public void addFriend(Player friend) {
        relations.addFriend(friend);
    }

    public boolean is(Player player) {
        return name.equals(player.name);
    }

    public void addSecret(String secret) {
        this.secret.change(secret);
        relations.clear();
    }

    public String getSecret() {
        return secret.value();
    }

    public void propagate() {
        if(secret.isToPropagate()){
            relations.talk(secret.value());
            if(relations.talkedWithAll()) {
                secret.reset();
            }
        }
    }

    public boolean hasSecret() {
        return secret.isNotEmpty();
    }
}
