package com.example.studentbbs.util;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    private static final int RESULT_CODE_SUCCESS = 200;

    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setResultCode(RESULT_CODE_SUCCESS);
        return result;
    }

    public static void genSuccessResult(String message) {
    }

    public static Result getFailResult(String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        return result;
    }
}
