package ru.level2.less2.array;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
