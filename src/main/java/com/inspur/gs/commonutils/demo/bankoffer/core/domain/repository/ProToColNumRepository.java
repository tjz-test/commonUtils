package com.inspur.gs.commonutils.demo.bankoffer.core.domain.repository;

import com.inspur.gs.commonutils.demo.bankoffer.core.domain.entity.ProToColNumInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tjz
 * @date 2022/7/15
 * @description 协议号存储库
 */
public interface ProToColNumRepository extends JpaRepository<ProToColNumInfo, String> {
}
