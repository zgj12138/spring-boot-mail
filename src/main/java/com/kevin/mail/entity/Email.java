package com.kevin.mail.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * Email实体
 * @author ZGJ
 * @date 2017/8/24 23:19
 **/
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    //必填参数
    /**
     * 接收方邮件
     */
    private String[] email;
    /**
     * 主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
    //选填
    /**
     * 模板
     */
    private String template;
    /**
     * 自定义参数
     */
    private Map<String, String> kvMap;

    public Email() {
    }

    public Email(String[] email, String subject, String content, String template, Map<String, String> kvMap) {
        this.email = email;
        this.subject = subject;
        this.content = content;
        this.template = template;
        this.kvMap = kvMap;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, String> getKvMap() {
        return kvMap;
    }

    public void setKvMap(Map<String, String> kvMap) {
        this.kvMap = kvMap;
    }
}
