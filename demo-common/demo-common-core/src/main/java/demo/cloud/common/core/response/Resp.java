package demo.cloud.common.core.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class Resp<T> implements Serializable {


    private String code;

    private String msg;

    private T data;

    public static <T> Resp<T> succ() {
        Resp<T> resp = new Resp<>();
        resp.setData(null);
        resp.setMsg(RespEnum.OK.getMsg());
        resp.setCode(RespEnum.OK.value());
        return resp;
    }

    public static <T> Resp<T> succ(T data) {
        Resp<T> resp = new Resp<>();
        resp.setData(data);
        resp.setMsg(RespEnum.OK.getMsg());
        resp.setCode(RespEnum.OK.value());
        return resp;
    }

    public static <T> Resp<T> succ(T data, RespEnum respEnum) {
        Resp<T> resp = new Resp<>();
        resp.setData(data);
        resp.setMsg(respEnum.getMsg());
        resp.setCode(respEnum.value());
        return resp;
    }

    public static <T> Resp<T> fail(String msg) {

        Resp<T> serverResponseEntity = new Resp<>();
        serverResponseEntity.setMsg(msg);
        serverResponseEntity.setCode(RespEnum.SHOW_FAIL.value());
        return serverResponseEntity;
    }

    public static <T> Resp<T> fail(T data) {
        Resp<T> resp = new Resp<>();
        resp.setData(data);
        resp.setMsg(RespEnum.SHOW_FAIL.getMsg());
        resp.setCode(RespEnum.SHOW_FAIL.value());
        return resp;
    }

    public static <T> Resp<T> fail(T data, RespEnum respEnum) {
        Resp<T> resp = new Resp<>();
        resp.setData(data);
        resp.setMsg(respEnum.value());
        resp.setCode(respEnum.value());
        return resp;
    }


    public static <T> Resp<T> showFailMsg(String msg) {
        Resp<T> serverResponseEntity = new Resp<>();
        serverResponseEntity.setMsg(msg);
        serverResponseEntity.setCode(RespEnum.SHOW_FAIL.value());
        return serverResponseEntity;
    }

    public static <T> Resp<T> fail(RespEnum responseEnum) {
        Resp<T> serverResponseEntity = new Resp<>();
        serverResponseEntity.setMsg(responseEnum.getMsg());
        serverResponseEntity.setCode(responseEnum.value());
        return serverResponseEntity;
    }

    public static <T> Resp<T> fail(RespEnum responseEnum, T data) {

        Resp<T> serverResponseEntity = new Resp<>();
        serverResponseEntity.setMsg(responseEnum.getMsg());
        serverResponseEntity.setCode(responseEnum.value());
        serverResponseEntity.setData(data);
        return serverResponseEntity;
    }


}
