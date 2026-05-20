/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nicolasryan
 */
public class Main extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

    public Main() {
        // Configurações da janela
        setTitle("Painel Kanban"); // Titulo da aba
        setSize(1000, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centraliza na tela
        setLayout(new BorderLayout(10, 10)); // Layout principal
        initComponents();  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        painelColunas = new javax.swing.JPanel();
        painelAF = new javax.swing.JPanel();
        painelAFTopo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        painelScrollAF = new javax.swing.JScrollPane();
        painelNotasAF = new javax.swing.JPanel();
        painelSF = new javax.swing.JPanel();
        painelSFTopo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        painelSFScroll = new javax.swing.JScrollPane();
        painelSFNotas = new javax.swing.JPanel();
        painelC = new javax.swing.JPanel();
        painelCTopo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        painelCScroll = new javax.swing.JScrollPane();
        painelCNotas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        jLabel1.setText("Seja Bem-Vindo, Nícolas");

        jLabel2.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 17)); // NOI18N
        jLabel2.setText("Suas Tarefas: 0");

        jLabel3.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 17)); // NOI18N
        jLabel3.setText("Tarefas Totais: 0");

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelColunas.setLayout(new java.awt.GridLayout(1, 0));

        painelAF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelAF.setLayout(new java.awt.BorderLayout());

        painelAFTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        jLabel4.setText("A FAZER");

        javax.swing.GroupLayout painelAFTopoLayout = new javax.swing.GroupLayout(painelAFTopo);
        painelAFTopo.setLayout(painelAFTopoLayout);
        painelAFTopoLayout.setHorizontalGroup(
            painelAFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAFTopoLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        painelAFTopoLayout.setVerticalGroup(
            painelAFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAFTopoLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        painelAF.add(painelAFTopo, java.awt.BorderLayout.PAGE_START);

        painelScrollAF.setBorder(null);
        painelScrollAF.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelScrollAF.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelNotasAF.setLayout(new java.awt.GridLayout(0, 1));
        painelScrollAF.setViewportView(painelNotasAF);

        painelAF.add(painelScrollAF, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelAF);

        painelSF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelSF.setLayout(new java.awt.BorderLayout());

        painelSFTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        jLabel5.setText("SENDO FEITO");

        javax.swing.GroupLayout painelSFTopoLayout = new javax.swing.GroupLayout(painelSFTopo);
        painelSFTopo.setLayout(painelSFTopoLayout);
        painelSFTopoLayout.setHorizontalGroup(
            painelSFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSFTopoLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        painelSFTopoLayout.setVerticalGroup(
            painelSFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSFTopoLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        painelSF.add(painelSFTopo, java.awt.BorderLayout.PAGE_START);

        painelSFScroll.setBorder(null);

        painelSFNotas.setLayout(new java.awt.GridLayout(0, 1));
        painelSFScroll.setViewportView(painelSFNotas);

        painelSF.add(painelSFScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelSF);

        painelC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelC.setLayout(new java.awt.BorderLayout());

        painelCTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        jLabel6.setText("CONCLUÍDO");

        javax.swing.GroupLayout painelCTopoLayout = new javax.swing.GroupLayout(painelCTopo);
        painelCTopo.setLayout(painelCTopoLayout);
        painelCTopoLayout.setHorizontalGroup(
            painelCTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCTopoLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        painelCTopoLayout.setVerticalGroup(
            painelCTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCTopoLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        painelC.add(painelCTopo, java.awt.BorderLayout.PAGE_START);

        painelCScroll.setBorder(null);
        painelCScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelCScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout painelCNotasLayout = new javax.swing.GroupLayout(painelCNotas);
        painelCNotas.setLayout(painelCNotasLayout);
        painelCNotasLayout.setHorizontalGroup(
            painelCNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        painelCNotasLayout.setVerticalGroup(
            painelCNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        painelCScroll.setViewportView(painelCNotas);

        painelC.add(painelCScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelC);

        getContentPane().add(painelColunas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel painelAF;
    private javax.swing.JPanel painelAFTopo;
    private javax.swing.JPanel painelC;
    private javax.swing.JPanel painelCNotas;
    private javax.swing.JScrollPane painelCScroll;
    private javax.swing.JPanel painelCTopo;
    private javax.swing.JPanel painelColunas;
    private javax.swing.JPanel painelNotasAF;
    private javax.swing.JPanel painelSF;
    private javax.swing.JPanel painelSFNotas;
    private javax.swing.JScrollPane painelSFScroll;
    private javax.swing.JPanel painelSFTopo;
    private javax.swing.JScrollPane painelScrollAF;
    private javax.swing.JPanel painelTopo;
    // End of variables declaration//GEN-END:variables

    
}
