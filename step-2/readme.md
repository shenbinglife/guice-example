# Guice 字段注入、静态字段注入、Setter方法注入、 构造函数注入

## Step
1. 构造执行器
    ```java
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
    ```

2. 从容器获取执行器

    ```java
    Injector injector = Guice.createInjector();
    Processor app = injector.getInstance(Processor.class);
    
    app.getFieldInject().say(); //OK
    app.getSetterInject().say(); //OK
    app.getConstractInject().say(); //OK
    Processor.staticField.say(); //FAILED
    ```
    
## Question
1. Processor没有特殊注解，Guice如何自动调用Processor的构造方法? 多个构造方法时会冲突吗?  
    默认调用@Inject标记的构造方法，无法找到时，调用公有无参构造方法。  
    多个@Inject标记的构造方法会启动异常。  
    Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.
    
2. static 字段注入失败，怎么处理?
    * static字段可以通过构造器注入，但是不支持Setter方法注入
    * 或配置Guice，指定类执行静态注入
        ```java
          Injector injector2 = Guice.createInjector(new Module() {
              @Override
              public void configure(Binder binder) {
                  binder.requestStaticInjection(Processor.class);
              }
          });
          Processor app2 = injector.getInstance(Processor.class);
          Processor.staticField.say();
        ```
3. 如何对实例化的对象注入容器的Bean
    1. 调用`Injector#injectMembers(Object)`
        ```java
           InstanceFieldInjectDemo ifid = new InstanceFieldInjectDemo();
           Guice.createInjector().injectMembers(ifid);
           ifid.service.execute();
        ```
    2. 或自定义配置Guice
        ```java
           final InstanceFieldInjectDemo ifid = new InstanceFieldInjectDemo();
           Guice.createInjector(new Module() {
               @Override
               public void configure(Binder binder) {
                   binder.requestInjection(ifid);
               }
           });
           ifid.service.execute();
        ```