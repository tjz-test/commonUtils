package com.inspur.gs.commonutils.demo.data.em;

import io.iec.caf.data.jpa.repository.CafEntityManagerWrapper;
import io.iec.edp.caf.commons.transaction.JpaTransaction;
import io.iec.edp.caf.commons.transaction.TransactionPropagation;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;

import javax.persistence.*;
import java.sql.PreparedStatement;
import java.util.Optional;

public class demo {

    /**
     * EntityManager注入
     */
    private static EntityManager entityManager;

    private static EntityManager getEntityManager() {
        if (!Optional.ofNullable(entityManager).isPresent()) {
            entityManager = SpringBeanUtils.getBean(EntityManager.class);
        }
        return entityManager;
    }

    /**
     * 批量处理demo
     * @throws Exception
     */
    public void insertOrderUserar(String ordercode, String arIds) throws Exception {
        entityManager = getEntityManager();
        PreparedStatement insertps = null;
        CafEntityManagerWrapper wrapper = null;
        JpaTransaction transaction =  JpaTransaction.getTransaction();
        try {
            transaction.begin(TransactionPropagation.REQUIRED);
            wrapper = new CafEntityManagerWrapper(entityManager);
            String insertOrderUserar = "insert into GSXMMSORDERUSERAR(ORDERCODE,USERARID) values(?,?) ";
            insertps = wrapper.prepareStatement(insertOrderUserar);
            String[] userarIds = arIds.split(",");
            for (String userarId : userarIds) {
                insertps.setString(1, ordercode);
                insertps.setString(2, userarId);
                insertps.addBatch();
            }
            insertps.executeBatch();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (insertps != null) {
                insertps.close();
            }
            if (wrapper != null) {
                wrapper.close();
            }
        }
    }

    public void updateKpState(String id, String invoice) {
        try {
            entityManager = getEntityManager();
            String sqlUserarN = "UPDATE GSXMMSUSERARN SET INVOICE = ?  WHERE ID = ? AND INVOICE = '1' ";
            Query queryuserarN = entityManager.createNativeQuery(sqlUserarN);
            queryuserarN.setParameter(1, invoice);
            queryuserarN.setParameter(2, id);
            int result = queryuserarN.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 存储过程调用
     */
    public void useProc() {
        entityManager = getEntityManager();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GSXM_DEAL_USERARCHECK_BANK");
        query.registerStoredProcedureParameter("P_BILLID", String.class, ParameterMode.IN);
        query.setParameter("P_BILLID", "");
        query.registerStoredProcedureParameter("P_CHECKSTATE", String.class, ParameterMode.IN);
        query.setParameter("P_CHECKSTATE", "");
        query.registerStoredProcedureParameter("P_CPCHANNEL", String.class, ParameterMode.IN);
        query.setParameter("P_CPCHANNEL", "");
        query.execute();
    }
}
