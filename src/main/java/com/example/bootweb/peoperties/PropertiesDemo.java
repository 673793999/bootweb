package com.example.bootweb.peoperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jiangtenglong no 2018/1/11 .
 */
@ConfigurationProperties(prefix = "hello")
public class PropertiesDemo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
