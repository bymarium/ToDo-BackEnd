package com.example.task.appTask.dto.user;

public abstract class UserDto {
    private long document;
    private String userName;
    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(long document, String userName, String email, String password) {
        this.document = document;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
