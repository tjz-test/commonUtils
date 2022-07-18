package com.inspur.gs.commonutils.demo.bankoffer.core.result;

import lombok.Data;

/**
 * @author tjz
 * @date 2022/7/15
 * @description
 */
@Data
public class Result {

    private  Integer code;

    private  String message;

    private  Boolean success;

    private Object data;

    private Result() {}

    public static Result success(){
        Result r = new Result();
        r.setSuccess(ResultCode.SUCCESS.isSuccess());
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMessage(ResultCode.SUCCESS.getMessage());
        return r;
    }

    public static Result success(Object data) {
        Result r = new Result();
        r.setSuccess(ResultCode.SUCCESS.isSuccess());
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMessage(ResultCode.SUCCESS.getMessage());
        r.setData(data);
        return r;
    }

    public static Result error(){
        Result r = new Result();
        r.setSuccess(ResultCode.FAILURE.isSuccess());
        r.setCode(ResultCode.FAILURE.getCode());
        r.setMessage(ResultCode.FAILURE.getMessage());
        return r;
    }

    public static Result setResult(ResultCode resultCode){
        Result r = new Result();
        r.setSuccess(resultCode.isSuccess());
        r.setCode(resultCode.getCode());
        r.setMessage(resultCode.getMessage());
        return r;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(Object data) {
        this.data = data;
        return this;
    }
}
