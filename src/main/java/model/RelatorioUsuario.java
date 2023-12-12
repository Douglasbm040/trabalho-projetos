/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author isaac
 */
public class RelatorioUsuario {
    private int idUser;
    private String name;
    private String registerDate;
    private int qtdNotificacoesEnviadas;
    private int qtdNotificacoesLidas;

    public RelatorioUsuario(int idUser, String name, String registerDate, int qtdNotificacoesEnviadas, int qtdNotificacoesLidas) {
        this.idUser = idUser;
        this.name = name;
        this.registerDate = registerDate;
        this.qtdNotificacoesEnviadas = qtdNotificacoesEnviadas;
        this.qtdNotificacoesLidas = qtdNotificacoesLidas;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public int getQtdNotificacoesEnviadas() {
        return qtdNotificacoesEnviadas;
    }

    public int getQtdNotificacoesLidas() {
        return qtdNotificacoesLidas;
    }
    
    
}
