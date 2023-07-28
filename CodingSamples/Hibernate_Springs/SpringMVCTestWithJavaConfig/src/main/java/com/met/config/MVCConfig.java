package com.met.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.met.model.Employee;

//<beans  ->  @Configuration
//<tx:annotation-driven transaction-manager="hibernateTransactionManager"/> 		-> @EnableTransactionManagement
//<context:component-scan base-package="com.met.*"></context:component-scan>      ->  @ComponentScan
//<mvc:annotation-driven />   -> @EnableWebMvc

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.met.*")
@EnableWebMvc
public class MVCConfig {

	/*
	 * <bean
	 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * <property name="prefix"> <value>/WEB-INF/pages/</value> </property> <property
	 * name="suffix"> <value>.jsp</value> </property> </bean>
	 */
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vw = new InternalResourceViewResolver();
		vw.setPrefix("/WEB-INF/pages/");
		vw.setSuffix(".jsp");
		
		return vw;
	}
	
	
	/*
	 * <bean id="oracleDataSource"
	 * class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	 * <property name="driverClassName" value="oracle.jdbc.OracleDriver" />
	 * <property name="url" value="jdbc:oracle:thin:@iitdac.met.edu:7000/xe" />
	 * <property name="username" value="milind" /> <property name="password"
	 * value="milind" /> </bean>
	 */
	
	@Bean("oracleDataSource")
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@iitdac.met.edu:7000/xe");
		ds.setUsername("milind");
		ds.setPassword("milind");
		
		
		return ds;
	}
	
	
	/*
	 * <bean id="mySqlDataSource"
	 * class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	 * <property name="driverClassName" value="oracle.jdbc.OracleDriver" />
	 * <property name="url" value="jdbc:oracle:thin:@iitdac.met.edu:7000/xe" />
	 * <property name="username" value="milind" /> <property name="password"
	 * value="milind" /> </bean>
	 */
	
	@Bean("mySqlDataSource")
	public DataSource dataSource1() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@iitdac.met.edu:7000/xe");
		ds.setUsername("milind");
		ds.setPassword("milind");
		
		
		return ds;
	}
	
	/*
	 * <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
	 * <property name="dataSource" ref="oracleDataSource"></property> </bean>
	 */
	
	/*
	 * @Bean public JdbcTemplate jdbcTemplate() {
	 * 
	 * JdbcTemplate jt = new JdbcTemplate(); jt.setDataSource(dataSource());
	 * 
	 * return jt;
	 * 
	 * }
	 */
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("oracleDataSource") DataSource ds) {
		
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		
		return jt;
		
	}
	
	/*
	 * <bean id="sessionFactoryBean"
	 * class="org.springframework.orm.hibernate4.LocalSessionFactoryBean"> <property
	 * name="dataSource" ref="oracleDataSource"></property> <property
	 * name="annotatedClasses"> <list> <value>com.met.model.Employee</value> </list>
	 * </property> <property name="hibernateProperties"> <props> <prop
	 * key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop> <prop
	 * key="hibernate.show_sql">true</prop> </props> </property> </bean>
	 */
	
	/*
	 * <bean id="sessionFactoryBean"
	 * class="org.springframework.orm.hibernate4.LocalSessionFactoryBean"> <property
	 * name="dataSource" ref="oracleDataSource"></property> <property
	 * name="annotatedClasses"> <list> <value>com.met.model.Employee</value> </list>
	 * </property> <property name="hibernateProperties"> <props> <prop
	 * key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop> <prop
	 * key="hibernate.show_sql">true</prop> </props> </property> </bean>
	 */
	
	@Bean
	public LocalSessionFactoryBean lsf() {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource());
		
		sfb.setAnnotatedClasses(Employee.class);
		
		sfb.setHibernateProperties(props());
		
		
		return sfb;
		
	}
	
	@Bean
	public Properties props() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.show_sql", "true");
		
		
		return properties;
	}
	
	/*
	 * <bean id="hibernateTransactionManager"
	 * class="org.springframework.orm.hibernate4.HibernateTransactionManager">
	 * <property name="sessionFactory" ref="sessionFactoryBean"></property> </bean>
	 */

	@Bean
	public HibernateTransactionManager htm(SessionFactory sf) {
		
		HibernateTransactionManager htm = new HibernateTransactionManager();
		
		htm.setSessionFactory(sf);
		
		return htm;
		
		
	}

}
