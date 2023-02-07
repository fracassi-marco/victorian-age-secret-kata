package com.example.victorianagesecretkata;

import java.util.LinkedList;
import java.util.Queue;

import static com.example.victorianagesecretkata.Secret.emptySecret;

public class Secrets {

    private final Queue<Secret> queue = new LinkedList<>();
    private Secret current = emptySecret();

    public void change(Secret secret) {
        queue.add(secret);
        if(current.equals(emptySecret())) {
            current = queue.poll();
        }
    }

    public Secret current() {
        return current;
    }

    public void reset() {
        if(queue.isEmpty())
            current = emptySecret();
        else
            current = queue.poll();
    }

    public boolean isNotEmpty() {
        return !current.equals(emptySecret());
    }
}
