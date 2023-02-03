package com.example.victorianagesecretkata;

public class NullRelations implements Relations {
    @Override
    public void talk(String secret) {
    }

    @Override
    public void addFriend(Player friend) {
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean talkedWithAll() {
        return false;
    }
}
