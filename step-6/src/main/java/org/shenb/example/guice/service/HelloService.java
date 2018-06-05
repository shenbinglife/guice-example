package org.shenb.example.guice.service;

import com.google.inject.ImplementedBy;
import org.shenb.example.guice.service.impl.HelloServiceImpl;

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

    void bye();
}
