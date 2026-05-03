package com.example.demo.exception;

public class NoAccountFoundException extends Exception {

    public NoAccountFoundException() {
        super("No account found");
    }
}
