package com.example.techchallengetres.exception;

import java.io.Serial;

public class MesaException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public MesaException(String message, Exception e) {super(message, e);}

    public MesaException(String message) {super(message);}
}
