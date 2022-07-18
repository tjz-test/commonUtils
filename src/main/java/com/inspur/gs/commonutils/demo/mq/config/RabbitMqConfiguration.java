package com.inspur.gs.commonutils.demo.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建交换机、队列
 * @author tianjinzan01
 */
@Configuration
public class RabbitMqConfiguration {

    /**
     * rabbitmq不允许对一个已存在的队列重新定义参数信息。
     *
     * 死信
     * 1.消息被拒绝，并且设置为requeue参数为false
     *
     * 2.消息过期（默认情况下Rabbit中的消息不过期，但是可以设置队列的过期时间和消息的过期时间以上达到消息过期的效果）
     *
     * 3.队列达到最大长度（一般当设置了最大队列长度或大小并达到最大值时）
     *
     * 存在以上三种情况时间，消息为死信消息，可转移到死信交换机，分配死信队列
     */

    ////region 1、direct模式
    //
    ////设置队列消息过期时间
    //@Bean
    //public Queue directQueueD() {
    //    Map<String, Object> config = new HashMap<>();
    //    //过期时间(message在该队列queue的存活时间最大为100秒)
    //    config.put("x-message-ttl", 100000);
    //    //死信交换机(x-dead-letter-exchange参数是设置该队列的死信交换器（DLX）)
    //    config.put("x-dead-letter-exchange", "deadExchange");
    //    //死信routing key(x-dead-letter-routing-key参数是给这个DLX指定路由键)
    //    config.put("x-dead-letter-routing-key", "EE");
    //
    //    /*queue：声明队列的名称
    //    name：队列名
    //    durable：如果我们声明一个持久队列，则为true（该队列将在服务器重启后保留下来）
    //    exclusive：如果我们声明一个独占队列，则为true（仅限此连接）
    //    autoDelete：如果我们声明一个自动删除队列（服务器将在不再使用它时将其删除）
    //    arguments：队列的其他属性（构造参数）
    //
    //    arguments:
    //    1、x-expires设定队列有效期。表示队列在指定时间内未使用，则会删除。
    //    2、x-message-ttl设定消息延迟发送时间。
    //    3、x-dead-letter-exchange设置死信交换机。
    //    4、x-dead-letter-routing-key设置路由。
    //    */
    //
    //    return new Queue("directQueueD", false, false, false, config);
    //}
    //
    ////死信队列
    //@Bean
    //public Queue deadQueue(){
    //    return new Queue("deadQueue",true);
    //}
    //
    ////延时队列
    //@Bean
    //public Queue delayQueue(){
    //    return new Queue("delayQueue");
    //}
    //
    ////创建交换机
    //@Bean
    //public DirectExchange directExchange(){
    //    return new DirectExchange("directExchange");
    //}
    //
    ////死信交换机
    //@Bean
    //public DirectExchange deadExchange(){
    //    return new DirectExchange("deadExchange");
    //}
    //
    ////延时交换机
    //@Bean
    //public CustomExchange delayExchange(){
    //    Map<String, Object> argMap = new HashMap<>(16);
    //    //必须要配置这个类型，可以是direct,topic和fanout
    //    argMap.put("x-delayed-type", "direct");
    //    //第二个参数必须为x-delayed-message
    //    return new CustomExchange("delayExchange","x-delayed-message",false, false, argMap);
    //}
    //
    ////进行交换机和队列的绑定：设置bindingkey
    //@Bean
    //public Binding bingingD(){
    //    return BindingBuilder.bind(directQueueD()).to(directExchange()).with("DD");
    //}
    //
    ////死信绑定
    //@Bean
    //public Binding deadBinding(){
    //    return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("EE");
    //}
    //
    ////延时交换机、队列绑定
    //@Bean
    //public Binding delayBinding(){
    //    return BindingBuilder.bind(delayQueue()).to(delayExchange()).with("FF").noargs();
    //}
    //
    ////endregion
    //
    ////region 2、topic模式
    ////key
    //public final static String KEY_A="*.orange.*";
    //public final static String KEY_B="*.*.rabbit";
    //public final static String KEY_C="lazy.#";
    //
    //
    ////queue
    //@Bean
    //public Queue topicQueueA(){
    //    return new Queue("topicQueueA",true);
    //}
    //@Bean
    //public Queue topicQueueB(){
    //    return new Queue("topicQueueB",true);
    //}
    //@Bean
    //public Queue topicQueueC(){
    //    return new Queue("topicQueueC",true);
    //}
    //
    ////exchange
    //@Bean
    //public TopicExchange topicExchange(){
    //    return new TopicExchange("topicExchange");
    //}
    //
    ////bind
    //@Bean
    //public Binding topicBingingA(){
    //    return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with(KEY_A);
    //}
    //@Bean
    //public Binding topicBingingB(){
    //    return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with(KEY_B);
    //}
    //@Bean
    //public Binding topicBingingC(){
    //    return BindingBuilder.bind(topicQueueC()).to(topicExchange()).with(KEY_C);
    //}
    ////endregion
    //
    ////region 3、fanout模式
    ////create queue
    //@Bean
    //public Queue fanoutQueueA(){
    //    return new Queue("fanoutQueueA",true);
    //}
    //@Bean
    //public Queue fanoutQueueB(){
    //    return new Queue("fanoutQueueB",true);
    //}
    //@Bean
    //public Queue fanoutQueueC(){
    //    return new Queue("fanoutQueueC",true);
    //}
    //
    //// create exchange
    //@Bean
    //public FanoutExchange fanoutExchange(){
    //    return new FanoutExchange("fanoutExchange");
    //}
    //
    //// bind(类似广播，不需要key)
    //@Bean
    //public Binding fanoutBingingA(){
    //    return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    //}
    //@Bean
    //public Binding fanoutBingingB(){
    //    return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    //}
    //@Bean
    //public Binding fanoutBingingC(){
    //    return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
    //}
    ////endregion
}
