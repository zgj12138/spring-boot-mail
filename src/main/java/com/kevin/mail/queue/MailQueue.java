package com.kevin.mail.queue;

import com.kevin.mail.entity.Email;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 邮件队列
 * @author ZGJ
 * @date 2017/8/24 23:43
 **/
public class MailQueue {
    //队列大小
    private static final int QUE_MAX_SIZE = 1000;
    //邮件队列，阻塞队列
    private BlockingQueue<Email> blockingQueue = new LinkedBlockingDeque<>(QUE_MAX_SIZE);

    /**
     * 私有构造函数
     */
    private MailQueue() {

    }
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private  static MailQueue queue = new MailQueue();
    }
    /**
     * 单例队列
     */
    public static MailQueue getMailQueue() {
        return SingletonHolder.queue;
    }

    /**
     * 生产入队
     * @param email
     * @throws InterruptedException
     */
    public void produce(Email email) throws InterruptedException {
        blockingQueue.put(email);
    }
    /**
     * 消费出队
     */
    public Email consume() throws InterruptedException {
        return blockingQueue.take();
    }
    /**
     * 获取队列大小
     */
    public int size() {
        return blockingQueue.size();
    }
}
