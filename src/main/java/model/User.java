/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dougl
 */
public class User {
    private String name;
    private String token_access;
    private int tag_access;

    public User(String name, String token_access, int tag_access) {
        this.name = name;
        this.token_access = token_access;
        this.tag_access = tag_access;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken_access() {
        return token_access;
    }

    public void setToken_access(String token_access) {
        this.token_access = token_access;
    }

    public int getTag_access() {
        return tag_access;
    }

    public void setTag_access(int tag_access) {
        this.tag_access = tag_access;
    }

    
}
