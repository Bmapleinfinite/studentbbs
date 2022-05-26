package com.example.studentbbs.util;

import java.io.Serializable;

public class Result implements Serializable {
    private int resultCode;

    private String message;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result resultCode(int resultCode) {
        setResultCode(resultCode);
        return this;
    }

    public Result message(String message) {
        setMessage(message);
        return this;
    }

    public String toString() {
        return "{ resultCode='" +
                getResultCode() + "'" +
                ", message='" + getMessage() + "'" +
                "}";
    }
}
