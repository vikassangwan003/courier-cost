//TODO- Will be using in case of external database-- as of now using in memory H2 DB

/**
package com.snapdeal.courier.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

//@Configuration
@EnableJpaRepositories(basePackages = "com.snapdeal.courier.repository")
public class DbConfig {

    @Value("${driver_class_name}")
    private String dbDriverClass;
    @Value("${db_url}")
    private String dbUrl;
    @Value("${db_user_name}")
    private String dbUsername;
    @Value("${db_password}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().username(dbUsername)
                .password(dbPassword)
                .url(dbUrl).driverClassName(dbDriverClass).build();
    }
}
**/