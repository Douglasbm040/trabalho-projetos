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
    private String tokenAccess;
    private int tagAccess;
    private int id;
    private String registerDate;
    
    public User(String name, String tokenAccess, int tagAccess,int id, String registerDate) {
        this.name = name;
        this.tokenAccess = tokenAccess;
        this.tagAccess = tagAccess;
        this.id = id;
        this.registerDate = registerDate;
    }

    public User(String name, String tokenAccess, int tagAccess, String registerDate) {
        this.name = name;
        this.tokenAccess = tokenAccess;
        this.tagAccess = tagAccess;
        this.registerDate = registerDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTokenAccess() {
        return tokenAccess;
    }

    public void setTokenAccess(String tokenAccess) {
        this.tokenAccess = tokenAccess;
    }

    public int getTagAccess() {
        return tagAccess;
    }

    public void setTagAccess(int tagAccess) {
        this.tagAccess = tagAccess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    
}
