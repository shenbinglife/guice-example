package org.shenb.example.guice.service;

import com.google.inject.Provider;
import org.shenb.example.guice.service.impl.HelloServiceImpl;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class HelloServiceProvider implements Provider<HelloService> {
    @Override
    public HelloService get() {
        return new HelloServiceImpl();
    }
}
