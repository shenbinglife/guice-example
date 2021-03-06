package org.shenb.example.guice.service.impl;

import org.shenb.example.guice.service.HelloService;
import org.shenb.example.guice.service.Log;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class HelloServiceImpl implements HelloService {

    @Log
    @Override
    public void say() {
        System.out.println("hello");
    }

    @Override
    public void bye() {
        System.out.println("bye bye");
    }


}
