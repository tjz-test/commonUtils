package com.inspur.gs.commonutils.demo.transaction;

import io.iec.edp.caf.commons.transaction.JpaTransaction;
import io.iec.edp.caf.commons.transaction.TransactionPropagation;
import javax.transaction.Transactional;

/**
 * maven依赖
 * <dependency>
 *     <groupId>io.iec.edp</groupId>
 *     <artifactId>caf-boot-commons-transaction</artifactId>
 * </dependency>
 */
//@Transactional
public class TransationDemo {

    //代码调用
    public void save() {
        JpaTransaction tran = JpaTransaction.getTransaction();
        try {
            //此处支持更多选项
            //TransactionPropagation.MANDATORY 必须在一个已有的事务中执行,否则抛出异常
            //TransactionPropagation.NESTED 如果有活动事务，运行在潜逃的事务中，没有活动事务，则按Propagation.REQUIRED属性执行
            //TransactionPropagation.NEVER 必须在一个没有的事务中执行,否则抛出异常(与Propagation.MANDATORY相反)
            //TransactionPropagation.NOT_SUPPORTED 容器不为这个方法开启事务
            //TransactionPropagation.REQUIRES_NEW 不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务
            //TransactionPropagation.SUPPORTS 如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.
            //TransactionPropagation.REQUIRED 如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)
            tran.begin(TransactionPropagation.REQUIRED);
            //业务处理
            tran.commit();
        } catch (Throwable e) {
            tran.rollback();
            throw e;
        }
    }

    //注解使用
    //@Transactional
    /**
     * @Transactional(propagation=Propagation.REQUIRED) ：
     * 如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)
     *
     * @Transactional(propagation=Propagation.NOT_SUPPORTED) ：
     * 容器不为这个方法开启事务
     *
     * @Transactional(propagation=Propagation.REQUIRES_NEW) ：
     * 不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务
     *
     * @Transactional(propagation=Propagation.MANDATORY) ：
     * 必须在一个已有的事务中执行,否则抛出异常
     *
     * @Transactional(propagation=Propagation.NEVER) ：
     * 必须在一个没有的事务中执行,否则抛出异常(与Propagation.MANDATORY相反)
     *
     * @Transactional(propagation=Propagation.SUPPORTS) ：
     * 如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.
     *
     * @Transactional(propagation=Propagation.NESTED) ：
     * 如果有活动事务，运行在潜逃的事务中，没有活动事务，则按Propagation.REQUIRED属性执行
     */

    /**
     * @Transactional注解中常用参数说明
     * readOnly
     * 该属性用于设置当前事务是否为只读事务，设置为true表示只读，false则表示可读写，默认值为false。例如：@Transactional(readOnly=true)
     *
     * rollbackFor
     * 该属性用于设置需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，则进行事务回滚。例如： 指定单一异常类：@Transactional(rollbackFor=RuntimeException.class) 指定多个异常类：@Transactional(rollbackFor={RuntimeException.class,Exception.class})
     *
     * rollbackForClassName
     * 该属性用于设置需要进行回滚的异常类名称数组，当方法中抛出指定异常名称数组中的异常时，则进行事务回滚。例如： 指定单一异常类名称：@Transactional(rollbackForClassName="RuntimeException") 指定多个异常类名称：@Transactional(rollbackForClassName={"RuntimeException","Exception"})
     *
     * noRollbackFor
     * 该属性用于设置不需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，不进行事务回滚。例如： 指定单一异常类：@Transactional(noRollbackFor=RuntimeException.class) 指定多个异常类：@Transactional(noRollbackFor={RuntimeException.class,Exception.class})
     *
     * noRollbackForClassName
     * 该属性用于设置不需要进行回滚的异常类名称数组，当方法中抛出指定异常名称数组中的异常时，不进行事务回滚。例如： 指定单一异常类名称：@Transactional(noRollbackForClassName="RuntimeException") 指定多个异常类名称@Transactional(noRollbackForClassName={"RuntimeException","Exception"})
     *
     * propagation
     * 该属性用于设置事务的传播行为，具体取值可参考表6-7。 例如：@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
     *
     * isolation
     * 该属性用于设置底层数据库的事务隔离级别，事务隔离级别用于处理多事务并发的情况，通常使用数据库的默认隔离级别即可，基本不需要进行设置
     *
     * timeout
     * 该属性用于设置事务的超时秒数，默认值为-1表示永不超时
     */

    /**
     * 注意
     * 如果类或成员添加了@Transactional注解，该类必须注册为Bean，并且必须从容器中获取对象实例，原因是@Transactional注解底层使用的是动态代理来进行实现的。
     *
     * @Transactional 只能被应用到public方法上, 对于其它非public的方法,如果标记了@Transactional也不会报错,但方法没有事务功能.
     *
     * 用 spring 事务管理器,由spring来负责数据库的打开,提交,回滚.默认遇到运行期例外(throw new RuntimeException(“注释”);)会回滚，即遇到不受检查（unchecked）的例外时回滚；
     * 而遇到需要捕获的例外(throw new Exception(“注释”);)不会回滚,即遇到受检查的例外（就是非运行时抛出的异常，编译器会检查到的异常叫受检查例外或说受检查异常）时，需我们指定方式来让事务回滚要想所有异常都回滚,要加上
     * @Transactional( rollbackFor={Exception.class,其它异常}) .如果让unchecked例外不回滚： @Transactional(notRollbackFor=RunTimeException.class)
     *
     * @Transactional 注解可以被应用于接口定义和接口方法、类定义和类的 public 方法上。
     * 然而，请注意仅仅 @Transactional 注解的出现不足于开启事务行为，
     * 它仅仅 是一种元数据，能够被可以识别 @Transactional 注解和上述的配置适当的具有事务行为的beans所使用。
     *
     * 在调用类中使用this调用本类中的另外一个添加了@Transactional注解的方法，此时this调用的方法上的@Transactional注解是不起作用的。
     */
    public void save1() {
        //处理
    }
}
