package com.example.techchallengetres.exception;

import java.io.Serial;

public class RestauranteException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public RestauranteException(String message, Exception e) {super(message, e);}

    public RestauranteException(String message) {super(message);}
}
