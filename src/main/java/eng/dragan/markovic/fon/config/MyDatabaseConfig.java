package eng.dragan.markovic.fon.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "eng.dragan.markovic.fon.repository.jpa")
@ComponentScan(basePackages = { "eng.dragan.markovic.fon.service.impl", "eng.dragan.markovic.fon.repository",
		"eng.dragan.markovic.fon.converter" })
@EnableTransactionManagement
public class MyDatabaseConfig {
	
	 @Autowired
	    private Environment env;
	 
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/faculty");
		datasource.setUsername("root");
		datasource.setPassword("");
		return datasource;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(datasource());
		// gde su entity klase
		em.setPackagesToScan(new String[] { "eng.dragan.markovic.fon.entity" });
		// JPA provider
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		em.setJpaVendorAdapter(jpaVendorAdapter);
		
		em.setJpaProperties(additionalProperties());

		return em;
	}

	
	
	
	final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        //hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("jpa.hibernate.ddl-auto", "create");
        return hibernateProperties;
    }
//spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(datasource());
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
}
