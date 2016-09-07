package com.pibox.data.dao;

import com.pibox.data.dto.ToRepository;

/**
 * Created by Marcin Żuralski on 02.09.2016.
 */
public interface IDaoRepository {

    /**
     * Insert repository to db
     * @param repository
     * @return
     */
    Long insert(ToRepository repository);

    /**
     *
     * @param repository
     */
    void update(ToRepository repository);

    /**
     *
     * @param repository
     */
    void delete(ToRepository repository);
}