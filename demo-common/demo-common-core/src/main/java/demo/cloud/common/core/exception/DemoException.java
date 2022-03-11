package demo.cloud.common.core.exception;

import demo.cloud.common.core.response.RespEnum;

public class DemoException extends RuntimeException {


    private Object object;

    private RespEnum respEnum;

    public DemoException(String msg) {
        super(msg);
    }

    public DemoException(String msg, Object object) {
        super(msg);
        this.object = object;
    }

    public DemoException(String msg, Throwable cause) {
        super(msg, cause);
    }


    public DemoException(RespEnum respEnum) {
        super(respEnum.getMsg());
        this.respEnum = respEnum;
    }

    public DemoException(RespEnum respEnum, Object object) {
        super(respEnum.getMsg());
        this.respEnum = respEnum;
        this.object = object;
    }


    public Object getObject() {
        return object;
    }

    public RespEnum getResponseEnum() {
        return respEnum;
    }
}
