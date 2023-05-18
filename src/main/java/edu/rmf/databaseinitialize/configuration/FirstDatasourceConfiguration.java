package edu.rmf.databaseinitialize.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class FirstDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.first-database")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource firstDataSource() {
        return firstDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate firstJdbcTemplate() {
        return new JdbcTemplate(firstDataSource());
    }
}
