package edu.rmf.databaseinitialize.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class SecondDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.second-database")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource secondDataSource() {
        return secondDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate secondJdbcTemplate() {
        return new JdbcTemplate(secondDataSource());
    }
}
