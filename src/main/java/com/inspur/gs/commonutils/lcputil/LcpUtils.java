package com.inspur.gs.commonutils.lcputil;


import com.inspur.edp.bef.api.lcp.ILcpFactory;
import com.inspur.edp.bef.api.lcp.IStandardLcp;
import com.inspur.edp.bef.api.lcp.LcpFactoryManagerUtils;
import com.inspur.edp.bef.api.parameter.retrieve.RetrieveParam;
import com.inspur.edp.cef.entity.changeset.ValueObjModifyChangeDetail;
import com.inspur.edp.cef.entity.condition.EntityFilter;
import com.inspur.edp.cef.entity.entity.IEntityData;
import java.util.List;

/**
 * @author tianjinzan01
 */
public class LcpUtils {

    private static final ILcpFactory lcpFactory = LcpFactoryManagerUtils.getBefLcpFactory();

    public static EntityFilterBuilder getEfBuilder () {
        return new EntityFilterBuilder();
    }

    public static FilterBuilder getFilterBuilder() {
        return new FilterBuilder();
    }

    public static SortBuilder getSortBuilder() {
        return new SortBuilder();
    }

    public static IStandardLcp getLcp(String nodeUri) {
        IStandardLcp lcp = lcpFactory.createLcp(nodeUri);
        if (lcp == null) {
            throw new RuntimeException("创建节点"+ nodeUri + " lcp失败");
        }
        return lcp;
    }

    public static List<IEntityData> getQueryResult(String nodeUri, EntityFilter entityFilter) {
        return getLcp(nodeUri).query(entityFilter);
    }

    public static void setBEParam(IStandardLcp lcp, String variableName, Object value) {
        ValueObjModifyChangeDetail changeDetail = new ValueObjModifyChangeDetail();
        changeDetail.getPropertyChanges().put(variableName, value);
        lcp.modifyVariable(changeDetail);
    }

    public static <T> T retrieve(String configId, String id) {
        RetrieveParam retriveParam = new RetrieveParam();
        retriveParam.setNeedLock(false);
        return (T)getLcp(configId).retrieve(id, retriveParam).getData();
    }
}
