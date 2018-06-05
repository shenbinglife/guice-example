# Simplest example to start  Guice.

## Step  
1. 创建接口和实现类：HelloService， HelloServiceImpl
2. 从Guice容器取出HelloService
3. 执行HelloService方法

```java
public static void main(String[] args) {
    Injector injector = Guice.createInjector();
    HelloService helloGuice = injector.getInstance(HelloService.class);
    helloGuice.say();
}
```

## Question  
1. Guice如何自动扫描HelloService实现类并注入容器?  
    Guice并不像Spring支持扫包的功能，它调用`Injector#getInstance(Class)`方法，只是默认的去执行class的构造方法（或其他@Inject标记的构造方法），并缓存对象到容器。
    
2. Guice如何关联HelloService和HelloServiceImpl?  
    Guice没有扫包功能，也就没有自动发现接口实现类功能。所以接口类需要添加`@ImplementedBy`注解，表示接口的实例对象类型。