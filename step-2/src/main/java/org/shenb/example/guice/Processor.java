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
public class Processor {

    @Inject
    public static HelloService staticField;

    private HelloService constractInject;

    private HelloService setterInject;

    @Inject
    private HelloService fieldInject;

    @Inject
    public Processor(HelloService constractInject) {
        this.constractInject = constractInject;
    }

    @Inject
    public void setSetterInject(HelloService setterInject) {
        this.setterInject = setterInject;
    }

    public HelloService getConstractInject() {
        return constractInject;
    }

    public HelloService getSetterInject() {
        return setterInject;
    }

    public HelloService getFieldInject() {
        return fieldInject;
    }
}
