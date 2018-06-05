package org.shenb.example.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.shenb.example.guice.service.HelloService;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        HelloService helloGuice = injector.getInstance(HelloService.class);
        helloGuice.say();
    }
}
