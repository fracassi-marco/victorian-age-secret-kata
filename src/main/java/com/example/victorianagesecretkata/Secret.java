package com.example.victorianagesecretkata;

import java.util.LinkedList;
import java.util.Queue;

public class Secret {

    private final Queue<String> queue = new LinkedList<>();
    private String secret;

    public Secret(String secret) {
        this.secret = secret;
    }

    public static Secret emptySecret() {
        return new Secret("");
    }

    public void change(String secret) {
        queue.add(secret);
        if(this.secret.equals("")) {
            this.secret = queue.poll();
        }
    }

    public String value() {
        return secret;
    }

    public void reset() {
        if(queue.isEmpty())
            secret = "";
        else
            secret = queue.poll();
    }

    public boolean isNotEmpty() {
        return !secret.equals("");
    }
}
