package com.pibox.data.spring;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Marcin Żuralski on 16.09.2016.
 * <p>
 * Spring configuration for the production environment
 */
@Configuration
@Profile("prod")
@ComponentScan(basePackages = "com.pibox.data")
@EnableMongoRepositories(basePackages = "com.pibox.data")
public class PiDataConfigProd implements PiDataConfig {

    @Bean
    public MongoClientFactoryBean mongo() {
        MongoClientFactoryBean clientFactoryBean = new MongoClientFactoryBean();
        clientFactoryBean.setHost("localhost");
        clientFactoryBean.setPort(12345);
        return clientFactoryBean;
    }

    @Bean
    public MongoOperations mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "cos");
    }
}
