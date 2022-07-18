package com.inspur.gs.commonutils.demo.lambda;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * @author tianjinzan01
 * @date 2022/6/29
 * @describe
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserTestEntity {
    private String userarid;
    private String usercode;
    private String period;
    private String wmonth;

    public UserTestEntity() {}

    public UserTestEntity(String userarid, String usercode, String period, String wmonth) {
        this.userarid = userarid;
        this.usercode = usercode;
        this.period = period;
        this.wmonth = wmonth;
    }

    /**
     * 重写一下 equals 方法
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTestEntity userTestEntity = (UserTestEntity) o;
        return Objects.equals(userarid, userTestEntity.userarid) && Objects.equals(usercode, userTestEntity.usercode) && Objects.equals(period, userTestEntity.period) && Objects.equals(wmonth, userTestEntity.wmonth);
    }

    /**
     * 重写一下 hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(userarid, usercode, period, wmonth);
    }

}