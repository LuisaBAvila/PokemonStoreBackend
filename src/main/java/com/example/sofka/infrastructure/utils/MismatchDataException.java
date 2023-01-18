package com.example.sofka.infrastructure.utils;

import org.springframework.dao.DataAccessException;
public class MismatchDataException extends DataAccessException {
    public MismatchDataException(String msg) {
        super(msg);
    }

    public MismatchDataException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
