package com.oshop.mq.subscribe.fanout;

import com.oshop.mq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 生产者
 * 1） 声明Exchange，不再声明Queue
 * 2） 发送消息到Exchange，不再发送到Queue
 *
 * @author wyw
 * @date 2020/05/26
 */
public class Send {
    private final static String EXCHANGE_NAME = "fanout_exchange_test";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为fanout
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        String message = "test fanout";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println(" [生产者] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
