package co.edu.entornos.estudiantes.exception;

import java.util.Date;
import java.util.Map;

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
    private Map<String, String> validationErrors;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ExceptionResponse(Date timestamp, String message, String details,
                             Map<String, String> validationErrors) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.validationErrors = validationErrors;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
