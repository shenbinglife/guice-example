package org.shenb.example.guice.service.impl;

import org.shenb.example.guice.service.HelloService;

import com.google.inject.Singleton;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void say() {
        System.out.println("hello");
    }

    @Override
    public void bye() {
        System.out.println("bye bye");
    }


}
