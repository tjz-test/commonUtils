package com.inspur.gs.commonutils.demo.bankoffer.api.webservice;

import com.inspur.gs.commonutils.demo.bankoffer.api.entity.ProcotolNumInfo;
import com.inspur.gs.commonutils.demo.bankoffer.core.result.Result;
import io.iec.edp.caf.rpc.api.annotation.GspServiceBundle;
import io.iec.edp.caf.rpc.api.annotation.RpcParam;
import io.iec.edp.caf.rpc.api.annotation.RpcServiceMethod;

/**
 * @author tjz
 * @date 2022/7/15
 * @description 批扣rpc
 */
@GspServiceBundle (applicationName = "GSXMCI", serviceUnitName = "GSXMCIPAY", serviceName = "gsxmci_gsxmcipay_demo")
public interface SnapProxyWebservice {
    /**
     * 生成协议号
     */
    @RpcServiceMethod (serviceId = "com.inspur.gs.commonutils.demo.bankoffer.api.webservice.generateNum")
    public Result generateNum(@RpcParam (paramName = "procotolNumInfo")ProcotolNumInfo procotolNumInfo);

    /**
     * 更新协议号
     */
    @RpcServiceMethod (serviceId = "com.inspur.gs.commonutils.demo.bankoffer.api.webservice.updateProtocolNum")
    public Result updateProtocolNum(@RpcParam (paramName = "procotolNumInfo")ProcotolNumInfo procotolNumInfo);

    /**
     * 出盘
     */
    @RpcServiceMethod(serviceId = "com.inspur.gs.commonutils.demo.bankoffer.api.webservice.outBount")
    public void outBount();

    /**
     * 回盘
     */
    @RpcServiceMethod(serviceId = "com.inspur.gs.commonutils.demo.bankoffer.api.webservice.rewind")
    public void rewind();
}
