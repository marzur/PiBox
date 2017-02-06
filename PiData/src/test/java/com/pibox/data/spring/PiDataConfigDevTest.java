package com.pibox.data.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Marcin Żuralski on 12.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {PiDataConfigDev.class, PiDataConfigProd.class})
@ActiveProfiles("dev")
public class PiDataConfigDevTest {

    @Autowired
    MongoClientFactoryBean mongo;

    @Autowired
    MongoOperations mongoTemplate;

    @Test
    public void mongo() {
        assertNotNull(mongo);
    }

    @Test
    public void mongoTemplate() {
        assertNotNull(mongoTemplate);
    }
}