package org.shenb.example.guice;

import com.google.inject.Inject;
import org.shenb.example.guice.anno.One;
import org.shenb.example.guice.anno.Two;
import org.shenb.example.guice.service.HelloService;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class Processor1 {

    @Inject
    @One
    private HelloService helloService;

    @Inject
    @Two
    private HelloService helloTomService;


    public HelloService getHelloService() {
        return helloService;
    }

    public HelloService getHelloTomService() {
        return helloTomService;
    }
}
