package com.pibox.core.repository.macos;

import com.pibox.core.repository.IRepositoryManager;
import com.pibox.data.dto.ToDirectory;
import com.pibox.data.dto.ToRepository;
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
        ToDirectory mainDir = new ToDirectory();
        mainDir.setName("testRepository");

        ToRepository repository = new ToRepository();
        repository.setMainDir(mainDir);


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