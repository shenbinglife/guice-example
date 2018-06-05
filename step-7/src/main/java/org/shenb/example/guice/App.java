package org.shenb.example.guice;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
@WebListener
public class App implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {}
}
