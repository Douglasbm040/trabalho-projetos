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
    private int idReceptor;

    public Notification(String content, String dataEnvio, int idReceptor) {
        this.content = content;
        this.dataNotification = dataEnvio;
        this.idReceptor = idReceptor;
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



    

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
   
    
}
