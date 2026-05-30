
package Telas;
import Modelo.Nota;
import DB.NotaDAO;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class VisualizarNotas extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VisualizarNotas.class.getName());
   
    // NotaAtual agora é final para não ter risco de ser trocada de Nota no decorrer do desinvolvimento
    private final Nota notaAtual;
    
    public VisualizarNotas(java.awt.Frame parent, boolean modal, Nota n, int idUsuario) {
        super(parent, modal);
        this.notaAtual = n;
        this.setResizable(false);
        this.setTitle("Painel Kanban - Visualizar Nota");
        
        initComponents();
        
        preencherDados();
        arrumarCoresMenuPopup();
        
        // Se o id do usuário que tá vendo a nota (idUsuario) 
        // for diferente do id que tá dentro da Nota o botão do Menu é escondido para ele
        if(this.notaAtual.getIdUsuario() != idUsuario) {
            btnMenu.setVisible(false);
        }
        
        // Dependendo da categoria da notaAtual os items tem q sumir
        switch(notaAtual.getCategoria()) {
            case "AF" -> itemAFazer.setVisible(false);
            case "SF" -> itemSendoFeito.setVisible(false);
            case "C"  -> itemConcluido.setVisible(false);
        }
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

        menuPopUp.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        menuPopUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        itemModificarNota.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemModificarNota.setText("Modificar Nota");
        itemModificarNota.addActionListener(this::itemModificarNotaActionPerformed);
        menuPopUp.add(itemModificarNota);

        menuMoverPara.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        menuMoverPara.setForeground(new java.awt.Color(230, 230, 230));
        menuMoverPara.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        menuMoverPara.setInheritsPopupMenu(true);
        menuMoverPara.setLabel("Mover Para");

        itemAFazer.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        itemAFazer.setForeground(new java.awt.Color(220, 220, 220));
        itemAFazer.setText("A Fazer");
        itemAFazer.addActionListener(this::itemAFazerActionPerformed);
        menuMoverPara.add(itemAFazer);

        itemSendoFeito.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        itemSendoFeito.setForeground(new java.awt.Color(220, 220, 220));
        itemSendoFeito.setText("Sendo Feito");
        itemSendoFeito.addActionListener(this::itemSendoFeitoActionPerformed);
        menuMoverPara.add(itemSendoFeito);

        itemConcluido.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        itemConcluido.setForeground(new java.awt.Color(220, 220, 220));
        itemConcluido.setText("Concluído");
        itemConcluido.addActionListener(this::itemConcluidoActionPerformed);
        menuMoverPara.add(itemConcluido);

        menuPopUp.add(menuMoverPara);

        itemHistorico.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemHistorico.setText("Histórico");
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
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
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
        areaDescricao.setBorder(null);
        areaDescricao.setCaretColor(java.awt.Color.gray);
        painelScrollDescricao.setViewportView(areaDescricao);

        txtPrazo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPrazo.setForeground(new java.awt.Color(220, 220, 220));
        txtPrazo.setText("Prazo: 29/05/2026 até 23:59:59");

        txtDataCriacao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtDataCriacao.setForeground(new java.awt.Color(220, 220, 220));
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
                .addContainerGap(290, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(31, 31, 31)
                .addComponent(btnFechar)
                .addGap(31, 31, 31))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
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
        // Para calcular o tamanho exato para o menu ficar exatamente grudado à direita do botão
        int x = btnMenu.getWidth() - menuPopUp.getPreferredSize().width;
        // Altura negativa do tamanho preferido do MenuPopUp
        int y = -menuPopUp.getPreferredSize().height;
        
        menuPopUp.show(btnMenu, x, y);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void itemModificarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarNotaActionPerformed
        Window telaPrincipal = SwingUtilities.getWindowAncestor(this);
        
        CriarNotas tela = new CriarNotas((JFrame) telaPrincipal, true, this.notaAtual);
        tela.setLocationRelativeTo(this);
        this.dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_itemModificarNotaActionPerformed

    private void itemAFazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAFazerActionPerformed
        try {
            
            NotaDAO dao = new NotaDAO();
            dao.adicionarHistorico(notaAtual.getId(), notaAtual.getCategoria());
            dao.mover(this.notaAtual.getId(), "AF");
        
            JOptionPane.showMessageDialog(this, "Nota movida para coluna A Fazer com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            
            // Fecha a tela
            this.dispose();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao mover a nota: " + e.getMessage());
        }
    }//GEN-LAST:event_itemAFazerActionPerformed

    private void itemSendoFeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSendoFeitoActionPerformed
        try {
            NotaDAO dao = new NotaDAO();
            dao.adicionarHistorico(notaAtual.getId(), notaAtual.getCategoria());
            dao.mover(this.notaAtual.getId(), "SF");
            JOptionPane.showMessageDialog(this, "Nota movida para coluna Sendo Feito com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

            // Fecha a tela
            this.dispose();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao mover a nota: " + e.getMessage());
        }
    }//GEN-LAST:event_itemSendoFeitoActionPerformed

    private void itemConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConcluidoActionPerformed
        try {
            NotaDAO dao = new NotaDAO();
            dao.adicionarHistorico(notaAtual.getId(), notaAtual.getCategoria());
            dao.mover(this.notaAtual.getId(), "C");
            JOptionPane.showMessageDialog(this, "Nota movida para coluna Concluído com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

            // Fecha a tela
            this.dispose();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao mover a nota: " + e.getMessage());
        }
    }//GEN-LAST:event_itemConcluidoActionPerformed

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
                VisualizarNotas dialog = new VisualizarNotas(new javax.swing.JFrame(), true, null, 0);
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

    
    private void preencherDados() {
        try {
            // Pega e limpa o texto da descrição pra ver se tem alguma coisa dentro
            String textoDescricao = notaAtual.getDescricao().trim();
            
            // Pega a categoria atual ("AF", "SF", "C")
            String categoriaAtual = notaAtual.getCategoria();
            String categoriaFormatada;
            
            // Pega a prioridade
            int prioridade = notaAtual.getPrioridade();
            
            // Coloca o Título da nota
            txtNome.setText(notaAtual.getNome());
            // Coloca o nome do Autor
            txtAutor.setText("Autor: " + notaAtual.getNomeAutor());

            // Verificação pra ver se a descrição está vazia 
            if(textoDescricao.isEmpty()) {
                areaDescricao.setText("Sem descrição!");
            }
            else {
                areaDescricao.setText(notaAtual.getDescricao());
            }
            
            // Transformando a prioridade que é int para as suas respectivas prioridades em texto
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
            
            // Se o prazo for diferente de vazio, ele pega e formata, senão é indefinido
            if(notaAtual.getPrazo() != null) {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                txtPrazo.setText("Prazo: " + notaAtual.getPrazo().format(formatador));
            }
            else {
                txtPrazo.setText("Prazo: Indefinido");
            }
            
            // Mesma coisa aqui, só que é com a data e formatamos bonitinho para aparecer a data e hora
            if(notaAtual.getData() != null) {
                DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
                
                txtDataCriacao.setText("Data de Criação: " 
                        + notaAtual.getData().format(formatadorData) 
                        + " às " 
                        + notaAtual.getData().format(formatadorHora)); 
            }
            else {
                txtPrazo.setText("Data: Indefinida");
            }
            
            // Troca a sigla da categoria para o que ela significa para mostrar visualmente
            switch(categoriaAtual) {
                case "AF" -> { 
                    categoriaFormatada = "A Fazer";
                }
                case "SF" -> {
                    categoriaFormatada = "Sendo Feito";
                }
                case "C" -> {
                    categoriaFormatada = "Concluído";
                }
                default -> {
                    categoriaFormatada = "A Fazer";
                }
            }
                
            // Insere na tela
            txtStatus.setText("Status: " + categoriaFormatada);
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: Não foi possível carregar as informações da nota! " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }      
    }
    
    private void arrumarCoresMenuPopup() {
        // Variáveis pra gente não ficar repetindo código
        Color corFundo = new Color(51, 51, 51);
        Color corTexto = new Color(210, 210, 210);
        Color corHoverSelecao = new Color(255, 255, 255);
        Color corHover = new Color(85, 85, 85);
        
        
        javax.swing.UIManager.put("MenuItem.background", corFundo); 
        javax.swing.UIManager.put("MenuItem.foreground", corTexto);
        javax.swing.UIManager.put("MenuItem.selectionBackground", corHover);
        javax.swing.UIManager.put("MenuItem.selectionForeground", corHoverSelecao);
        
        javax.swing.UIManager.put("Menu.background", corFundo); 
        javax.swing.UIManager.put("Menu.foreground", corTexto);
        javax.swing.UIManager.put("Menu.selectionBackground", corHover);
        javax.swing.UIManager.put("Menu.selectionForeground", corHoverSelecao);
        
        menuPopUp.setOpaque(true);
        menuPopUp.setBackground(corFundo);
        menuMoverPara.getPopupMenu().setOpaque(true);
        menuMoverPara.getPopupMenu().setBackground(corFundo);
        menuMoverPara.getPopupMenu().setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        
        
        // Pega e cria uma listinha de componentes com os items do menuPopUp e também do menuMoverPara
        JMenuItem[] todosOsItens = {
            itemModificarNota, menuMoverPara, itemHistorico, 
            itemAFazer, itemSendoFeito, itemConcluido
        };  
        
        /* 
            Força todos os botões de dentro a ficarem escuros também usando um laço de repetição
            Agora, ao invés de perguntar se o item é uma instância de um MenuItem, a gente passa
            direto a nossa lista de componentes.
        */
        for (JMenuItem item : todosOsItens) {
            item.setOpaque(true);
            item.setBackground(corFundo); 
            item.setForeground(corTexto);
            item.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 15, 8, 15));
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
