package com.pibox.core.repository.to;

/**
 * Created by Marcin on 11.08.2016.
 */
public class PiCUser {
    private String email;
    private String userName;
    private String userPassword;
    private String userContainer;
    private String userMainDir;

    public PiCUser(String userName, String userContainer) {
        this.userName = userName;
        this.userContainer = userContainer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserContainer() {
        return userContainer;
    }

    public void setUserContainer(String userContainer) {
        this.userContainer = userContainer;
    }

    public String getUserMainDir() {
        return userMainDir;
    }

    public void setUserMainDir(String userMainDir) {
        this.userMainDir = userMainDir;
    }

    public static void main(String[] args) {

    }
}