package com.example.bootweb.peoperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by jiangtenglong no 2018/1/11 .
 */
@Component
@PropertySource("/demo.properties")
@ConfigurationProperties(prefix = "jtl")
public class MyProperties {

    private String name;

    private String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
