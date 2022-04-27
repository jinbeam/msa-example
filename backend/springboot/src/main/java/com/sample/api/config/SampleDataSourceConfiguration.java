package com.sample.api.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sampleEntityManagerFactory",
        transactionManagerRef = "sampleTransactionManager",
        basePackages = {"com.sample.api.repository"})
public class SampleDataSourceConfiguration {

    @Primary
    @Bean(name = "sampleDataSourceProperties")
    @ConfigurationProperties("spring.multi-datasource.sample")
    public DataSourceProperties sampleDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "sampleDataSource")
    @ConfigurationProperties("spring.multi-datasource.sample.configuration")
    public DataSource sampleDataSource(@Qualifier("sampleDataSourceProperties") DataSourceProperties sampleDataSourceProperties) {
        return sampleDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "sampleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sampleEntityManagerFactory(
            EntityManagerFactoryBuilder sampleEntityManagerFactoryBuilder, @Qualifier("sampleDataSource") DataSource sampleDataSource) {

        Map<String, String> sampleJpaProperties = new HashMap<>();
        sampleJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        sampleJpaProperties.put("hibernate.hbm2ddl.auto", "update");

        return sampleEntityManagerFactoryBuilder
                .dataSource(sampleDataSource)
                .packages("com.sample.api.model")
                .persistenceUnit("sampleDataSource")
                .properties(sampleJpaProperties)
                .build();
    }

    @Primary
    @Bean(name = "sampleTransactionManager")
    public PlatformTransactionManager sampleTransactionManager(
            @Qualifier("sampleEntityManagerFactory") EntityManagerFactory sampleEntityManagerFactory) {

        return new JpaTransactionManager(sampleEntityManagerFactory);
    }
}
