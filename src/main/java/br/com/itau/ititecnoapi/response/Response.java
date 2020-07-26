package br.com.itau.ititecnoapi.response;

public class Response<T> {

    private T object;
    private String status;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
