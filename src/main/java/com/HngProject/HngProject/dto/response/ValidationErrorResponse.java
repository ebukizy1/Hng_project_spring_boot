package com.HngProject.HngProject.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public class ValidationErrorResponse {
    private int errorCode;
    private String errorMessage;
    private Date timestamp;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

