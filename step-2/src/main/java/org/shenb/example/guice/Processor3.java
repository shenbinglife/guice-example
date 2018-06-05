package org.shenb.example.guice;

import com.google.inject.Inject;
import org.shenb.example.guice.service.HelloService;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class Processor3 {

    public static HelloService constractorInject;

    public static HelloService setterInject;

    @Inject
    public Processor3(HelloService helloService) {
        Processor3.constractorInject = helloService;
    }

    @Inject
    public static void setHelloService(HelloService helloService) {
        Processor3.setterInject = helloService;
    }
}
