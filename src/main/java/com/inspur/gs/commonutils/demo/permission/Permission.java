package com.inspur.gs.commonutils.demo.permission;

/**
 * @author tianjinzan01
 * @date 2022/7/8
 * @describe
 */

import io.iec.edp.caf.commons.utils.SpringBeanUtils;
import io.iec.edp.caf.permission.api.manager.runtime.PermissionManager;

/**
 * <dependency>
 *     <groupId>io.iec.edp</groupId>
 *     <artifactId>caf-runtime-framework-permission-api</artifactId>
 *     <version>0.1.8</version>
 * </dependency>
 */
public class Permission {

    public Boolean checkPermission() {
        PermissionManager permissionManager= SpringBeanUtils.getBean(PermissionManager.class);
        return permissionManager.isPrincipalHasOp("e7576714-78ac-b0a9-344d-ea48777914e5");
    }

}
