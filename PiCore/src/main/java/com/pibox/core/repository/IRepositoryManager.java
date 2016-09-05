package com.pibox.core.repository;

import com.pibox.core.repository.to.PiCReposistory;

/**
 * Created by Marcin Żuralski on 10.08.2016.
 * <p>
 * An interface contains methods to managing a simple repository installed on a remote machine (eq. at RaspberyPi).
 */
public interface IRepositoryManager {

    /**
     * Method to create a simple repository
     *
     * @param repository
     */
    void createRespository(PiCReposistory repository);
}
