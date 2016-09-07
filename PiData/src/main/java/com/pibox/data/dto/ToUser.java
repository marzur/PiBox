package com.pibox.data.dto;

import java.util.List;

/**
 * Created by Marcin Żuralski on 31.08.2016.
 */
public class ToUser {

    /**
     * An unigue id of user
     */
    private Long id;

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

    public Long getId() {
        return id;
    }

    public ToUser setId(Long id) {
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
}