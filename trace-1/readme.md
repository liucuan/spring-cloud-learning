```
2018-07-25 17:41:56.279  INFO [trace-1,bc769605d682dbd9,bc769605d682dbd9,false] 9664 --- [nio-8201-exec-5] com.tone.Trace1Application               : ===call trace-1===
```

从上面的控制台输出内容中，我们可以看到多了一些形如[trace-1,bc769605d682dbd9,bc769605d682dbd9,false]的日志信息，而这些元素正是实现分布式服务跟踪的重要组成部分，它们每个值的含义如下：

##### 第一个值：trace-1，
    它记录了应用的名称，也就是application.properties中spring.application.name参数配置的属性。
##### 第二个值：bc769605d682dbd9
    Spring Cloud Sleuth生成的一个ID，称为Trace ID，它用来标识一条请求链路。一条请求链路中包含一个Trace ID，多个Span ID。
##### 第三个值：bc769605d682dbd9
    Spring Cloud Sleuth生成的另外一个ID，称为Span ID，它表示一个基本的工作单元，比如：发送一个HTTP请求。
##### 第四个值：false
    表示是否要将该信息输出到Zipkin等服务中来收集和展示。
    
##### 输出到Zipkin
######添加依赖
    <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-sleuth-zipkin</artifactId>
       <version>2.0.0.RELEASE</version>
    </dependency>
    
######修改application.properties
    spring.sleuth.sampler.percentage=1
