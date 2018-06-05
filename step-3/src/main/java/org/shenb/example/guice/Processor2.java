package org.shenb.example.guice;

import org.shenb.example.guice.service.HelloService;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class Processor2 {
    @Inject
    @Named("One")
    private HelloService helloService;

    @Inject
    @Named("Two")
    private HelloService helloTomService;


    public HelloService getHelloService() {
        return helloService;
    }

    public HelloService getHelloTomService() {
        return helloTomService;
    }
}
