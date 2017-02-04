package com.pibox.data.dto;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Marcin Żuralski on 31.08.2016.
 */
public class ToUser {

    /**
     * An unigue id of user
     */
    @Id
    private String id;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String surname;

    /**
     * List of repositories
     */
    private List<ToRepository> repositories;

    public String getId() {
        return id;
    }

    public ToUser setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ToUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public ToUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ToUser setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToUser)) return false;

        ToUser toUser = (ToUser) o;

        if (id != null ? !id.equals(toUser.id) : toUser.id != null) return false;
        return email.equals(toUser.email);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + email.hashCode();
        return result;
    }
}