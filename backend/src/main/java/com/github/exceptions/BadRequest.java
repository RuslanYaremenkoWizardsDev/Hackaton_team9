package com.github.exceptions;

import java.io.IOException;

public class BadRequest extends IOException {
    public BadRequest() {
    }

    public BadRequest(String message) {
        super(message);
    }
}
