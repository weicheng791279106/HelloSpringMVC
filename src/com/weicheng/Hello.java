package com.weicheng;

public class Hello {

	/**
	 * springMVC���ѧϰʾ������
	 * 
	 * ��������ʾ���¼���֪ʶ�㣺
	 * 	1��springMVC������
	 * 	2��springMVCǰ�˿�������ӳ����������������ͼ������������
	 *  3��ע������������
	 *  4����������ʹ�� {@link com.weicheng.interceptor.Hello}
	 *  5��ȫ���쳣���� {@link com.weicheng.exception.Hello}
	 *  6�����ص�ѧϰ {@link com.weicheng.controller.ItemController4}�еĸ�����ʾʾ��
	 *  7��springmvc��mybatis����ʵսʾ������com.weicheng.ssm���е����ݣ�
	 * 
	 * #springMVC���ͼ��doc:springMVC���.png
	 * 
	 * #WEB-INF/web.xml:ǰ�˿����������ã�spring�����ļ������ã�POST�����������
	 * 
	 * #com.weicheng.config.springmvc.xml:������ӳ����������������������ͼ�����������ã�ע�����������ã�����ת�������ã��쳣���������ã��ļ��ϴ����������ã�����������
	 * 
	 * #config.db.properties������Դ����
	 * 
	 * #config.log4j.properties��log4j��־���ģ������
	 * 
	 * #config.spring.applicationContext-dao.xml������Դ���ã����ݿ����ӳص����ã�mapperɨ��������
	 * 
	 * #config.spring.applicationContext-service.xml������service�������Ӧ����Ŀ��û���õ�@Service��ǩ����ʹ��xml���ã�
	 * 
	 * #config.spring.applicationContext-transaction.xml�������������
	 * 
	 * #config.mybatis��po��������ã�mybatis���ʹ�ã������Ȳ���
	 * 
	 * #��ʾ�����¼���ӳ������
	 * 	1��BeanNameUrlHandlerMapping����Handler����Ӧ��bean��name������Ϊurl���в���
	 * 	2��SimpleUrlHandlerMapping��ʹ��Handler bean��id���Խ���ӳ��
	 * 	3��RequestMappingHandlerMapping��ע����ӳ������������ע�������������ʹ��
	 * 
	 * #��ʾ�����¼�����������
	 * 	1��SimpleControllerHandlerAdapter��ֻ�ܴ���ʵ����Controller�ӿڵ�Handler
	 * 	2��HttpRequestHandlerAdapter��ֻ�ܴ���ʵ����HttpRequestHandler�ӿڵ�Handler
	 * 	3��RequestMappingHandlerAdapter��ע������������������עע����ӳ�������ʹ��
	 * 
	 * #��ʾ�����¼�����ͼ��������
	 * 	1��InternalResourceViewResolver:����jsp��Ĭ��ʹ��jstl��ǩ��classpath����Ҫ��jstl�İ�������������ͼ·��ǰ׺�ͺ�׺
	 * 
	 * #������(Handler/Controller)�ı�д����com.weicheng.controller�µ�controllerʾ��
	 * #��ʾ�����¼��ִ�������
	 * 	1��ʵ��Controller�ӿڵĴ�������ItemController1
	 * 	2��ʵ����HttpRequestHandler�Ĵ�������ItemController2��ItemController3
	 * 	3��ʹ��ע��Ĵ�������ItemController4�����ã�
	 * 
	 * #��spring-webmvc-3.2.0.RELEASE.jar���е�org.springframework.web.servlet������һ��DispatcherServlet.properties�ļ��������Ŀ��û������
	 *  ӳ����������������ͼ�������������springMVC���DispatcherServlet.properties�м�����Ĭ�����������
	 * 
	 * 
	 * #�������룺
	 * 	1������get��������룬������tomcat������Ĭ�ϱ���ΪISO8859-1����Ҫ�������ΪUTF-8����tomcat�ļ�����conf/server.xml�ļ����޸���һ�У�
	 * 		 <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
	 * 		����URIEncoding="UTF-8��һ�䣬������ɾ�����tomcat����������������
	 * 
	 * 	2������post��������룬�ڹ��̵�WebRoot/WEB-INF/lib/web.xml�ļ��¼���post������������ɣ�����ο�web.xml�ļ�
	 * 
	 * #json������Ҫ�������jar����jackson-annotations-2.6.0.jar,jackson-core-2.6.0.jar,jackson-databind-2.6.0.jar
	 * 
	 * 
	 * 
	 * */
	
}
