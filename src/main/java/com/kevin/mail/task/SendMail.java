package com.kevin.mail.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 统计失败邮件定时重新发送
 * @author ZGJ
 * @date 2017/8/24 23:54
 **/
@Component
public class SendMail {
    @Scheduled(cron = "0/5 * * * * ?")
    public void sendMail() {
        System.out.println("同步开始");
    }
}
