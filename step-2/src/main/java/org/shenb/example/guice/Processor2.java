package org.shenb.example.guice;

import org.shenb.example.guice.service.HelloService;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class Processor2 {

    private HelloService h1;

    private HelloService h2;

    public Processor2(HelloService h1) {
        this.h1 = h1;
    }

    public Processor2(HelloService h1, HelloService h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    public HelloService getH1() {
        return h1;
    }

    public void setH1(HelloService h1) {
        this.h1 = h1;
    }

    public HelloService getH2() {
        return h2;
    }

    public void setH2(HelloService h2) {
        this.h2 = h2;
    }
}
