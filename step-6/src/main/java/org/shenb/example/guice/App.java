package org.shenb.example.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import org.shenb.example.guice.service.HelloService;
import org.shenb.example.guice.service.Log;
import org.shenb.example.guice.service.impl.LogAspect;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                LogAspect logAspect = new LogAspect();
                binder.requestInjection(logAspect);
                binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Log.class), logAspect);
            }
        });
        HelloService helloService = injector.getInstance(HelloService.class);
        helloService.say();
        helloService.bye();
    }
}
