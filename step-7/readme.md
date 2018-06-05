# Guice Servlet 应用

基于Servlet3.0 特性，实现在Servlet中注入对象

## Step
1. 实现`ServletContainerInitializer` 接口，这样支持无web.xml启动tomcat服务
2. 实现`GuiceServletContextListener`接口，并注册到Servlet容器
3. 在`GuiceServletContextListener`实现类中注册GuiceFilter到ServletContext中
4. 创建HelloServlet，并注入HelloService
5. 在`GuiceServletContextListener`实现类配置ServletMapping

## Code
InjectListener: 

```java
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

```

HelloServlet
```java
@Singleton
public class HelloServlet extends HttpServlet {

    @Inject
    private HelloService helloService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        helloService.say();
        resp.getWriter().write("hello world");
    }
}

```

## Question
1. Servlet是单例？
    是的。
