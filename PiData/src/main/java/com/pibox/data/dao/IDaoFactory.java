package com.pibox.data.dao;

/**
 * Created by Marcin Żuralski on 22.09.2016.
 */
public interface IDaoFactory {

    /**
     * Return the instance of daoRepository
     *
     * @return
     */
    public IDaoRepository getDaoRepository();

    /**
     * Returns the instance of daoUser
     *
     * @return
     */
    public IDaoUser getDaoUser();

    /**
     * Returns the instance of daoFile
     *
     * @return
     */
    public IDaoFile getDaoFile();

    /**
     * Returns the instance of daoDirectory
     *
     * @return
     */
    public IDaoDirectory getDaoDirectory();
}
