package com.inspur.gs.commonutils.demo.mq.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 消费者处理
 * @author tianjinzan01
 */

@Component
@SuppressWarnings("all")
@Slf4j
public class ReceiveMessageDemo {

    AtomicInteger count = new AtomicInteger();

    ////region 消息队列已经明确，并且存在
    //
    ////死信队列数据处理
    //@RabbitListener(queues = "deadQueue")
    //public void process2(String message){
    //    log.info("deadQueue接到"+message);
    //}
    //
    //@RabbitListener(queues = "directQueueD")
    //public void process1(String message){
    //    log.info("D接到"+message);
    //}
    //
    ////endregion
    //
    ////region 消息队列不存在时,创建
    ///**
    // * 队列不存在时，需要创建一个队列，并且与exchange绑定
    // * @QueueBinding注解的三个属性：
    // * value: @Queue 注解，用于声明队列，value 为 queueName, durable 表示队列是否持久化, autoDelete 表示没有消费者之后队列是否自动删除
    // * exchange: @Exchange 注解，用于声明 exchange， type 指定消息投递策略，我们这里用的 topic 方式
    // * key: 在 topic 方式下，这个就是我们熟知的 routingKey
    // */
    //@RabbitListener(bindings = @QueueBinding(
    //        value = @Queue(value = "topic.n1", durable = "false", autoDelete = "true"),
    //        exchange = @Exchange(value = "topic.e", type = ExchangeTypes.TOPIC),
    //        key = "r"))
    //public void consumerNoQueue(String data) {
    //    System.out.println("consumerNoQueue: " + data);
    //}
    ////endregion
    //
    ////region 消费者 使用用ack 手动 MANUAL
    //
    ///**
    // * 消费者
    // *
    // * 没有及时ack，或者程序出现bug，所有的消息将被存在unacked中，消耗内存
    // * 如果忘记了ack，那么后果很严重。当Consumer退出时，Message会重新分发。
    // * 然后RabbitMQ会占用越来越多的内存，由于 RabbitMQ会长时间运行，因此这个“内存泄漏”是致命的。
    // *
    // * 如果使用BasicNack，将消费失败的消息重新塞进队列的头部，则会造成死循环。
    // * （解决basicNack造成的消息循环循环消费的办法是为队列设置“回退队列”，设置回退队列和阀值，如设置队列为q1，阀值为2，则在rollback两次后将消息转入q1）
    // *
    // * 对同一消息的重复确认，或者对不存在的消息的确认，会产生 IO 异常，导致信道关闭。
    // *
    // * ack模式
    // * NONE：无应答，rabbitmq默认consumer正确处理所有请求。
    // *
    // * AUTO：consumer自动应答，处理成功（注意：此处的成功确认是没有发生异常）发出ack，处理失败发出nack。rabbitmq发出消息后会等待consumer端应答，只有收到ack确定信息后才会将消息在rabbitmq清除掉。
    // * 收到nack异常信息的处理方法由setDefaultRequeueReject()方法设置，这种模式下，发送错误的消息可以恢复。
    // *
    // * MANUAL：基本等同于AUTO模式，区别是需要人为调用方法确认。
    // *
    // * @param data 信息
    // * @param deliveryTag 唯一标识 ID
    // * @param channel
    // * @throws IOException
    // */
    //
    //@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "directQueueD", durable = "false", autoDelete = "true"),
    //        exchange = @Exchange(value = "directExchange", type = ExchangeTypes.DIRECT), key = "DD"), ackMode = "MANUAL")
    //public void consumerDoAck(String data, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
    //
    //    //注意 采用手动方式ack 时，在捕获异常抛出前 要进行 ack确认
    //    try {
    //
    //        count.incrementAndGet();
    //
    //        if (data.contains("success")) {
    //            /**
    //             * 确认消息，参数说明：
    //             * long deliveryTag：唯一标识 ID。
    //             * boolean multiple：是否批处理，当该参数为 true 时，
    //             * 则可以一次性确认 deliveryTag 小于等于传入值的所有消息。
    //             */
    //            channel.basicAck(deliveryTag, false);
    //        } else {
    //            /**
    //             * 否定消息，参数说明：
    //             * long deliveryTag：唯一标识 ID。
    //             * boolean multiple：是否批处理，当该参数为 true 时，则可以一次性确认 deliveryTag 小于等于传入值的所有消息。
    //             * boolean requeue：如果 requeue 参数设置为 true，则 RabbitMQ 会重新将这条消息存入队列，以便发送给下一个订阅的消费者；
    //             * 如果 requeue 参数设置为 false，则 RabbitMQ 立即会还把消息从队列中移除，
    //             * 而不会把它发送给新的消费者。
    //             */
    //            channel.basicNack(deliveryTag, false, false);
    //        }
    //    } catch (Exception e) {
    //        /**
    //         * 拒绝消息，参数说明：
    //         * long deliveryTag：唯一标识 ID。
    //         * boolean requeue：如果 requeue 参数设置为 true，
    //         * 则 RabbitMQ 会重新将这条消息存入队列，以便发送给下一个订阅的消费者；
    //         * 如果 requeue 参数设置为 false，则 RabbitMQ 立即会还把消息从队列中移除，
    //         * 而不会把它发送给新的消费者。
    //         */
    //        if (count.get() < 6) {
    //            channel.basicReject(deliveryTag, true);
    //        } else {
    //            throw new RuntimeException(e);
    //        }
    //    }
    //}
    ////endregion
    //
    ////region 并发消费
    ///**
    // * 请注意注解中的concurrency = "4"属性，表示固定 4 个消费者；
    // * 除了上面这种赋值方式之外，还有一种 m-n 的格式，表示 m 个并行消费者，最多可以有 n 个
    // */
    //@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "topic.n4", durable = "false", autoDelete = "true"),
    //        exchange = @Exchange(value = "topic.e", type = ExchangeTypes.TOPIC), key = "r"), concurrency = "4")
    //public void multiConsumer(String data) {
    //    System.out.println("multiConsumer: " + data);
    //}
    ////endregion
    //
    ////region 延时队列
    ///**
    // 利用 rabbitmq_delayed_message_exchange 插件 实现延迟队列
    // */
    //@RabbitListener(queues = "delayQueue")//监听延时队列
    //public void delayConsumer(String msg){
    //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //    System.out.println("【插件延迟队列】【" + sdf.format(new Date()) + "】收到消息：" + msg);
    //}
    ////endregion
    //
    ////region 重试机制
    ///**
    // * 不适合重试：代码bug问题，并且有写操作，这个时候需要考虑到幂等。后台服务应该通过日志，后期通过定时器来补偿，或者手动补偿。
    // *
    // * 适合重试：大部分属于读取，如调用第三方接口、网络波动问题、暂时调用不了、网络连接等。
    // *
    // * 可以使用RabbitMQ的ack确认机制。开启重试，然后重试次数，默认为3次。这里设置为5次
    // *
    // * spring.rabbitmq.listener.simple.retry.max-attempts=5  最大重试次数
    // * spring.rabbitmq.listener.simple.retry.enabled=true 是否开启消费者重试（为false时关闭消费者重试，这时消费端代码异常会一直重复收到消息）
    // * spring.rabbitmq.listener.simple.retry.initial-interval=5000 重试间隔时间（单位毫秒）
    // * spring.rabbitmq.listener.simple.default-requeue-rejected=false 重试次数超过上面的设置之后是否丢弃（false不丢弃时需要写相应代码将该消息加入死信队列）
    // *
    // * 达到重试次数后进入死信队列处理
    // */
    ////endregion
}
