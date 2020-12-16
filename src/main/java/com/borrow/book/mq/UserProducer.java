package com.borrow.book.mq;


import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class UserProducer {

   /* *//**
     * 生产者的组名
     *//*
    private String producerGroup="user-group";
    *//**
     * NameServer 地址
     *//*
    private String namesrvAddr="127.0.0.1:9876";

    @PostConstruct
    public void produder() {
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        try {
            producer.start();
            for (int i = 0; i < 5; i++) {
               String jsonstr= "{\"2\":\"mqtest-keys\"}";
                System.out.println("发送消息:"+jsonstr);
                Message message = new Message("user-topic", "user-tag","test-key",jsonstr.getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult result = producer.send(message);
                System.err.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
*/
}
