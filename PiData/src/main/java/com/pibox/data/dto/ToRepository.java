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
     * Repository version
     */
    private ToRepository repositoryVersion;

    /**
     * Main directory
     */
    private ToDirectory mainDir;

    /**
     * Repository name
     */
    private String repositoryName;

    /**
     * Repository owner
     */
    private ToUser owner;

    /**
     * Repository date created
     */
    private Date dateCreated;

    /**
     * List of replicas (addresses)
     */
    private List<ToReplica> replicaList;


    public String getId() {
        return id;
    }

    public ToRepository setId(String id) {
        this.id = id;
        return this;
    }

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

    public ToRepository getRepositoryVersion() {
        return repositoryVersion;
    }

    public ToRepository setRepositoryVersion(ToRepository repositoryVersion) {
        this.repositoryVersion = repositoryVersion;
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
                ", repositoryVersion=" + repositoryVersion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToRepository that = (ToRepository) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!owner.equals(that.owner)) return false;
        return dateCreated.equals(that.dateCreated);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + owner.hashCode();
        result = 31 * result + dateCreated.hashCode();
        return result;
    }
}