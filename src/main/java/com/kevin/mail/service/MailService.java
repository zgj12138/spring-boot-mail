package com.kevin.mail.service;

import com.kevin.mail.entity.Email;

/**
 * @author ZGJ
 * @date 2017/8/24 23:56
 **/
public interface MailService {

    /**
     * 纯文本
     * @param mail
     * @throws Exception
     */
    void send(Email mail) throws Exception;

    /**
     * 富文本
     * @param mail
     * @throws Exception
     */
    void sendHtml(Email mail) throws Exception;

    /**
     * 模板发送 freemarker
     * @param mail
     * @throws Exception
     */
    void sendFreemarker(Email mail) throws Exception;

    /**
     * 模板发送 thymeleaf
     * @param mail
     * @throws Exception
     */
    void sendThymeleaf(Email mail) throws Exception;

    /**
     * 队列
     * @param mail
     * @throws Exception
     */
    void sendQueue(Email mail) throws Exception;

    /**
     * Redis队列
     * @param mail
     * @throws Exception
     */
    void sendRedisQueue(Email mail) throws Exception;
}
