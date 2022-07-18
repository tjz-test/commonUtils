package com.inspur.gs.commonutils.demo.bankoffer.api.webservice;

import com.inspur.gs.commonutils.demo.bankoffer.api.entity.ProcotolNumInfo;
import com.inspur.gs.commonutils.demo.bankoffer.core.result.Result;
import com.inspur.gs.commonutils.demo.data.ddd.api.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author tjz
 * @date 2022/7/15
 * @description 批扣webapi
 */
@Path ("/")
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public interface SnapWebservice {

    /**
     * 生成协议号
     */
    @POST
    @Path("/generate")
    public Result generateNum(ProcotolNumInfo procotolNumInfo);

    /**
     * 更新协议号
     */
    @POST
    @Path("/generate")
    public Result updateProtocolNum(ProcotolNumInfo procotolNumInfo);

    /**
     * 出盘
     */
    @POST
    @Path("/outbound")
    public void outBount();

    /**
     * 回盘
     */
    @POST
    @Path("/rewind")
    public void rewind();

}
