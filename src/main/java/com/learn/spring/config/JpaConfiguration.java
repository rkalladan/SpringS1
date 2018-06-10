package com.learn.spring.config;
	 
	import java.util.Properties;
	 
	import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
	 
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.PropertySource;
	import org.springframework.core.env.Environment;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	import org.springframework.orm.jpa.JpaTransactionManager;
	import org.springframework.orm.jpa.JpaVendorAdapter;
	import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
	import org.springframework.transaction.PlatformTransactionManager;
	import org.springframework.transaction.annotation.EnableTransactionManagement;
	 
	@Configuration
	@EnableTransactionManagement
	@PropertySource(value = { "classpath:application.properties" })
	public class JpaConfiguration {
	 
	    @Autowired
	    private Environment environment;
	 
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	 
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
	        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
	        factoryBean.setDataSource(dataSource());
	        factoryBean.setPackagesToScan(new String[] { "com.learn.spring.model" });
	        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
	        factoryBean.setJpaProperties(jpaProperties());
	        return factoryBean;
	    }
	 
	    /*
	     * Provider specific adapter.
	     */
	    @Bean
	    public JpaVendorAdapter jpaVendorAdapter() {
	        EclipseLinkJpaVendorAdapter eclipseLinkJpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
	        return eclipseLinkJpaVendorAdapter;
	    }
	 
	    /*
	     * Here you can specify any provider specific properties.
	     */
	    private Properties jpaProperties() {
	        Properties properties = new Properties();
	        properties.put("eclipselink.target-database", environment.getRequiredProperty("eclipselink.target-database"));
	        properties.put("eclipselink.ddl-generation", environment.getRequiredProperty("eclipselink.ddl-generation"));
	        properties.put("eclipselink.weaving",environment.getRequiredProperty("eclipselink.weaving"));
	        properties.put("eclipselink.show_sql",environment.getRequiredProperty("eclipselink.show_sql"));
	        properties.put("eclipselink.format_sql",environment.getRequiredProperty("eclipselink.format_sql"));
	        return properties;
	    }
	 
	    @Bean
	    @Autowired
	    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	        JpaTransactionManager txManager = new JpaTransactionManager();
	        txManager.setEntityManagerFactory(emf);
	        return txManager;
	    }
	    
}
