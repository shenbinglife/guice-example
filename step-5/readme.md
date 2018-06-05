# Guice 绑定常量

## Step
1. Guice.createInjector 传入配置
2. 通过@Inject和@Named注入常量
```java
Injector injector = Guice.createInjector(new Module() {
    @Override
    public void configure(Binder binder) {
        Properties properties = new Properties();
        properties.setProperty("name", "shenbing");

        // bind Properties Or Map
        Names.bindProperties(binder, properties);

        // bindConstant
        binder.bindConstant().annotatedWith(Names.named("age")).to(22);
    }
});
```
## Question
1. 如何绑定复杂类型？例如Array，List，Map常量
