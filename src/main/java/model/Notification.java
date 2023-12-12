/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dougl
 */
public class Notification {
    private String content;
    private String dataNotification;
    private int idSender;
    private int idReceptor;
    private int isRead;
    private int idNotification;
    
     public Notification(String content, String dataEnvio, int idSender, int idReceptor, int isRead) {
        this.content = content;
        this.dataNotification = dataEnvio;
        this.idSender = idSender;
        this.idReceptor = idReceptor;
        this.isRead = isRead;
    }

    public Notification(String content, String dataEnvio, int idSender, int idReceptor, int isRead,int idNotification) {
        this.content = content;
        this.dataNotification = dataEnvio;
        this.idSender = idSender;
        this.idReceptor = idReceptor;
        this.isRead = isRead;
        this.idNotification =idNotification;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }
    
    

    public String getDataEnvio() {
        return dataNotification;
    }

    public void setDataEnvio(String dataEnvio) {
        this.dataNotification = dataEnvio;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
    }

    public String getDataNotification() {
        return dataNotification;
    }

    public int getIdSender() {
        return idSender;
    }

    public int getIsRead() {
        return isRead;
    }



    

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
   
    
}
