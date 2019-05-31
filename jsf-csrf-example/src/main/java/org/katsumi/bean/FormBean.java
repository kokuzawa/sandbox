package org.katsumi.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class FormBean {

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return String.format("登録しました「%s」", text);
    }
}
