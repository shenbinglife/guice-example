package org.shenb.example.guice.service.impl;

import org.shenb.example.guice.service.ReadServcie;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class ReadServiceImpl implements ReadServcie {
    @Override
    public void read() {
        System.out.println("i am reading");
    }
}
