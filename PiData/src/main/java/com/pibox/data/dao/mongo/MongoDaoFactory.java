package com.pibox.data.dao.mongo;

import com.pibox.data.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Marcin Żuralski on 22.09.2016.
 */
@Component
public class MongoDaoFactory implements IDaoFactory {

    @Autowired
    private IDaoRepository daoRepository;

    @Autowired
    private IDaoUser daoUser;

    @Autowired
    private IDaoFile daoFile;

    @Autowired
    private IDaoDirectory daoDirectory;

    /**
     * @return implementation of IDaoRepository interface
     * @see IDaoRepository
     */
    @Override
    public IDaoRepository getDaoRepository() {
        return daoRepository;
    }

    /**
     * @return implementation of IDaoUser interface
     * @see IDaoUser
     */
    @Override
    public IDaoUser getDaoUser() {
        return daoUser;
    }

    /**
     * @return implementation of IDaoFile interface
     * @see IDaoFile
     */
    @Override
    public IDaoFile getDaoFile() {
        return daoFile;
    }

    /**
     * @return implementation of IDaoDirectory interface
     * @see IDaoFile
     */
    @Override
    public IDaoDirectory getDaoDirectory() {
        return daoDirectory;
    }
}