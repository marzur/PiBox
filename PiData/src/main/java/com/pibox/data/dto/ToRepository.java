package com.pibox.data.dto;

import java.util.Date;

/**
 * Created by Marcin Żuralski on 15.08.2016.
 */
public class ToRepository {
    /**
     * Main directory
     */
    private ToDirectory mainDir;

    /**
     *
     */
    private String repositoryName;

    /**
     *
     */
    private ToUser owner;

    /**
     *
     */
    private Date dateCreated;

    public ToDirectory getMainDir() {
        return mainDir;
    }

    public ToRepository setMainDir(ToDirectory mainDir) {
        this.mainDir = mainDir;
        return this;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public ToRepository setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
        return this;
    }

    public ToUser getOwner() {
        return owner;
    }

    public ToRepository setOwner(ToUser owner) {
        this.owner = owner;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public ToRepository setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
}
