package org.pucit.template;


import com.google.gson.Gson;
import org.pucit.org.pucit.enumerators.ResponseType;

public class ResponseTpl {
    private String resType;
    private String msg;
    private Object data = null;
    public String getResType() {
        return resType.toString();
    }

    public void setResponseType(ResponseType resType) {
        this.resType = resType.getResponseType();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
