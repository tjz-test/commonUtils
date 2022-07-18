package com.inspur.gs.commonutils.demo.data.common;

import com.inspur.edp.caf.db.dbaccess.DynamicResultRow;
import com.inspur.edp.caf.db.dbaccess.IDbParameter;
import com.inspur.edp.qdp.bql.api.IBqlExecuter;
import com.inspur.edp.qdp.bql.api.OptionType;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;
import io.iec.edp.caf.runtime.config.BqlBeanUtil;
import java.util.List;

/**
 * igix封装方法
 */
public class IgixSqlDemo {

    /**
     * bql执行器
     */
    private IBqlExecuter bqlExecuter;

    public IgixSqlDemo() {
        this.bqlExecuter = SpringBeanUtils.getBean(IBqlExecuter.class);
    }

    /**
     * 查询sql
     * @param id
     * @return
     */
    public List<DynamicResultRow> selectDemo(String id) {
        //切换sql
        bqlExecuter.getOptions().setOptionType(OptionType.ExecuteSql);
        String sql = "select '1' as code from xxx where id = :id";
        IDbParameter[] params = new IDbParameter[] {bqlExecuter.makeInParam("id", id)};
        List<DynamicResultRow> list = bqlExecuter.executeSelectStatement(sql,params);
        //使用方法
        /*for (DynamicResultRow dr : list) {
            String code = dr.get("code").toString();
        }*/
        return list;
    }

    /**
     * 修改、删除、插入
     * @param id
     */
    public void dealDemo(String id) {
        //切换sql
        bqlExecuter.getOptions().setOptionType(OptionType.ExecuteSql);
        String sqlDelete = "delete from xxx where id = :id";
        String sqlUpdate = "update xxx set a = '' where id = :id";
        String sqlIns = "insert into xxx (id,name) value (:id)";
        IDbParameter[] params = new IDbParameter[] {bqlExecuter.makeInParam("id", id)};
        //可根据返回处理条数判断处理情况
        int countDel = bqlExecuter.executeBqlStatement(sqlDelete,params);
        int countUpdate = bqlExecuter.executeBqlStatement(sqlUpdate,params);
        int countIns = bqlExecuter.executeBqlStatement(sqlUpdate,params);
    }

    /**
     * 查询单值
     */
    public Object executeScalar() {
        //切换sql
        bqlExecuter.getOptions().setOptionType(OptionType.ExecuteSql);
        String sql = "select count(1) from xxx";
        List<DynamicResultRow> list = bqlExecuter.executeSelectStatement(sql);
        Object rtn = null;
        if (list != null && list.size() > 0) {
            rtn = list.get(0).get(0);
        }
        return rtn;
    }
}
