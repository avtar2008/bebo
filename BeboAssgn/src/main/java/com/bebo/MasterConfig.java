package com.bebo;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;


@Configuration
@ComponentScan
//@EnableTransactionManagement
public class MasterConfig {

//	@Autowired
//	DataSource dataSource;
//	
	
	@Bean
	public DataSource dataSource() {
		// <property name = "driverClassName" value = "com.mysql.jdbc.Driver"/>
		// <property name = "url" value = "jdbc:mysql://localhost:3306/TEST"/>
		// <property name = "username" value = "root"/>
		// <property name = "password" value = "admin"/>
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test", "demo", "demo");
//		return dataSource;
		
		
		AtomikosNonXADataSourceBean ds = new AtomikosNonXADataSourceBean();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUniqueResourceName("XADS1");
		ds.setUser("demo");
		ds.setPassword("demo");
		ds.setPoolSize(10);
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setTestQuery("SELECT 1 FROM DUAL");
		
		
		return ds;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManager() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		//entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		// entityManagerFactoryBean.setPackagesToScan("");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
			//Class.forName("com.atomikos.jdbc.nonxa.NonXADataSourceBean");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties jpaProperties = new Properties();

		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		jpaProperties.put("hibernate.hbm2ddl.auto", "validate");

		jpaProperties.put("hibernate.show_sql", true);

		jpaProperties.put("hibernate.format_sql", true);

		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		// entityManagerFactoryBean.setPersistenceUnitName("BeboUnit");
		//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + dataSource);
		 entityManagerFactoryBean.setJtaDataSource(dataSource());
		 
		/*
		 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		 * vendorAdapter.setDatabase(org.springframework.orm.jpa.vendor.Database.MYSQL);
		 * 
		 * entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		 */
		 
		 

		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean;
	}

	
	
//	 @Bean
//	 public JtaTransactionManager	 getJtaTransactionManager() {
//	 
//	JtaTransactionManager manager = new JtaTransactionManager();
//	manager.setTransactionManagerName("transactionManager");
//			//DataSourceTransactionManager(getDataSource();
//	 
//	 return  manager;
//	 }
	 
	 

}
