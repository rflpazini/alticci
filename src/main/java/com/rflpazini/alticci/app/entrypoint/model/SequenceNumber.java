package com.rflpazini.alticci.app.entrypoint.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class SequenceNumber {

    private int number;

    public SequenceNumber() {
    }

    public SequenceNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
