package com.example.victorianagesecretkata;

public record Secret(String value) {
    public static Secret emptySecret() {
        return new Secret("");
    }
}
