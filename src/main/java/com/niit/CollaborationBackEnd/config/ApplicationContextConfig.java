package com.niit.CollaborationBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.niit.CollaborationBackEnd.model.Blog;
import com.niit.CollaborationBackEnd.model.Event;
import com.niit.CollaborationBackEnd.model.Friend;
import com.niit.CollaborationBackEnd.model.UserDetail;

@EnableWebMvc
@Configuration
@ComponentScan("com.niit.CollaborationBackEnd")
@EnableTransactionManagement
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {

	@Bean(name = "datasource")
	public DataSource getOracleDatasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("colb_db");
		datasource.setPassword("123");
	
	
		Properties connectionProperties = new Properties();
		
		connectionProperties.put("hibernate.show_sql", "true");
		connectionProperties.put("hibernate.format_sql", "true");
		connectionProperties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		connectionProperties.put("hibernate.hbm2ddl.auto", "update");
		
		datasource.setConnectionProperties(connectionProperties);
		return datasource;
	}
	
	/*private Properties getHibernateProperties(){
		Properties properties=new Properties();
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
		
	}*/
	

	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		/*sessionBuilder.addProperties(getHibernateProperties());*/
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(UserDetail.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		sessionBuilder.addAnnotatedClass(Event.class);
		//sessionBuilder.addAnnotatedClass(Role.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransctionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}
}