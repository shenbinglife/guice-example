package org.shenb.example.guice.service;

import com.google.inject.ProvidedBy;
import org.shenb.example.guice.service.impl.HelloServiceImpl;

import com.google.inject.ImplementedBy;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
@ProvidedBy(HelloServiceProvider.class)
public interface HelloService {

    void say();
}
