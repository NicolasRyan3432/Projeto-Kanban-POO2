/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Modelo;

/**
 *
 * @author nicolasryan
 */
public class CartaoNota extends javax.swing.JPanel {
    public CartaoNota(String titulo, String autor, String prazo, String prioridade) {
        initComponents();
        
        // Parte onde que a nota recebe os seus valores reais
        txtTitulo.setText(titulo);
        txtAutor.setText("Autor: " + autor);
        txtPrazo.setText("Prazo: " + prazo);
        
        /*  
            Aqui separei em dois labels, um é do texto "Prioridade" 
            e o outro que é realmente a prioridade que vem do banco
        */ 
        
        varPrioridade.setText(prioridade);
        
        // Troca a cor do texto dependendo da prioridade dele
        // As setinhas substituem a antiga notação do switch (case coisa: coisa aqui dentro; break;)
        switch(prioridade) {
            case "Alta" -> varPrioridade.setForeground(java.awt.Color.RED);
            case "Média" -> varPrioridade.setForeground(java.awt.Color.ORANGE);
            case "Baixa" -> varPrioridade.setForeground(java.awt.Color.GREEN);
            default -> varPrioridade.setForeground(java.awt.Color.GRAY); // Caso venha alguma outra cor
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JLabel();
        txtAutor = new javax.swing.JLabel();
        varPrioridade = new javax.swing.JLabel();
        txtPrazo = new javax.swing.JLabel();
        txtPrioridade = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        txtTitulo.setBackground(new java.awt.Color(0, 0, 0));
        txtTitulo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtTitulo.setText("Fazer Almoço");

        txtAutor.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtAutor.setText("Autor: Nícolas");

        varPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        varPrioridade.setForeground(new java.awt.Color(255, 0, 51));
        varPrioridade.setText("Alta");

        txtPrazo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrazo.setText("Prazo: Hoje, até as 13:00");

        txtPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrioridade.setText("Prioridade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAutor)
                            .addComponent(txtTitulo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrazo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrioridade)
                                .addGap(18, 18, 18)
                                .addComponent(varPrioridade)))
                        .addGap(0, 86, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtTitulo)
                .addGap(18, 18, 18)
                .addComponent(txtAutor)
                .addGap(18, 18, 18)
                .addComponent(txtPrazo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varPrioridade)
                    .addComponent(txtPrioridade))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtAutor;
    private javax.swing.JLabel txtPrazo;
    private javax.swing.JLabel txtPrioridade;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel varPrioridade;
    // End of variables declaration//GEN-END:variables
}
