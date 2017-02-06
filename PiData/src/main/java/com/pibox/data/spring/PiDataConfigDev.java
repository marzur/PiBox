package com.pibox.data.spring;

import com.mongodb.Mongo;
import com.pibox.data.dao.mongo.MongoYamlConf;
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
public class PiDataConfigDev implements PiDataConfig {

    /**
     * Main directory of PiBoxLeaf application
     */
    private static final String SYSTEM_PROPERTY_PiBoxLeaf = "PiBoxLeaf";

    /**
     * Mongod directory
     */
    private static final String MONGOD = "mongodb";

    /**
     * Mongod config file
     */
    private static final String MONGOD_CONF = "conf/mongod.conf";

    /**
     * Mongo db name
     */
    private static final String MONGO_DB_NAME = "leaf";

    /**
     * Load mongodb config file to Yaml object
     *
     * @return
     * @throws FileNotFoundException
     */
    private MongoYamlConf mongoConf() throws IOException {
        Yaml yaml = new Yaml();
        try (FileInputStream inputStream = new FileInputStream(new File(mongodPath().toString() + File.separator + MONGOD_CONF))) {
            Map<String, Object> load = (Map<String, Object>) yaml.load(inputStream);
            String netBindIp = null;
            int netPort = 0;

            if (load.containsKey("net")) {
                Map<String, Object> netYaml = (Map<String, Object>) load.get("net");
                if (netYaml.containsKey("bindIp")) {
                    netBindIp = (String) netYaml.get("bindIp");
                }
                if (netYaml.containsKey("port")) {
                    netPort = (int) netYaml.get("port");
                }

                return new MongoYamlConf(netBindIp, netPort);
            }
        }
        return null;
    }

    /**
     * @return
     */
    private Path mongodPath() {
        String pathToLeaf = "/Users/Marcin/PiBoxLeaf";
        return new File(pathToLeaf + File.separator + MONGOD).toPath();
    }

    /**
     * Create MongoClientFactoryBean using YAML configuration
     *
     * @return
     */
    @Bean(name = "mongo")
    public MongoClientFactoryBean mongo() throws IOException {
        MongoYamlConf mongoYamlConf = mongoConf();
        if (mongoYamlConf == null) {
            mongoYamlConf = new MongoYamlConf("localhost", 12345);
        }

        MongoClientFactoryBean clientFactoryBean = new MongoClientFactoryBean();
        clientFactoryBean.setHost(mongoYamlConf.getNetBindIp());
        clientFactoryBean.setPort(mongoYamlConf.getNetPort());
        return clientFactoryBean;
    }

    @Bean
    public MongoOperations mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, MONGO_DB_NAME);
    }
}