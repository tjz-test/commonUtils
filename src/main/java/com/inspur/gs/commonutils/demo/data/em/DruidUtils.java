package com.inspur.gs.commonutils.demo.data.em;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author tianjinzan01
 * @date 2022/7/8
 * @describe
 */
public class DruidUtils {

    private static DruidDataSource dataSource;

    /**
     * 线程变量集合 使事务只是使用一个connection  可以事务管理
     */
    private static final ThreadLocal<Connection> THREAD_LOCAL;

    static {
        THREAD_LOCAL = new ThreadLocal<>();

        //读取配置文件
        Properties properties=new Properties();
        InputStream inputStream=DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");

        //加载集合
        try {
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接获取
     */
    public static Connection getConnection() throws SQLException {
        //判断线程中是否存在
        Connection connection = THREAD_LOCAL.get();
        if (connection == null) {
            connection = dataSource.getConnection();
            THREAD_LOCAL.set(connection);
        }
        return connection;
    }

    /**
     * 开启事务
     */
    public static void beginTranscation() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }

    /**
     * 提交事务
     */
    public static void commitTranscation() throws SQLException {
        Connection connection = getConnection();
        connection.commit();
    }

    /**
     * 回滚事务
     */
    public static void rollbackTranscation() throws SQLException{
        Connection connection = getConnection();
        connection.rollback();
    }

    /**
     * 关闭连接
     */
    public static void close() throws SQLException {
        Connection connection = getConnection();
        connection.close();
        THREAD_LOCAL.remove();
    }

    /**
     * 获取数据源
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 关闭所有数据库相关操作
     */
    public static void closeAll(ResultSet rs, Statement stat, Connection connection) throws SQLException{
        if (rs != null) {
            rs.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (stat != null) {
            stat.close();
        }
        THREAD_LOCAL.remove();
    }
}
