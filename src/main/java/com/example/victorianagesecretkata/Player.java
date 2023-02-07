package com.example.victorianagesecretkata;

public class Player {

    private final String name;
    private final Secrets secrets = new Secrets();
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

    public void addSecret(Secret secret) {
        this.secrets.change(secret);
    }

    public Secret getSecret() {
        return secrets.current();
    }

    public void propagate() {
        relations.talk(secrets);
    }

    public boolean hasSecret() {
        return secrets.isNotEmpty();
    }
}
