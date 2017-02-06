package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoFactory;
import com.pibox.data.dto.ToUser;
import com.pibox.data.spring.PiDataConfigDev;
import com.pibox.data.spring.PiDataConfigProd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

/**
 * Created by Marcin Żuralski on 12.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {PiDataConfigDev.class, PiDataConfigProd.class})
@ActiveProfiles("dev")
public class MongoDaoUserTest {

    @Autowired
    IDaoFactory daoFactory;

    /**
     * Test for creating a repository
     */
    @Test
    public void testInsert() {
        ToUser userSource = new ToUser();
        userSource.setName("Test");
        userSource.setEmail("testOwner@email.com");
        userSource.setSurname("Owner");

        daoFactory.getDaoUser().insert(userSource);
        assertNotNull(userSource.getId());

        ToUser userTarget = daoFactory.getDaoUser().findById(userSource.getId());
        assertEquals(userSource, userTarget);

        daoFactory.getDaoUser().delete(userSource);
        ToUser deleted = daoFactory.getDaoUser().findById(userSource.getId());
        assertNull(deleted);
    }

    @Test
    public void testFindById() {
        ToUser repository = daoFactory.getDaoUser().findById("-1");
        assertNull(repository);
    }

    @Test
    public void testRemoveRepository() {
        ToUser user = new ToUser();
        user.setName("Test");
        user.setEmail("testOwner@email.com");

        daoFactory.getDaoUser().insert(user);
        assertNotNull(user.getId());

        daoFactory.getDaoUser().delete(user);
        ToUser repository = daoFactory.getDaoUser().findById(user.getId());
        assertNull(repository);
    }
}