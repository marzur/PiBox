package com.pibox.core.macos;

import com.pibox.core.repository.IRepositoryManager;
import com.pibox.core.repository.to.PiCReposistory;
import org.junit.Test;

/**
 * Created by Marcin on 26.07.2016.
 */
public class MacOsRepositoryTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void createEmptyRepositoryTest() {
        PiCReposistory repository = new PiCReposistory();

        IRepositoryManager macOsRepository = new MacOsRepositoryManager();
        macOsRepository.createRespository(repository);


//        InputStream configStream = new FileInputStream(new File("pibox.config"));
//        RepositoryConfig config = new RepositoryConfig(configStream);
//        RepositoryContext context = config.createContext();
//        Session session = context.createSession(DaneLogowania);
//        session.getDaoRepository().createRepository(RepositoryTo);


    }

}