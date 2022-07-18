package com.inspur.gs.commonutils.demo.bankoffer.core.config;

import com.inspur.gs.commonutils.demo.bankoffer.api.webservice.SnapProxyWebservice;
import com.inspur.gs.commonutils.demo.bankoffer.api.webservice.SnapWebservice;
import com.inspur.gs.commonutils.demo.bankoffer.core.domain.manager.ProToColNumManager;
import com.inspur.gs.commonutils.demo.bankoffer.core.domain.repository.ProToColNumRepository;
import com.inspur.gs.commonutils.demo.bankoffer.core.service.DataService;
import com.inspur.gs.commonutils.demo.bankoffer.core.service.impl.DataServiceImpl;
import com.inspur.gs.commonutils.demo.bankoffer.core.webservice.SnapProxyWebserviceImpl;
import com.inspur.gs.commonutils.demo.bankoffer.core.webservice.SnapWebserviceImpl;
import io.iec.edp.caf.rest.RESTEndpoint;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author tjz
 * @date 2022/7/15
 * @description 批扣配置中心
 */
@Configuration("gsxmciSnapConfiguration")
@EnableJpaRepositories("com.inspur.gs.commonutils.demo.bankoffer.core.domain.repository")
@EntityScan({"com.inspur.gs.commonutils.demo.bankoffer.core.domain.entity", "com.inspur.gs.commonutils.demo.bankoffer.api.entity"})
public class SnapConfiguration {

    /**
     * manager托管
     */
    @Bean("gsxmciProToColNumberManager")
    public ProToColNumManager proToColNumManager(ProToColNumRepository proToColNumRepository) {
        return new ProToColNumManager(proToColNumRepository);
    }

    /**
     * 数据服务托管
     */
    @Bean("gsxmciSnapDataService")
    public DataService dataService(ProToColNumManager proToColNumManager) {
        return new DataServiceImpl(proToColNumManager);
    }

    /**
     * 托管SnapWebservice
     */
    @Bean("gsxmciSnapWebservice")
    public SnapWebservice getSnapWebservice() {
        return new SnapWebserviceImpl();
    }

    /**
     * restful服务注册
     */
    @Bean("gsxmciSnapWebserviceEndPoint")
    public RESTEndpoint snapWebserviceEndPoint(SnapWebservice snapWebservice) {
        return new RESTEndpoint("/gsxmci/gsxmcipay/v1.0/snap", snapWebservice);
    }

    /**
     * rpc服务注册
     */
    @Bean("gsxmciSnapProxyWebservice")
    public SnapProxyWebservice snapProxyWebservice() {
        return new SnapProxyWebserviceImpl();
    }

}
