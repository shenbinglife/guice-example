package org.shenb.example.guice.listener;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import com.google.inject.servlet.GuiceFilter;
import org.shenb.example.guice.controller.HelloServlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import java.util.EnumSet;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
@WebListener
public class InjectListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        System.out.println("listener");
        return Guice.createInjector(new ServletModule() {
            protected void configureServlets() {
                serve("/hello").with(HelloServlet.class);
            }
        });
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        super.contextInitialized(servletContextEvent);

        //必须注册Guice提供的过滤器
        servletContextEvent.getServletContext().addFilter("guiceFilter", GuiceFilter.class).addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
