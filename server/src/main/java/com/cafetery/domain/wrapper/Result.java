package com.cafetery.domain.wrapper;

public class Result<T> {

    public Result() { }

    public Result(T domain) {
       this.domain = domain;
    }

    private T domain;

    private String error;

    public T getDomain() {
        return domain;
    }

    public void setDomain(T domain) {
        this.domain = domain;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
