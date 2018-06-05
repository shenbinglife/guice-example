# Guice AOP
Guice的AOP还是很弱的，目前仅仅支持方法级别上的，另外灵活性也不是很高。如果切面依赖仍然走切面的话那么程序就陷入了死循环，很久就会堆溢出   

Guice支持AOP的条件是：  
* 类必须是public或者package (default)  
* 类不能是final类型的  
* 方法必须是public,package或者protected  
* 方法不能使final类型的  
* 实例必须通过Guice的@Inject注入或者有一个无参数的构造函数  

## Step
1. 定义接口和实现类
2. 定义切面，实现`MethodInterceptor `接口，切面支持注入依赖，需要手动Inject
3. 绑定切面和实现类
```java
Injector injector = Guice.createInjector(new Module() {
    @Override
    public void configure(Binder binder) {
        LogAspect logAspect = new LogAspect();
        binder.requestInjection(logAspect);
        binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Log.class), logAspect);
    }
});
```

## Backup
```java
//第一个参数是匹配类，第二个参数是匹配方法，第三个数组参数是方法拦截器。
Binder.bindInterceptor(Matcher<? super Class<?>>, Matcher<? super Method>, MethodInterceptor...)
```

