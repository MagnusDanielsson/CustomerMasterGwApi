package com.lindex.customermastergwapi.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response<T> {
    private Boolean success;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private T payload;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private List<Error> errors = Collections.emptyList();

    public Response() {
        this.success = true;
        this.payload = null;
    }

    public Response(Boolean success) {
        this.success = success;
    }

    public Response(Boolean success, List<Error> errors) {
        this.success = success;
        this.errors = errors;
    }

    public Response(Boolean success, T payload) {
        this.success = success;
        this.payload = payload;
    }

    public Response(Boolean success, T payload, List<Error> errors) {
        this.success = success;
        this.payload = payload;
        this.errors = errors;
    }

    public static <T> Response<T> of(Boolean success) {
        return new Response(success);
    }

    public static <T> Response<T> of(Boolean success, T payload) {
        return new Response(success, payload);
    }

    public static <T> Response<T> of(Boolean success, List<Error> errors) {
        return new Response(success, errors);
    }

    public static <T> Response<T> of(Boolean success, T payload, List<Error> errors) {
        return new Response(success, payload, errors);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}