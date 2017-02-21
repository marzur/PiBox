package com.pibox.core.repository.macos;

import com.pibox.core.repository.IRepositoryFactory;
import com.pibox.core.repository.IRepositoryManager;
import com.pibox.data.dto.ToRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Marcin on 26.07.2016.
 */
public class MacOsRepositoryManager implements IRepositoryManager {

    @Autowired
    private IRepositoryFactory repositoryFactory;

    @Override
    public void createRespository(ToRepository repository) {

    }

    @Override
    public void removeRepository(ToRepository repository) {

    }

    @Override
    public void getRepository(ToRepository repository) {

    }

    @Override
    public boolean repositoryExists(ToRepository repository) {
        return false;
    }
}