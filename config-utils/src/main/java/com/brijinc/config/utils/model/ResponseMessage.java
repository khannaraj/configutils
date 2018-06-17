package com.brijinc.config.utils.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to transport messages back to the client.
 *
 * @author rkhanna
 */
public class ResponseMessage {

    public enum Type {
        SUCCESS, WARNING, DANGER, INFO;
    }

    private Type type;
    private String text;
    private String code;
    
    private List<Error> errors = new ArrayList<>();

    public ResponseMessage(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    public ResponseMessage(Type type, String code, String message) {
        this.type = type;
        this.code = code;
        this.text = message;
    }

    public String getText() {
        return text;
    }

    public Type getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
    
    public static ResponseMessage success(String text) {
        return new ResponseMessage(Type.SUCCESS, text);
    }

    public static ResponseMessage warning(String text) {
        return new ResponseMessage(Type.WARNING, text);
    }

    public static ResponseMessage danger(String text) {
        return new ResponseMessage(Type.DANGER, text);
    }

    public static ResponseMessage info(String text) {
        return new ResponseMessage(Type.INFO, text);
    }


    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public void addError(String field, String code, String message) {
        this.errors.add(new Error(field, code, message));
    }

    class Error {

        private final String code;
        private final String message;
        private final String field;

        private Error(String field, String code, String message) {
            this.field = field;
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public String getField() {
            return field;
        }

    }

}
