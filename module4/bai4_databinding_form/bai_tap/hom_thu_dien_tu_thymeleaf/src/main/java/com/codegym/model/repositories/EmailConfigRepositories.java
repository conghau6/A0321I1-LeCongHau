package com.codegym.model.repositories;

import com.codegym.model.bean.EmailConfig;

public class EmailConfigRepositories {
    private EmailConfig emailConfig = new EmailConfig("Vietnamese",25,true,"thor");

    public EmailConfigRepositories() {
    }

    public EmailConfig getEmailConfig() {
        return emailConfig;
    }

    public void setEmailConfig(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }
}
