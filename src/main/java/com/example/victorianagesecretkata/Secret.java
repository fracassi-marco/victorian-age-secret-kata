package com.example.victorianagesecretkata;

public class Secret {

    private String secret;
    private String oldSecret = "";

    public Secret(String secret) {
        this.secret = secret;
    }

    public static Secret emptySecret() {
        return new Secret("");
    }

    public void change(String secret) {
        if(oldSecret.equals("")) {
            oldSecret = secret;
        }
        this.secret = secret;
    }

    public String value() {
        return secret;
    }

    public boolean isToPropagate() {
        boolean equals = oldSecret.equals(secret);
        if(!equals) {
            oldSecret = secret;
        }
        return equals;
    }

    public void reset() {
        secret = "";
        oldSecret = "";
    }

    public boolean isNotEmpty() {
        return !secret.equals("");
    }
}
