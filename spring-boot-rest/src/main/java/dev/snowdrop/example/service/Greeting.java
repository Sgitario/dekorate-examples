package dev.snowdrop.example.service;

public class Greeting {

    public static final String FORMAT = "Hello, %s!";

    private final String content;

    public Greeting() {
        this.content = null;
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
