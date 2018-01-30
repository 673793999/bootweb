package com.example.bootweb.endpoint;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by jiangtenglong no 2018/1/11 .
 */
@Component
public class MyEndpoint extends AbstractEndpoint<String> implements ApplicationContextAware{

    public MyEndpoint() {
        super("status");
    }

    @Override
    public String invoke() {
        return "mystatus";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
