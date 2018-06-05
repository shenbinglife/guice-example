package org.shenb.example.guice;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.util.Properties;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class App {

    @Inject
    @Named("name")
    private String name;

    @Inject
    @Named("age")
    private Integer age;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                Properties properties = new Properties();
                properties.setProperty("name", "shenbing");

                // bind Properties Or Map
                Names.bindProperties(binder, properties);

                // bindConstant
                binder.bindConstant().annotatedWith(Names.named("age")).to(22);
            }
        });
        App instance = injector.getInstance(App.class);
        System.out.println(instance.name);
        System.out.println(instance.age);
    }
}
