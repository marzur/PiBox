package com.pibox.data.dto;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by Marcin Żuralski on 15.08.2016.
 */
public class ToRepository {

    /**
     *
     */
    @Id
    private String id;

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

    /**
     * List of replicas (addresses)
     */
    private List<ToReplica> replicaList;

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

    public List<ToReplica> getReplicaList() {
        return replicaList;
    }

    public ToRepository setReplicaList(List<ToReplica> replicaList) {
        this.replicaList = replicaList;
        return this;
    }

    @Override
    public String toString() {
        return "ToRepository{" +
                "id='" + id + '\'' +
                ", mainDir=" + mainDir +
                ", repositoryName='" + repositoryName + '\'' +
                ", owner=" + owner +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
