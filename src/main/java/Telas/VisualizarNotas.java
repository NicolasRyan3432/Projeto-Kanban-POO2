
package Telas;
import Modelo.Nota;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VisualizarNotas extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VisualizarNotas.class.getName());
    private Nota notaAtual;
    
    public VisualizarNotas(java.awt.Frame parent, boolean modal, Nota n) {
        super(parent, modal);
        this.notaAtual = n;
        
        initComponents();
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPopUp = new javax.swing.JPopupMenu();
        itemModificarNota = new javax.swing.JMenuItem();
        menuMoverPara = new javax.swing.JMenu();
        itemAFazer = new javax.swing.JMenuItem();
        itemSendoFeito = new javax.swing.JMenuItem();
        itemConcluido = new javax.swing.JMenuItem();
        itemHistorico = new javax.swing.JMenuItem();
        painelTopo = new javax.swing.JPanel();
        txtNome = new javax.swing.JLabel();
        painelInfo = new javax.swing.JPanel();
        txtAutor = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JLabel();
        txtPrioridade = new javax.swing.JLabel();
        painelScrollDescricao = new javax.swing.JScrollPane();
        areaDescricao = new javax.swing.JTextArea();
        txtPrazo = new javax.swing.JLabel();
        txtDataCriacao = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        varPrioridade = new javax.swing.JLabel();

        itemModificarNota.setText("Modificar Nota");
        menuPopUp.add(itemModificarNota);

        menuMoverPara.setText("jMenu1");

        itemAFazer.setText("jMenuItem1");
        menuMoverPara.add(itemAFazer);

        itemSendoFeito.setText("jMenuItem2");
        menuMoverPara.add(itemSendoFeito);

        itemConcluido.setText("jMenuItem3");
        menuMoverPara.add(itemConcluido);

        menuPopUp.add(menuMoverPara);

        itemHistorico.setText("jMenuItem1");
        menuPopUp.add(itemHistorico);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelTopo.setBackground(new java.awt.Color(102, 102, 102));
        painelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNome.setBackground(new java.awt.Color(102, 102, 102));
        txtNome.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtNome.setForeground(new java.awt.Color(230, 230, 230));
        txtNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNome.setText("Fazer Compras");

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelInfo.setBackground(new java.awt.Color(51, 51, 51));
        painelInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtAutor.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtAutor.setForeground(new java.awt.Color(220, 220, 220));
        txtAutor.setText("Autor: Nícolas");

        txtDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(220, 220, 220));
        txtDescricao.setText("Descrição da Nota:");

        txtPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrioridade.setForeground(new java.awt.Color(220, 220, 220));
        txtPrioridade.setText("Prioridade:");

        painelScrollDescricao.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelScrollDescricao.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        painelScrollDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        areaDescricao.setEditable(false);
        areaDescricao.setBackground(java.awt.Color.gray);
        areaDescricao.setColumns(20);
        areaDescricao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        areaDescricao.setLineWrap(true);
        areaDescricao.setRows(5);
        areaDescricao.setWrapStyleWord(true);
        painelScrollDescricao.setViewportView(areaDescricao);

        txtPrazo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrazo.setForeground(new java.awt.Color(220, 220, 220));
        txtPrazo.setText("Prazo: 29/05/2026 até 23:59:59");

        txtDataCriacao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtDataCriacao.setText("Data de Criação: 26/05/2026 ás 13:57:23");

        txtStatus.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(220, 220, 220));
        txtStatus.setText("Status: A Fazer");

        btnFechar.setBackground(new java.awt.Color(80, 80, 80));
        btnFechar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(230, 230, 230));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnMenu.setBackground(new java.awt.Color(90, 90, 90));
        btnMenu.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(230, 230, 230));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(this::btnMenuActionPerformed);

        varPrioridade.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        varPrioridade.setForeground(new java.awt.Color(220, 220, 220));
        varPrioridade.setText("Alta");

        javax.swing.GroupLayout painelInfoLayout = new javax.swing.GroupLayout(painelInfo);
        painelInfo.setLayout(painelInfoLayout);
        painelInfoLayout.setHorizontalGroup(
            painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInfoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus)
                    .addComponent(txtDataCriacao)
                    .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDescricao)
                        .addComponent(painelScrollDescricao)
                        .addComponent(txtAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrazo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addGroup(painelInfoLayout.createSequentialGroup()
                            .addComponent(txtPrioridade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(varPrioridade))))
                .addContainerGap(222, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(33, 33, 33)
                .addComponent(btnMenu)
                .addGap(34, 34, 34))
        );
        painelInfoLayout.setVerticalGroup(
            painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInfoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(txtAutor)
                .addGap(28, 28, 28)
                .addComponent(txtDescricao)
                .addGap(28, 28, 28)
                .addComponent(painelScrollDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrioridade)
                    .addComponent(varPrioridade))
                .addGap(28, 28, 28)
                .addComponent(txtPrazo)
                .addGap(28, 28, 28)
                .addComponent(txtDataCriacao)
                .addGap(28, 28, 28)
                .addComponent(txtStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnMenu))
                .addGap(26, 26, 26))
        );

        getContentPane().add(painelInfo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        menuPopUp.show(btnMenu, 0, -btnMenu.getHeight());
    }//GEN-LAST:event_btnMenuActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VisualizarNotas dialog = new VisualizarNotas(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // --- Finalizar aq em sala ---
    private void preencherDados() {
        try {
            String textoDescricao = notaAtual.getDescricao().trim();
            int prioridade = notaAtual.getPrioridade();

            txtNome.setText(notaAtual.getNome());
            txtAutor.setText("Autor: " + notaAtual.getNomeAutor());

            // Verificação pra ver se a descrição está vazia 
            if(textoDescricao.isEmpty()) {
                areaDescricao.setText("Sem descrição!");
            }
            else {
                areaDescricao.setText(notaAtual.getDescricao());
            }
            
            switch(prioridade) {
                case 3 -> {
                    varPrioridade.setText("Alta");
                    varPrioridade.setForeground(java.awt.Color.RED);
                }
                case 2 -> {
                    varPrioridade.setText("Média");
                    varPrioridade.setForeground(java.awt.Color.ORANGE);
                }
                case 1 -> {
                    varPrioridade.setText("Baixa");
                    varPrioridade.setForeground(java.awt.Color.GREEN);
                } 
                default -> {
                    varPrioridade.setText("Baixa");
                    varPrioridade.setForeground(java.awt.Color.GREEN); // Caso venha alguma outra cor
                }
            }

            if(notaAtual.getPrazo() != null) {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                txtPrazo.setText("Prazo: " + notaAtual.getPrazo().format(formatador)); 
            }
            else {
                txtPrazo.setText("Prazo: Indefinido");
            }

            if(notaAtual.getData() != null) {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                txtDataCriacao.setText("Data de Criação: " + notaAtual.getPrazo().format(formatador)); 
            }
            else {
                txtPrazo.setText("Prazo: Indefinido");
            }
        } 
        catch(Exception e) {
            
        }
        
            
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JMenuItem itemAFazer;
    private javax.swing.JMenuItem itemConcluido;
    private javax.swing.JMenuItem itemHistorico;
    private javax.swing.JMenuItem itemModificarNota;
    private javax.swing.JMenuItem itemSendoFeito;
    private javax.swing.JMenu menuMoverPara;
    private javax.swing.JPopupMenu menuPopUp;
    private javax.swing.JPanel painelInfo;
    private javax.swing.JScrollPane painelScrollDescricao;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JLabel txtAutor;
    private javax.swing.JLabel txtDataCriacao;
    private javax.swing.JLabel txtDescricao;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtPrazo;
    private javax.swing.JLabel txtPrioridade;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JLabel varPrioridade;
    // End of variables declaration//GEN-END:variables
}
