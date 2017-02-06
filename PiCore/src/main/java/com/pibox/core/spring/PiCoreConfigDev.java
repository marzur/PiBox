package com.pibox.core.spring;

import com.mongodb.Mongo;
import com.pibox.data.dao.mongo.MongoYamlConf;
import com.pibox.data.spring.PiDataConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by Marcin Żuralski on 16.09.2016.
 * <p>
 * Spring configuration for the development environment
 */
@Configuration
@Profile("dev")
@ComponentScan(basePackages = "com.pibox.data")
@EnableMongoRepositories(basePackages = "com.pibox.data")
public class PiCoreConfigDev implements PiDataConfig {

    /**
     * Main directory of PiBoxLeaf application
     */
    private static final String SYSTEM_PROPERTY_PiBoxLeaf = "PiBoxLeaf";

    /**
     * Config's directory
     */
    private static final String CONFIG_DIR = "config";

    /**
     * PiCore config file
     */
    private static final String CONFIG = "com.picode.piboxleaf.core.yaml";


}