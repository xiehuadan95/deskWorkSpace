package com.cy.jt.common.exception;

public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 4956028347983361179L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
