package com.bookstore;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	@Bean
	public DataSource getDataSource() throws Exception{
	
	
		DataSourceFactory dataSourceFactory = new DataSourceFactory();
		Properties properties = new Properties();
		properties.setProperty("driver", "com.zaxxer.hikari.HikariDataSource");
		properties.setProperty( "url", "jdbc:mariadb://localhost:3306/test?useLegacyDatetimeCode=false&serverTimezone=UTC");
		properties.setProperty	("username", "root");
		properties.setProperty	("password", "123456");
		return	dataSourceFactory.createDataSource(properties);
		
		
	}
	
    @Bean
    public SpringLiquibase liquibase(DataSource dataSource, LiquibaseProperties liquibaseProperties) {

        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:liquibase/master.xml");
        liquibase.setContexts(liquibaseProperties.getContexts());
        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
        
        return liquibase;
    }

    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }
}
