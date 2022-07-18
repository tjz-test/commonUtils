package com.inspur.gs.commonutils.demo.bankoffer.core.result;

import lombok.Getter;

/**
 * @author tjz
 * @date 2022/7/15
 * @description
 */
@Getter
public enum ResultCode {

    /**
     * 枚举项
     */
    SUCCESS(true, 200, "操作成功"),
    FAILURE(false, 400, "业务异常"),
    UN_AUTHORIZED(false, 401, "请求未授权"),
    CLIENT_UN_AUTHORIZED(false, 401, "客户端请求未授权"),
    NOT_FOUND(false, 404, "404 没找到请求"),
    MSG_NOT_READABLE(false, 400, "消息不能读取"),
    METHOD_NOT_SUPPORTED(false, 405, "不支持当前请求方法"),
    MEDIA_TYPE_NOT_SUPPORTED(false, 415, "不支持当前媒体类型"),
    REQ_REJECT(false, 403, "请求被拒绝"),
    INTERNAL_SERVER_ERROR(false, 500, "服务器异常"),
    PARAM_MISS(false, 400, "缺少必要的请求参数"),
    PARAM_TYPE_ERROR(false, 400, "请求参数类型错误"),
    PARAM_BIND_ERROR(false, 400, "请求参数绑定错误"),
    PARAM_VALID_ERROR(false, 400, "参数校验失败");

    private final boolean success;
    private final Integer code;
    private final String message;

    ResultCode(final Boolean success, final Integer code, final String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
