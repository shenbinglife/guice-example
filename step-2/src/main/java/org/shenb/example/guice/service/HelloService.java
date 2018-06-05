package org.shenb.example.guice.service;

import org.shenb.example.guice.service.impl.HelloServiceImpl;

import com.google.inject.ImplementedBy;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
@ImplementedBy(HelloServiceImpl.class)
public interface HelloService {

    void say();
}
