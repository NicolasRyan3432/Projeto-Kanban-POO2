/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import Modelo.CartaoNota;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

    public Main() {
        // Configurações da janela
        setTitle("Painel Kanban"); // Titulo da aba
        setSize(1000, 1000);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centraliza na tela
        setLayout(new BorderLayout(10, 10)); // Layout principal
        
        initComponents();  //Inicia os componentes
        
        //jLabel1.setText("Seja Bem-Vindo " + user.nome);
        
        // ContentPane é o conteúdo invisível que o Swing adiciona no jFrame 
        getContentPane().setBackground(new java.awt.Color(102, 102, 102)); 
        
        // Aumenta a quantidade de pixels que a tela desce por rolagem
        painelAFScroll.getVerticalScrollBar().setUnitIncrement(20);
        painelSFScroll.getVerticalScrollBar().setUnitIncrement(20);
        painelCScroll.getVerticalScrollBar().setUnitIncrement(20);
        
        // Criando as notas só para teste
        CartaoNota nota1 = new CartaoNota("Fazer Almoço", "Nícolas", "Hoje, 13:00", "Alta");
        CartaoNota nota2 = new CartaoNota("Lavar a Louça", "Nícolas", "25/04", "Média");
        CartaoNota nota3 = new CartaoNota("Arrumar a casa", "Nícolas", "Sábado, às 2", "Baixa");
        CartaoNota nota4 = new CartaoNota("Nome Grande pra ver o que acontece", "Nícolas", "Sábado, às 2", "Baixa");
        
        // Adicionando no painel
        painelSFNotas.add(nota1);
        painelAFNotas.add(nota2);
        painelAFNotas.add(nota3);
        painelAFNotas.add(nota4);
        
        // Atualizando o painel para aparecer as notas
        painelAFNotas.revalidate();
        painelAFNotas.repaint();
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
        painelAFScroll = new javax.swing.JScrollPane();
        painelAFNotas = new javax.swing.JPanel();
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
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(1250, 950));

        painelTopo.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 230, 230));
        jLabel1.setText("Seja Bem-Vindo, Nícolas");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setText("Suas Tarefas: 0");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        jLabel3.setForeground(java.awt.Color.lightGray);
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
                .addContainerGap(524, Short.MAX_VALUE))
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

        painelColunas.setBackground(new java.awt.Color(51, 51, 51));
        painelColunas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        painelColunas.setAlignmentX(0.0F);
        painelColunas.setFocusable(false);
        painelColunas.setLayout(new java.awt.GridLayout(1, 0));

        painelAF.setBackground(new java.awt.Color(51, 51, 51));
        painelAF.setLayout(new java.awt.BorderLayout());

        painelAFTopo.setBackground(new java.awt.Color(51, 51, 51));
        painelAFTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelAFTopo.setForeground(new java.awt.Color(230, 230, 230));

        jLabel4.setBackground(new java.awt.Color(204, 255, 51));
        jLabel4.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        jLabel4.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("A FAZER");

        javax.swing.GroupLayout painelAFTopoLayout = new javax.swing.GroupLayout(painelAFTopo);
        painelAFTopo.setLayout(painelAFTopoLayout);
        painelAFTopoLayout.setHorizontalGroup(
            painelAFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelAFTopoLayout.setVerticalGroup(
            painelAFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAF.add(painelAFTopo, java.awt.BorderLayout.PAGE_START);

        painelAFScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelAFScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelAFScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelAFScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelAFNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelAFNotas.setLayout(new java.awt.GridLayout(0, 1, 0, 5));
        painelAFScroll.setViewportView(painelAFNotas);

        painelAF.add(painelAFScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelAF);

        painelSF.setBackground(new java.awt.Color(51, 51, 51));
        painelSF.setLayout(new java.awt.BorderLayout());

        painelSFTopo.setBackground(new java.awt.Color(51, 51, 51));
        painelSFTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelSFTopo.setForeground(new java.awt.Color(230, 230, 230));

        jLabel5.setBackground(new java.awt.Color(255, 102, 102));
        jLabel5.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        jLabel5.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SENDO FEITO");
        jLabel5.setAlignmentX(0.5F);

        javax.swing.GroupLayout painelSFTopoLayout = new javax.swing.GroupLayout(painelSFTopo);
        painelSFTopo.setLayout(painelSFTopoLayout);
        painelSFTopoLayout.setHorizontalGroup(
            painelSFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelSFTopoLayout.setVerticalGroup(
            painelSFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelSF.add(painelSFTopo, java.awt.BorderLayout.PAGE_START);

        painelSFScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelSFScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelSFScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelSFScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelSFNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelSFNotas.setLayout(new java.awt.GridLayout(0, 1));
        painelSFScroll.setViewportView(painelSFNotas);

        painelSF.add(painelSFScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelSF);

        painelC.setBackground(new java.awt.Color(51, 51, 51));
        painelC.setLayout(new java.awt.BorderLayout());

        painelCTopo.setBackground(new java.awt.Color(51, 51, 51));
        painelCTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelCTopo.setForeground(new java.awt.Color(230, 230, 230));

        jLabel6.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        jLabel6.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CONCLUÍDO");

        javax.swing.GroupLayout painelCTopoLayout = new javax.swing.GroupLayout(painelCTopo);
        painelCTopo.setLayout(painelCTopoLayout);
        painelCTopoLayout.setHorizontalGroup(
            painelCTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelCTopoLayout.setVerticalGroup(
            painelCTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelC.add(painelCTopo, java.awt.BorderLayout.PAGE_START);

        painelCScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelCScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelCScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelCScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelCNotas.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout painelCNotasLayout = new javax.swing.GroupLayout(painelCNotas);
        painelCNotas.setLayout(painelCNotasLayout);
        painelCNotasLayout.setHorizontalGroup(
            painelCNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        painelCNotasLayout.setVerticalGroup(
            painelCNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
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
    private javax.swing.JPanel painelAFNotas;
    private javax.swing.JScrollPane painelAFScroll;
    private javax.swing.JPanel painelAFTopo;
    private javax.swing.JPanel painelC;
    private javax.swing.JPanel painelCNotas;
    private javax.swing.JScrollPane painelCScroll;
    private javax.swing.JPanel painelCTopo;
    private javax.swing.JPanel painelColunas;
    private javax.swing.JPanel painelSF;
    private javax.swing.JPanel painelSFNotas;
    private javax.swing.JScrollPane painelSFScroll;
    private javax.swing.JPanel painelSFTopo;
    private javax.swing.JPanel painelTopo;
    // End of variables declaration//GEN-END:variables

    
}
