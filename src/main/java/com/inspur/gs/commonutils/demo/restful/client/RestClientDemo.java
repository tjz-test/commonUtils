package com.inspur.gs.commonutils.demo.restful.client;

import cn.hutool.http.HttpRequest;
import com.inspur.edp.cdp.common.utils.json.JsonUtil;
import com.inspur.gs.commonutils.demo.restful.RestDemoInterface;
import io.iec.edp.caf.commons.exception.CAFRuntimeException;
import io.iec.edp.caf.commons.exception.ExceptionLevel;
import io.iec.edp.caf.rest.client.RESTProxyClientFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;

import javax.ws.rs.client.ClientRequestFilter;
import java.util.HashMap;
import java.util.Map;

/**
 * 调用restful接口
 * 使用平台发布接口默认走api-key(jwt认证)
 * 该demo为api-key 统一调用方式
 */
public class RestClientDemo {
    public void getXXX() {
        //String url = "http://localhost:5200/api/eis4j/eiscore/v1.0/imageapi/getyxurlmap?api-key=808e7f91-9337-5935-372e-1fde6017fea5";
        String url = "xxxx?api-key=aaaaaa";
        //参数
        Map<String,String> requestMap = new HashMap<>();
        //header
        Map<String,String> header = new HashMap<>();
        header.put("language", "zh-CHS");
        header.put("X-ECC-Current-Tenant", "919455");
        header.put("Content-type", "application/json;charset=utf-8");
        header.put("Connection", "Close");
        String result = HttpRequest.post(url).headerMap(header,true).body(JsonUtil.toJson(requestMap)).execute().body();
        if(StringUtils.isNotBlank(result)){
            Map<String,String> resultMap = JsonUtil.toObject(result,HashMap.class);
        }
    }

    private final int PORT = 8080;
    private ClientRequestFilter filter;

    public RestDemoInterface restOrderService() {
        return RESTProxyClientFactory.build(
                RestDemoInterface.class,
                PORT,
                "api/runtime/test/v1.0",
                filter);
    }

    public void getXXX1() {
        RestDemoInterface restDemoInterface = restOrderService();
        //restDemoInterface.updateOrderSate();
    }
}
