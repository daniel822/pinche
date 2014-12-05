package com.pinche.vo;

public class Success extends Response {

    private Object data;

    public Success(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
