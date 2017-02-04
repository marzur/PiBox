package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoFactory;
import com.pibox.data.dao.IDaoRepository;
import com.pibox.data.dto.ToDirectory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by Marcin Żuralski on 02.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {PiDataConfigDev.class, PiDataConfigProd.class})
@ActiveProfiles("dev")
public class MongoDaoRepositoryTest {

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

        ToDirectory mainDir = new ToDirectory();
        mainDir.setDateCreated(new Date());
        mainDir.setName("OwnerDir");

        daoFactory.getDaoRepository().insert(repositorySource);
        assertNotNull(repositorySource.getId());

        ToRepository repositoryTarget = daoFactory.getDaoRepository().findById(repositorySource.getId());
        assertEquals(repositorySource, repositoryTarget);

        daoFactory.getDaoRepository().delete(repositorySource);
        ToRepository deleted = daoFactory.getDaoRepository().findById(repositorySource.getId());
        assertNull(deleted);
    }

    @Test
    public void testFindById() {
        ToRepository repository = daoFactory.getDaoRepository().findById("-1");
        assertNull(repository);
    }

    @Test
    public void testRemoveRepository() {
        ToRepository repositorySource = new ToRepository();
        repositorySource.setDateCreated(new Date());
        repositorySource.setRepositoryName("repositoryName");

        daoFactory.getDaoRepository().insert(repositorySource);
        assertNotNull(repositorySource.getId());

        daoFactory.getDaoRepository().delete(repositorySource);
        ToRepository repository = daoFactory.getDaoRepository().findById(repositorySource.getId());
        assertNull(repository);
    }
}