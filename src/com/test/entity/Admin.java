package com.test.entity;

/**
 * @author chuqi
 * @description: 管理员
 * @create 2021-06-25 上午11:23
 */
public class Admin {

    private int    id;
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Admin() {
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }

}