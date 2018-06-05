package org.shenb.example.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import org.shenb.example.guice.anno.One;
import org.shenb.example.guice.anno.Two;
import org.shenb.example.guice.service.HelloService;
import org.shenb.example.guice.service.impl.HelloServiceImpl;
import org.shenb.example.guice.service.impl.HelloTomServiceImpl;

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
                binder.bind(HelloService.class).annotatedWith(One.class).to(HelloServiceImpl.class);
                binder.bind(HelloService.class).annotatedWith(Two.class).to(HelloTomServiceImpl.class);
            }
        });
        Processor1 processor1 = injector.getInstance(Processor1.class);

        processor1.getHelloService().say();
        processor1.getHelloTomService().say();

        injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloService.class).annotatedWith(Names.named("One")).to(HelloServiceImpl.class);
                binder.bind(HelloService.class).annotatedWith(Names.named("Two")).to(HelloTomServiceImpl.class);
            }
        });
        Processor2 processor2 = injector.getInstance(Processor2.class);
        processor2.getHelloService().say();
        processor2.getHelloTomService().say();
    }
}
