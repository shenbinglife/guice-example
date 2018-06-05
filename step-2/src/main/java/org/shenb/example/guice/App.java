package org.shenb.example.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

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
        Processor app = injector.getInstance(Processor.class);

        app.getFieldInject().say();
        app.getSetterInject().say();
        app.getConstractInject().say();
//        Processor.staticField.say();

        //多个构造器@Inject
//        Processor2 processor2 = injector.getInstance(Processor2.class);
//        processor2.getH1().say();
//        processor2.getH2().say();

        //static 静态字段注入
        Processor3 processor3 = injector.getInstance(Processor3.class);
//        Processor3.setterInject.say();
        Processor3.constractorInject.say();

        //static 静态字段注入
        Injector injector2 = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.requestStaticInjection(Processor.class);
            }
        });
        Processor app2 = injector.getInstance(Processor.class);
        Processor.staticField.say();

        Processor4 processor4 = injector.getInstance(Processor4.class);
    }
}
