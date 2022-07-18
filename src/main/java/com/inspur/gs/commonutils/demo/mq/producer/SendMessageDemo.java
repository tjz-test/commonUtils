package com.inspur.gs.commonutils.demo.mq.producer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生产者发送消息
 * @author tianjinzan01
 */
@Component
public class SendMessageDemo {

    //private final RabbitTemplate template;
    //
    //public SendMessageDemo(RabbitTemplate template) {
    //    this.template = template;
    //}
    //
    ////direct send
    //public String directSend(String routingKey){
    //    template.convertAndSend("directExchange",routingKey,"hello world");
    //    return "yes";
    //}
    //
    ////topic send
    //public String topicSend(String routingKey){
    //    template.convertAndSend("topicExchange",routingKey,"hello world");
    //    return "yes";
    //}
    //
    ////fanout send
    //public String fanoutSend(){
    //    template.convertAndSend("fanoutExchange",null,"hello world");
    //    return "yes";
    //}
    //
    ////延时队列
    //public void sendMsg(String msg) {
    //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //    System.out.println("消息发送时间：" + sdf.format(new Date()));
    //    template.convertAndSend("delayQueue", "FF", msg, message -> {
    //        //消息延迟5秒
    //        message.getMessageProperties().setHeader("x-delay", 5000);
    //        return message;
    //    });
    //}

}
