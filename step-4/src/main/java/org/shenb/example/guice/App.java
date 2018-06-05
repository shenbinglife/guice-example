package org.shenb.example.guice;

import com.google.inject.*;
import org.shenb.example.guice.service.HelloService;
import org.shenb.example.guice.service.HelloServiceProvider;
import org.shenb.example.guice.service.ReadServcie;
import org.shenb.example.guice.service.ReadServiceProvider;

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
        HelloService instance = injector.getInstance(HelloService.class);
        instance.say();

        injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(ReadServcie.class).toProvider(ReadServiceProvider.class).in(Singleton.class);
            }
        });
        ReadServcie readServcie = injector.getInstance(ReadServcie.class);
        readServcie.read();

        ReadServcie read = injector.getInstance(ReadServcie.class);
        System.out.println(read == readServcie);
    }
}
