package com.soumya.ekart.exception;

public class ResourceNotFoundException extends RuntimeException {
    private String resource;
    private String field;
    private String value;

    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s Not Found With %s : %s",resource,field,value));
        this.resource = resource;
        this.field = field;
        this.value = value;
    }
}
