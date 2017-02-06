package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoFactory;
import com.pibox.data.dto.ToFile;
import com.pibox.data.dto.ToRepository;
import com.pibox.data.dto.ToUser;
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

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Marcin Żuralski on 04.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {PiDataConfigDev.class, PiDataConfigProd.class})
@ActiveProfiles("dev")
public class MongoDaoFileTest {

    @Autowired
    IDaoFactory daoFactory;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Test for creating a repository
     */
    @Test
    public void testInsert() {
        ToUser owner = new ToUser();
        owner.setName("Test");
        owner.setEmail("testOwner@email.com");
        owner.setSurname("Owner");

        ToRepository repositorySource = new ToRepository();
        repositorySource.setDateCreated(new Date());
        repositorySource.setRepositoryName("repositoryName");
        repositorySource.setOwner(owner);

        ToFile fileSource = new ToFile();
        fileSource.setName("File1.txt");
        fileSource.setDateCreated(new Date());
        fileSource.setOwner(owner);
        fileSource.setSize(1234);
        fileSource.setParent(null);

        daoFactory.getDaoFile().insert(fileSource);
        assertNotNull(fileSource.getId());

        ToFile fileTarget = daoFactory.getDaoFile().findById(fileSource.getId());
        assertEquals(fileSource, fileTarget);

        daoFactory.getDaoFile().delete(fileSource);
        ToFile deleted = daoFactory.getDaoFile().findById(fileSource.getId());
        assertNull(deleted);
    }

    @Test
    public void testFindById() {
        ToFile repository = daoFactory.getDaoFile().findById("-1");
        assertNull(repository);
    }

    @Test
    public void testRemoveRepository() {
        ToFile fileSource = new ToFile();
        fileSource.setName("File1.txt");
        fileSource.setDateCreated(new Date());
        fileSource.setSize(1234);
        fileSource.setParent(null);

        daoFactory.getDaoFile().insert(fileSource);
        assertNotNull(fileSource.getId());

        daoFactory.getDaoFile().delete(fileSource);
        ToFile file = daoFactory.getDaoFile().findById(fileSource.getId());
        assertNull(file);
    }
}