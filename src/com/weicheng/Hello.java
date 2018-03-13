package com.weicheng;

public class Hello {

	/**
	 * springMVC框架学习示例工程
	 * 
	 * 本工程演示如下几个知识点：
	 * 	1、springMVC整体框架
	 * 	2、springMVC前端控制器、映射器、适配器、视图解析器的配置
	 *  3、注解驱动的配置
	 *  4、拦截器的使用 {@link com.weicheng.interceptor.Hello}
	 *  5、全局异常处理 {@link com.weicheng.exception.Hello}
	 *  6、请重点学习 {@link com.weicheng.controller.ItemController4}中的各个演示示例
	 *  7、springmvc与mybatis整合实战示例（见com.weicheng.ssm包中的内容）
	 * 
	 * #springMVC框架图见doc:springMVC框架.png
	 * 
	 * #WEB-INF/web.xml:前端控制器的配置，spring配置文件的引用，POST乱码过滤配置
	 * 
	 * #com.weicheng.config.springmvc.xml:处理器映射器、处理器适配器、视图解析器的配置，注解驱动的配置，参数转换器配置，异常处理器配置，文件上传解析器配置，拦截器配置
	 * 
	 * #config.db.properties：数据源配置
	 * 
	 * #config.log4j.properties：log4j日志输出模块配置
	 * 
	 * #config.spring.applicationContext-dao.xml：数据源配置，数据库连接池的配置，mapper扫描器配置
	 * 
	 * #config.spring.applicationContext-service.xml：配置service层组件（应用项目中没有用到@Service标签所以使用xml配置）
	 * 
	 * #config.spring.applicationContext-transaction.xml：事务管理配置
	 * 
	 * #config.mybatis：po层别名配置，mybatis框架使用，可以先不管
	 * 
	 * #演示了以下几种映射器：
	 * 	1、BeanNameUrlHandlerMapping：将Handler所对应的bean的name属性作为url进行查找
	 * 	2、SimpleUrlHandlerMapping：使用Handler bean的id属性进行映射
	 * 	3、RequestMappingHandlerMapping：注解用映射器，必须与注解用适配器配对使用
	 * 
	 * #演示了以下几种适配器：
	 * 	1、SimpleControllerHandlerAdapter：只能处理实现了Controller接口的Handler
	 * 	2、HttpRequestHandlerAdapter：只能处理实现了HttpRequestHandler接口的Handler
	 * 	3、RequestMappingHandlerAdapter：注解用适配器，必须与注注解用映射器配对使用
	 * 
	 * #演示了以下几种视图解析器：
	 * 	1、InternalResourceViewResolver:解析jsp，默认使用jstl标签，classpath下需要有jstl的包，可以配置视图路径前缀和后缀
	 * 
	 * #处理器(Handler/Controller)的编写：见com.weicheng.controller下的controller示例
	 * #演示了以下几种处理器：
	 * 	1、实现Controller接口的处理器：ItemController1
	 * 	2、实现了HttpRequestHandler的处理器：ItemController2、ItemController3
	 * 	3、使用注解的处理器：ItemController4（常用）
	 * 
	 * #在spring-webmvc-3.2.0.RELEASE.jar包中的org.springframework.web.servlet包下有一个DispatcherServlet.properties文件，如果项目中没有配置
	 *  映射器、适配器、视图解析器等组件，springMVC会从DispatcherServlet.properties中加载其默认声明的组件
	 * 
	 * 
	 * #关于乱码：
	 * 	1、对于get请求的乱码，是由于tomcat服务器默认编码为ISO8859-1，需要将编码变为UTF-8，在tomcat文件夹下conf/server.xml文件中修改这一行：
	 * 		 <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
	 * 		加入URIEncoding="UTF-8这一句，再重新删除添加tomcat服务器，启动即可
	 * 
	 * 	2、对于post请求的乱码，在工程的WebRoot/WEB-INF/lib/web.xml文件下加入post编码过滤器即可，具体参考web.xml文件
	 * 
	 * #json解析需要导入相关jar包：jackson-annotations-2.6.0.jar,jackson-core-2.6.0.jar,jackson-databind-2.6.0.jar
	 * 
	 * 
	 * 
	 * */
	
}
