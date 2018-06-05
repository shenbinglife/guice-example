# Guice工厂
类似于Spring的FactoryBean，每次获取Bean实例都会通过工厂创建一个实例，然后返回客户端。


## Step
1. 创建工厂类，实现Provider<T>接口
2. 在接口上添加注解`@ProvidedBy`，标明使用的工厂类
3. 从容器获取接口实例对象

或手动注册工厂：
1. 创建工厂类，实现Provider<T>接口
2. 在Guice配置接口关联的工厂
3. 从容器获取接口实例对象
    ```java
    injector = Guice.createInjector(new Module() {
        @Override
        public void configure(Binder binder) {
            binder.bind(ReadServcie.class).toProvider(ReadServiceProvider.class);
        }
    });
    ReadServcie readServcie = injector.getInstance(ReadServcie.class);
    ```
    
## Question
1. 容器通过工厂获得的Bean是单例吗？
默认情况下，Guice 每次都会返回一个新创建的对象，即便Provider中通过私有属性缓存了Bean，Injector每次都返回不同的Bean实例。  
设置Provider为Singleton，那么每次才会返回相同单例对象。

###配置Scope Singleton  
```java
    @Singleton
    public class InMemoryTransactionLog implements TransactionLog {
      /* everything here should be threadsafe! */
    }
    
    @Provides @Singleton
    TransactionLog provideTransactionLog() {
      ...
    }
    
    //或通过代码配置
    bind(TransactionLog.class).to(InMemoryTransactionLog.class).in(Singleton.class);
```
    
如果某个类型已经被注解标注了scope，同时还使用bind() 方法配置了scope，那么后者生效。如果一个类型已经被注解配置了scope而你不想那样，你可以使用 bind() 覆盖。

### 预加载的单例
```java
bind(TransactionLog.class).to(InMemoryTransactionLog.class).asEagerSingleton();
```