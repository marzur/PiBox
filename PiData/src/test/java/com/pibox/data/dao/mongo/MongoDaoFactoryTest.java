package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoFactory;
import com.pibox.data.spring.PiDataConfigDev;
import com.pibox.data.spring.PiDataConfigProd;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marcin Żuralski on 12.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {PiDataConfigDev.class, PiDataConfigProd.class})
@ActiveProfiles("dev")
public class MongoDaoFactoryTest {

    @Autowired
    IDaoFactory daoFactory;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void initTest() {
        assertTrue(daoFactory instanceof MongoDaoFactory);
    }

    @Test
    public void getDaoRepository() throws Exception {
        assertNotNull(daoFactory.getDaoRepository());
    }

    @Test
    public void getDaoUser() throws Exception {
        assertNotNull(daoFactory.getDaoUser());
    }
}