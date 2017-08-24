package com.kevin.mail.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 异步发送邮件工具类
 * @author ZGJ
 * @date 2017/8/24 23:32
 **/
public class MailUtil {
    private static Logger logger = LoggerFactory.getLogger(MailUtil.class);

    private ScheduledExecutorService service = Executors.newScheduledThreadPool(6);

    private final AtomicInteger count = new AtomicInteger(1);

    public void start(final JavaMailSender mailSender, final SimpleMailMessage mailMessage) {
        service.execute(() -> {
            try {
                if(count.get() == 2) {
                    service.shutdown();
                    logger.info("任务已经关闭");
                }
                logger.info("开始发送邮件，这是第 " + count + "封");
                mailSender.send(mailMessage);
                logger.info("发送邮件成功");
            } catch (Exception e) {
                logger.error("发送邮件失败");
            }
        });
    }
    public void startHtml(final JavaMailSender mailSender, final MimeMessage message) {
        service.execute(() -> {
            try {
                if(count.get() == 2) {
                    service.shutdown();
                    logger.info("任务已经关闭");
                }
                logger.info("开始发送邮件，这是第 " + count + "封");
                mailSender.send(message);
                logger.info("发送邮件成功");
            } catch (Exception e) {
                logger.error("发送邮件失败");
            }
        });
    }
}
