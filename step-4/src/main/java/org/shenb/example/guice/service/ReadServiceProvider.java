package org.shenb.example.guice.service;

import org.shenb.example.guice.service.impl.ReadServiceImpl;

import com.google.inject.Provider;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class ReadServiceProvider implements Provider<ReadServcie> {

    private ReadServcie readServcie = new ReadServiceImpl();

    @Override
    public ReadServcie get() {
        return new ReadServiceImpl();
    }
}
