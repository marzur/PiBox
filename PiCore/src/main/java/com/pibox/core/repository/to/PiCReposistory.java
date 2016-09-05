package com.pibox.core.repository.to;

import java.util.Date;

/**
 * Created by Marcin  on 10.08.2016.
 */
public class PiCReposistory {
    /**
     * Id repository
     */
    private String id;
    /**
     * Repository name
     */
    private String name;
    /**
     * Date of
     */
    private Date createDate;
    /**
     * Repository last modified
     */
    private Date lastModified;
    /**
     *
     */
    private long quota;
    /**
     * Repository owner
     */
    private PiCUser owner;
    /**
     * Main directory
     */
    private PiCDirectory mainDirectory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
