package com.bookstore;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(LiquibaseProperties.class)
public class BookStoreApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(BookStoreApp.class, args);
		
		
	}

}
