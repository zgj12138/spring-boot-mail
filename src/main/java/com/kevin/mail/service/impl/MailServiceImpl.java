package com.kevin.mail.service.impl;

import com.kevin.mail.entity.Email;
import com.kevin.mail.service.MailService;
import com.kevin.mail.utils.MailUtil;
import freemarker.template.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * @author ZGJ
 * @date 2017/8/25 0:01
 **/
@Service
public class MailServiceImpl implements MailService {

    private static Logger logger = LoggerFactory.getLogger(MailService.class);
    //执行者
    @Autowired
    private JavaMailSender mailSender;
    //freemarker
    @Autowired
    private Configuration configuration;
    //thymeleaf
    @Autowired
    private SpringTemplateEngine templateEngine;
    //发送者
    @Value("${spring.mail.username")
    private String username;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void send(Email mail) throws Exception {
        logger.info("发送邮件：{}",mail.getContent());
        MailUtil mailUtil = new MailUtil();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(mail.getEmail());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        mailUtil.start(mailSender, message);
    }

    @Override
    public void sendHtml(Email mail) throws Exception {

    }

    @Override
    public void sendFreemarker(Email mail) throws Exception {

    }

    @Override
    public void sendThymeleaf(Email mail) throws Exception {

    }

    @Override
    public void sendQueue(Email mail) throws Exception {

    }

    @Override
    public void sendRedisQueue(Email mail) throws Exception {

    }
}
