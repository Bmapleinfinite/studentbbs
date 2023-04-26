/**
 * 后端返回结果类
 */
package com.example.studentbbs.util;

import java.io.Serializable;

public class Result implements Serializable {
    private int resultCode;

    private String message;

    private String fileDirectory;

    private Object data;


    public Result() {
    }

    public Result(int resultCode, String message, String fileDirectory) {
        this.resultCode = resultCode;
        this.message = message;
        this.fileDirectory = fileDirectory;
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

    public String getFileDirectory() {
        return this.fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public Result resultCode(int resultCode) {
        setResultCode(resultCode);
        return this;
    }

    public Result message(String message) {
        setMessage(message);
        return this;
    }

    public Result fileDirectory(String fileDirectory) {
        setFileDirectory(fileDirectory);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " resultCode='" + getResultCode() + "'" +
            ", message='" + getMessage() + "'" +
            ", fileDirectory='" + getFileDirectory() + "'" +
            "}";
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
