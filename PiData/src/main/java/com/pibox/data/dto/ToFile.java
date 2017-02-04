package com.pibox.data.dto;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Marcin Żuralski on 31.08.2016.
 * <p>
 * A class represents a simple file stored at the local file system.
 */
public class ToFile {

    @Id
    private String id;

    /**
     * File name
     */
    private String name;

    /**
     * Parent directory
     */
    private ToDirectory parent;

    /**
     * Time when the file was modified recently.
     */
    private Date dateModified;

    /**
     * Time when the file was created.
     */
    private Date dateCreated;

    /**
     *
     */
    private ToUser owner;

    /**
     * Digest of file
     */
    private byte[] digest;

    /**
     * The size of file
     */
    private long size;

    public String getId() {
        return id;
    }

    public ToFile setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ToFile setName(String name) {
        this.name = name;
        return this;
    }

    public ToDirectory getParent() {
        return parent;
    }

    public ToFile setParent(ToDirectory parent) {
        this.parent = parent;
        return this;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public ToFile setDateModified(Date dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public ToFile setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public ToUser getOwner() {
        return owner;
    }

    public ToFile setOwner(ToUser owner) {
        this.owner = owner;
        return this;
    }

    public byte[] getDigest() {
        return digest;
    }

    public ToFile setDigest(byte[] digest) {
        this.digest = digest;
        return this;
    }

    public long getSize() {
        return size;
    }

    public ToFile setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToFile)) return false;

        ToFile toFile = (ToFile) o;

        if (!name.equals(toFile.name)) return false;
        if (parent != null ? !parent.equals(toFile.parent) : toFile.parent != null) return false;
        return dateCreated.equals(toFile.dateCreated);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + dateCreated.hashCode();
        return result;
    }
}