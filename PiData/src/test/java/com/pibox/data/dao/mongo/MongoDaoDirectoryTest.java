package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoFactory;
import com.pibox.data.dto.ToDirectory;
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
public class MongoDaoDirectoryTest {

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

        ToDirectory directorySource = new ToDirectory();
        directorySource.setName("File1.txt");
        directorySource.setDateCreated(new Date());
        directorySource.setOwner(owner);
        directorySource.setSize(1234);
        directorySource.setParent(null);

        daoFactory.getDaoDirectory().insert(directorySource);
        assertNotNull(directorySource.getId());

        ToDirectory directoryTarget = daoFactory.getDaoDirectory().findById(directorySource.getId());
        assertEquals(directorySource, directoryTarget);

        daoFactory.getDaoDirectory().delete(directorySource);
        ToFile deleted = daoFactory.getDaoDirectory().findById(directorySource.getId());
        assertNull(deleted);
    }

    @Test
    public void testFindById() {
        ToDirectory repository = daoFactory.getDaoDirectory().findById("-1");
        assertNull(repository);
    }

    @Test
    public void testRemoveRepository() {
        ToDirectory directorySource = new ToDirectory();
        directorySource.setName("File1.txt");
        directorySource.setDateCreated(new Date());
        directorySource.setSize(1234);
        directorySource.setParent(null);

        daoFactory.getDaoDirectory().insert(directorySource);
        assertNotNull(directorySource.getId());

        daoFactory.getDaoDirectory().delete(directorySource);
        ToDirectory directory = daoFactory.getDaoDirectory().findById(directorySource.getId());
        assertNull(directory);
    }
}