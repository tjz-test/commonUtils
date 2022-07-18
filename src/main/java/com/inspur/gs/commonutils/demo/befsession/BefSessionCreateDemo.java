package com.inspur.gs.commonutils.demo.befsession;

import com.inspur.edp.bef.api.lcp.ILcpFactory;
import com.inspur.edp.bef.api.lcp.IStandardLcp;
import com.inspur.edp.bef.api.services.IBefSessionManager;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;
import java.time.Duration;

/**
 * befsession创建demo
 *
 * 使用Farris开发的前端使用Bff和Bef开发后端时，系统可以自动处理，通常无需开发人员关注Session的创建和关闭。
 *
 * java原生编码的功能调用Bef接口时，一般需要先创建Session，否则可能会引发异常编号为GSP_ADP_BEF_2010的
 * com.inspur.edp.bef.api.exceptions.BefEngineException异常。
 *
 * 但是有时候会发现未创建session也可以正常调用Bef接口，这通常是因为你的调用方已经创建了session，例如：
 *      通过内部服务调用进来，内部服务会自动创建session；
 *      前端请求调用进来，前端使用Farris开发自动创建了Session；
 *
 * maven依赖
 * <dependency>
 *     <groupId>com.inspur.edp</groupId>
 *     <artifactId>bef-api</artifactId>
 * </dependency>
 */
public class BefSessionCreateDemo {

    public void demo() {
        SpringBeanUtils.getBean(IBefSessionManager.class).createSession(Duration.ofSeconds(5));
        try {
            IStandardLcp lcp = SpringBeanUtils.getBean(ILcpFactory.class).createLcp("xxx");
            lcp.retrieve("xxx");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            SpringBeanUtils.getBean(IBefSessionManager.class).closeCurrentSession();
        }
    }
}
