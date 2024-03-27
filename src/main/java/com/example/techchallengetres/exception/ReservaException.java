package com.example.techchallengetres.exception;

import java.io.Serial;

public class ReservaException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public ReservaException(String message, Exception e) {super(message, e);}

    public ReservaException(String message) {super(message);}
}
