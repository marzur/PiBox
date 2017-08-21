package com.pibox.core.repository.macos;

import com.pibox.core.repository.IRepositoryFactory;
import com.pibox.core.repository.IRepositoryManager;
import com.pibox.core.spring.PiCoreConfigDev;
import com.pibox.data.dto.ToDirectory;
import com.pibox.data.dto.ToRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Marcin on 26.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {PiCoreConfigDev.class})
@ActiveProfiles("dev")
public class MacOsRepositoryTest {

    @Autowired
    IRepositoryFactory repositoryFactory;

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void createEmptyRepositoryTest() {
        assertNotNull(repositoryFactory);

        ToDirectory mainDir = new ToDirectory();
        mainDir.setName("testRepository");

        ToRepository repository = new ToRepository();
        repository.setMainDir(mainDir);

        MacOsRepositoryManager repositoryManager = (MacOsRepositoryManager) repositoryFactory.getRepositoryManager();
        assertNotNull(repositoryManager.getRepositoryFactory());
        assertEquals(repositoryManager.getRepositoryFactory(), repositoryFactory);

        repositoryManager.createRespository(repository);
        repository.getMainDir();








//        PiCReposistory repository = new PiCReposistory();

//        IRepositoryManager macOsRepository = new MacOsRepositoryManager();
//        macOsRepository.createRespository(repository);


//        InputStream configStream = new FileInputStream(new File("pibox.config"));
//        RepositoryConfig config = new RepositoryConfig(configStream);
//        RepositoryContext context = config.createContext();
//        Session session = context.createSession(DaneLogowania);
//        session.getDaoRepository().createRepository(RepositoryTo);


    }

}