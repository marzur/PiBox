package com.pibox.core.repository;

import com.pibox.data.dto.ToRepository;

/**
 * Created by Marcin Żuralski on 10.08.2016.
 * <p>
 * An interface contains methods to managing a simple repository installed on a remote machine (eq. at RaspberyPi).
 */
public interface IRepositoryManager {

    /**
     * Method to create physically a simple repository
     * <p>
     * 1. Create directory
     * 2. Set up permission to this directory
     *
     * @param repository
     */
    void createRespository(ToRepository repository);

    /**
     * Physicicaly remove repository from local file system
     *
     * @param repository
     */
    void removeRepository(ToRepository repository);

    /**
     * Read respository from local file system
     *
     * @param repository
     */
    void getRepository(ToRepository repository);

    /**
     * Check if repository exists
     *
     * @param repository
     * @return
     */
    boolean repositoryExists(ToRepository repository);
}