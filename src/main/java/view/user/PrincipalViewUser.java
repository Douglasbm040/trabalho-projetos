/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author isaac
 */
public class PrincipalViewUser extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public PrincipalViewUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dkstpPrincipal = new javax.swing.JDesktopPane();
        pnlRodape = new javax.swing.JPanel();
        lblUsuarioRodape = new javax.swing.JLabel();
        lblTipoUsuarioRodape = new javax.swing.JLabel();
        btnNotificacao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOpcoes = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Usuario");
        setExtendedState(MAXIMIZED_BOTH);

        dkstpPrincipal.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout dkstpPrincipalLayout = new javax.swing.GroupLayout(dkstpPrincipal);
        dkstpPrincipal.setLayout(dkstpPrincipalLayout);
        dkstpPrincipalLayout.setHorizontalGroup(
            dkstpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        dkstpPrincipalLayout.setVerticalGroup(
            dkstpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        lblUsuarioRodape.setText("Usuário:");

        lblTipoUsuarioRodape.setText("Tipo:");

        btnNotificacao.setText("Notificações: 0");
        btnNotificacao.setBorderPainted(false);
        btnNotificacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotificacao.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        btnNotificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRodapeLayout = new javax.swing.GroupLayout(pnlRodape);
        pnlRodape.setLayout(pnlRodapeLayout);
        pnlRodapeLayout.setHorizontalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoUsuarioRodape)
                    .addComponent(lblUsuarioRodape))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                .addComponent(btnNotificacao)
                .addGap(28, 28, 28))
        );
        pnlRodapeLayout.setVerticalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNotificacao)
                    .addGroup(pnlRodapeLayout.createSequentialGroup()
                        .addComponent(lblUsuarioRodape)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoUsuarioRodape)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        menuOpcoes.setText("Opções");

        menuUsuario.setText("Usuario");
        menuOpcoes.add(menuUsuario);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuSair);

        jMenuBar1.add(menuOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkstpPrincipal)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dkstpPrincipal)
                .addGap(73, 73, 73))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 316, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSairActionPerformed

    private void btnNotificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNotificacaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNotificacao;
    private javax.swing.JDesktopPane dkstpPrincipal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblTipoUsuarioRodape;
    private javax.swing.JLabel lblUsuarioRodape;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuUsuario;
    private javax.swing.JPanel pnlRodape;
    // End of variables declaration//GEN-END:variables
    
    
    public JMenuItem getMenuSair() {
        return menuSair;
    }

    public JDesktopPane getDkstpPrincipal() {
        return dkstpPrincipal;
    }

    public JButton getBtnNotificacao() {
        return btnNotificacao;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public JLabel getLblTipoUsuarioRodape() {
        return lblTipoUsuarioRodape;
    }

    public JLabel getLblUsuarioRodape() {
        return lblUsuarioRodape;
    }

    public JMenuItem getMenuEditar() {
        return menuUsuario;
    }

    public JMenu getMenuOpcoes() {
        return menuOpcoes;
    }

    public JPanel getPnlRodape() {
        return pnlRodape;
    }

    public JMenuItem getMenuUsuario() {
        return menuUsuario;
    }
    
    
    
}
