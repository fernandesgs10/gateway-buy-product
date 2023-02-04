package br.com.gateway.buy.product.common;

public class FinnetConnectException extends RuntimeException {

    public FinnetConnectException(String message) {
        super(message);
    }

    public FinnetConnectException(String message, Throwable cause) {
        super(message, cause);
    }
}
