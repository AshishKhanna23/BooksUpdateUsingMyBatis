package com.ashish.BooksUpdateProject.exception;

public class NoBookFoundException extends RuntimeException{

    public NoBookFoundException(String s){
        super(s);
    }

    public NoBookFoundException() {

    }
}
