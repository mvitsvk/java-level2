package ru.level2.less2.array;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
