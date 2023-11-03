package br.com.rennanprysthon.wordsearch.model;

public class WordMatrixInvalidException extends RuntimeException {
    public WordMatrixInvalidException(String message) {
        super(message);
    }

    public WordMatrixInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
