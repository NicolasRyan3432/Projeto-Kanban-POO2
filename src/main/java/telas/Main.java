
package telas;

import telas.notas.CriarNotas;
import database.NotaDAO;
import database.UsuarioDAO;
import modelo.Usuario;
import modelo.CartaoNota;
import modelo.Nota;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import telas.usuarios.CriarUsuarios;
import telas.usuarios.ListarUsuarios;
import util.EstiloGlobal;
import util.Sessao;



public class Main extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());
    
    // Lista das notas para o ActionPerformed do CheckBox consiga filtrar
    ArrayList<Nota> listaAFNotas = new ArrayList<>();
    ArrayList<Nota> listaSFNotas = new ArrayList<>();
    ArrayList<Nota> listaCNotas = new ArrayList<>();
    
    /* 
        A função Main não recebe nada, quem faz o papel de enviar o id para as telas
        CartaoNota, CriarNotas e VisualizarNotas é a Sessao.
    */
    public Main() {
        // Configurações da janela
        setTitle("Painel Kanban"); // Titulo da aba
        this.setMinimumSize(new Dimension(1250, 960)); // Tamanho mínimo da tela (pra não quebrar)
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centraliza na tela

        initComponents();  // Inicia os componentes
        
        arrumarCoresMenuPopup();
        arrumarCoresComboBox();
        carregarNotas();
        arrumarTexto();
        
        // Faz com que se a sessao logada não for de administrador, deixa o menu de usuarios desabilitado.
        // E habilita o item de Editar Informações
        if(Sessao.permissao != 1) {
            menuGerenciar.setVisible(false);
            itemPerfil.setVisible(true);
        }
        
        // ContentPane é o conteúdo invisível que o Swing adiciona no jFrame 
        getContentPane().setBackground(new java.awt.Color(102, 102, 102)); 
        
        // Aumenta a quantidade de pixels que a tela desce por rolagem
        painelAFScroll.getVerticalScrollBar().setUnitIncrement(20);
        painelSFScroll.getVerticalScrollBar().setUnitIncrement(20);
        painelCScroll.getVerticalScrollBar().setUnitIncrement(20);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPopup = new javax.swing.JPopupMenu();
        itemCriarNotas = new javax.swing.JMenuItem();
        itemPerfil = new javax.swing.JMenuItem();
        menuGerenciar = new javax.swing.JMenu();
        itemListar = new javax.swing.JMenuItem();
        itemCriar = new javax.swing.JMenuItem();
        itemLogout = new javax.swing.JMenuItem();
        painelTopo = new javax.swing.JPanel();
        txtBoasVindas = new javax.swing.JLabel();
        txtTarefasUser = new javax.swing.JLabel();
        txtTarefasTotais = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        comboBoxOrdenacao = new javax.swing.JComboBox<>();
        txtOrdenar = new javax.swing.JLabel();
        painelColunas = new javax.swing.JPanel();
        painelAF = new javax.swing.JPanel();
        painelAFTopo = new javax.swing.JPanel();
        txtAFTopo = new javax.swing.JLabel();
        painelAFScroll = new javax.swing.JScrollPane();
        painelAFNotas = new javax.swing.JPanel();
        painelSF = new javax.swing.JPanel();
        painelSFTopo = new javax.swing.JPanel();
        txtSFTopo = new javax.swing.JLabel();
        painelSFScroll = new javax.swing.JScrollPane();
        painelSFNotas = new javax.swing.JPanel();
        painelC = new javax.swing.JPanel();
        painelCTopo = new javax.swing.JPanel();
        txtCTopo = new javax.swing.JLabel();
        painelCScroll = new javax.swing.JScrollPane();
        painelCNotas = new javax.swing.JPanel();

        menuPopup.setBackground(new java.awt.Color(0, 0, 0));
        menuPopup.setForeground(new java.awt.Color(255, 102, 102));
        menuPopup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        itemCriarNotas.setBackground(new java.awt.Color(0, 0, 0));
        itemCriarNotas.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemCriarNotas.setForeground(java.awt.Color.lightGray);
        itemCriarNotas.setText("Criar Notas");
        itemCriarNotas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        itemCriarNotas.setOpaque(true);
        itemCriarNotas.addActionListener(this::itemCriarNotasActionPerformed);
        menuPopup.add(itemCriarNotas);

        itemPerfil.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemPerfil.setForeground(java.awt.Color.lightGray);
        itemPerfil.setText("Editar Informações");
        itemPerfil.addActionListener(this::itemPerfilActionPerformed);
        menuPopup.add(itemPerfil);

        menuGerenciar.setForeground(java.awt.Color.lightGray);
        menuGerenciar.setText("Gerenciar Usuários");
        menuGerenciar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        itemListar.setBackground(java.awt.Color.lightGray);
        itemListar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemListar.setText("Listar Usuários");
        itemListar.addActionListener(this::itemListarActionPerformed);
        menuGerenciar.add(itemListar);

        itemCriar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemCriar.setForeground(java.awt.Color.lightGray);
        itemCriar.setText("Criar Usuários");
        itemCriar.addActionListener(this::itemCriarActionPerformed);
        menuGerenciar.add(itemCriar);

        menuPopup.add(menuGerenciar);

        itemLogout.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        itemLogout.setForeground(java.awt.Color.lightGray);
        itemLogout.setText("Logout");
        itemLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        itemLogout.setOpaque(true);
        itemLogout.addActionListener(this::itemLogoutActionPerformed);
        menuPopup.add(itemLogout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        painelTopo.setBackground(new java.awt.Color(102, 102, 102));

        txtBoasVindas.setBackground(new java.awt.Color(204, 204, 204));
        txtBoasVindas.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 22)); // NOI18N
        txtBoasVindas.setForeground(new java.awt.Color(230, 230, 230));
        txtBoasVindas.setText("Seja Bem-Vindo, Nícolas");

        txtTarefasUser.setBackground(new java.awt.Color(204, 204, 204));
        txtTarefasUser.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtTarefasUser.setForeground(new java.awt.Color(220, 220, 220));
        txtTarefasUser.setText("Suas Tarefas: 0");

        txtTarefasTotais.setBackground(new java.awt.Color(204, 204, 204));
        txtTarefasTotais.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtTarefasTotais.setForeground(new java.awt.Color(220, 220, 220));
        txtTarefasTotais.setText("Tarefas Totais: 0");

        btnMenu.setBackground(new java.awt.Color(60, 60, 60));
        btnMenu.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(220, 220, 220));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(this::btnMenuActionPerformed);

        comboBoxOrdenacao.setBackground(new java.awt.Color(70, 70, 70));
        comboBoxOrdenacao.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        comboBoxOrdenacao.setForeground(new java.awt.Color(230, 230, 230));
        comboBoxOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maior Prioridade", "Menor Prioridade", "Prazo mais longo", "Prazo mais curto", "Nome (Ordem Alfabética)" }));
        comboBoxOrdenacao.addActionListener(this::comboBoxOrdenacaoActionPerformed);

        txtOrdenar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtOrdenar.setForeground(new java.awt.Color(220, 220, 220));
        txtOrdenar.setText("Ordenar por:");

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBoasVindas)
                    .addComponent(txtTarefasTotais)
                    .addComponent(txtTarefasUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelTopoLayout.createSequentialGroup()
                        .addComponent(txtOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMenu))
                .addGap(60, 60, 60))
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBoasVindas)
                    .addComponent(btnMenu))
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTopoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtTarefasUser)
                        .addGap(18, 18, 18)
                        .addComponent(txtTarefasTotais)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrdenar))
                        .addContainerGap())))
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

        txtAFTopo.setBackground(new java.awt.Color(204, 255, 51));
        txtAFTopo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtAFTopo.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        txtAFTopo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAFTopo.setText("A FAZER");

        javax.swing.GroupLayout painelAFTopoLayout = new javax.swing.GroupLayout(painelAFTopo);
        painelAFTopo.setLayout(painelAFTopoLayout);
        painelAFTopoLayout.setHorizontalGroup(
            painelAFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAFTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelAFTopoLayout.setVerticalGroup(
            painelAFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAFTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAF.add(painelAFTopo, java.awt.BorderLayout.PAGE_START);

        painelAFScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelAFScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelAFScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelAFScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelAFNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelAFNotas.setLayout(new javax.swing.BoxLayout(painelAFNotas, javax.swing.BoxLayout.Y_AXIS));
        painelAFScroll.setViewportView(painelAFNotas);

        painelAF.add(painelAFScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelAF);

        painelSF.setBackground(new java.awt.Color(51, 51, 51));
        painelSF.setLayout(new java.awt.BorderLayout());

        painelSFTopo.setBackground(new java.awt.Color(51, 51, 51));
        painelSFTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelSFTopo.setForeground(new java.awt.Color(230, 230, 230));

        txtSFTopo.setBackground(new java.awt.Color(255, 102, 102));
        txtSFTopo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtSFTopo.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        txtSFTopo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSFTopo.setText("SENDO FEITO");
        txtSFTopo.setAlignmentX(0.5F);

        javax.swing.GroupLayout painelSFTopoLayout = new javax.swing.GroupLayout(painelSFTopo);
        painelSFTopo.setLayout(painelSFTopoLayout);
        painelSFTopoLayout.setHorizontalGroup(
            painelSFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSFTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelSFTopoLayout.setVerticalGroup(
            painelSFTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSFTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSFTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelSF.add(painelSFTopo, java.awt.BorderLayout.PAGE_START);

        painelSFScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelSFScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelSFScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelSFScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelSFNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelSFNotas.setLayout(new javax.swing.BoxLayout(painelSFNotas, javax.swing.BoxLayout.Y_AXIS));
        painelSFScroll.setViewportView(painelSFNotas);

        painelSF.add(painelSFScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelSF);

        painelC.setBackground(new java.awt.Color(51, 51, 51));
        painelC.setLayout(new java.awt.BorderLayout());

        painelCTopo.setBackground(new java.awt.Color(51, 51, 51));
        painelCTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelCTopo.setForeground(new java.awt.Color(230, 230, 230));

        txtCTopo.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 24)); // NOI18N
        txtCTopo.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.foreground"));
        txtCTopo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCTopo.setText("CONCLUÍDO");

        javax.swing.GroupLayout painelCTopoLayout = new javax.swing.GroupLayout(painelCTopo);
        painelCTopo.setLayout(painelCTopoLayout);
        painelCTopoLayout.setHorizontalGroup(
            painelCTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelCTopoLayout.setVerticalGroup(
            painelCTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelC.add(painelCTopo, java.awt.BorderLayout.PAGE_START);

        painelCScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelCScroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelCScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelCScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        painelCNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelCNotas.setLayout(new javax.swing.BoxLayout(painelCNotas, javax.swing.BoxLayout.Y_AXIS));
        painelCScroll.setViewportView(painelCNotas);

        painelC.add(painelCScroll, java.awt.BorderLayout.CENTER);

        painelColunas.add(painelC);

        getContentPane().add(painelColunas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        /* 
            Ao clicar no botão, o show faz com que o menu popup apareça na tela.
            O .show() precisa de três parâmetros: o componente de referência (btnMenu), a posição X e a posição Y. 
            O '0' alinha o menu exatamente na beirada esquerda do botão. 
            O 'btnMenu.getHeight()' faz o menu abrir exatemente colado na parte de baixo do botão!
        */ 
        
        // Para calcular o tamanho exato para o menu ficar exatamente grudado à direita do botão
        int x = btnMenu.getWidth() - menuPopup.getPreferredSize().width;
        // Altura do botão, igual estava antes
        int y = btnMenu.getHeight();
        
        menuPopup.show(btnMenu, x, y);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void itemCriarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCriarNotasActionPerformed
        // Cria a tela de criação. 
        // O id vem da Sessao agora
        CriarNotas tela = new CriarNotas(this, true);
        
        // Coloca ela no centro da tela
        tela.setLocationRelativeTo(this);
        
        // Deixa visível, o Modal aparece na tela e trava a tela principal
        tela.setVisible(true);
        
        // Terminou de criar a nota, recarrega para aparecer a nota
        carregarNotas();
        arrumarTexto();
    }//GEN-LAST:event_itemCriarNotasActionPerformed

    private void comboBoxOrdenacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxOrdenacaoActionPerformed
        ordenarNotas();
    }//GEN-LAST:event_comboBoxOrdenacaoActionPerformed

    private void itemListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListarActionPerformed
        try {
            // Instancia a classe 
            ListarUsuarios tela = new ListarUsuarios(this, true);

            // Coloca ela para aparecer no centro da tela atual
            tela.setLocationRelativeTo(this);

            // Deixa visível
            tela.setVisible(true);
            carregarNotas();
            arrumarTexto();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar a tela de ListarUsuarios: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemListarActionPerformed

    private void itemCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCriarActionPerformed
        try {
            CriarUsuarios tela = new CriarUsuarios(this, true);
            tela.setLocationRelativeTo(this);
            tela.setVisible(true);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Erro ao carregar a tela de CriarUsuarios: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemCriarActionPerformed

    private void itemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogoutActionPerformed
        // Limpa as informações da sessao
        Sessao.limparSessao();
        
        try {
            // Percorre todas as telas abertas e fecha elas
            for (Window janela : Window.getWindows()) {
                janela.dispose();
            }
            new Login().setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar criar a tela de Login: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemLogoutActionPerformed

    private void itemPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPerfilActionPerformed
        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.buscar(Sessao.idUsuario);
            
            CriarUsuarios tela = new CriarUsuarios(this, true, usuario);
            tela.setLocationRelativeTo(this);
            tela.setVisible(true);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao criar a tela de modificar usuário: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemPerfilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EstiloGlobal.aplicarTema();
        
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
    
    private void arrumarCoresMenuPopup() {
        // Variáveis pra gente não ficar repetindo código
        Color corFundo = new Color(51, 51, 51);
        Color corTexto = new Color(210, 210, 210);
        Color corHoverSelecao = new Color(255, 255, 255);
        Color corHover = new Color(0, 110, 0);
        
        
        javax.swing.UIManager.put("MenuItem.background", corFundo); 
        javax.swing.UIManager.put("MenuItem.foreground", corTexto);
        javax.swing.UIManager.put("MenuItem.selectionBackground", corHover);
        javax.swing.UIManager.put("MenuItem.selectionForeground", corHoverSelecao);
        
        javax.swing.UIManager.put("Menu.background", corFundo); 
        javax.swing.UIManager.put("Menu.foreground", corTexto);
        javax.swing.UIManager.put("Menu.selectionBackground", corHover);
        javax.swing.UIManager.put("Menu.selectionForeground", corHoverSelecao);
        
        menuPopup.setOpaque(true);
        menuPopup.setBackground(corFundo);
        menuGerenciar.getPopupMenu().setOpaque(true);
        menuGerenciar.getPopupMenu().setBackground(corFundo);
        menuGerenciar.getPopupMenu().setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        // Pega e cria uma listinha de componentes com os items do menuPopup e também do menuGerenciar
        JMenuItem[] todosOsItens = {
            itemCriar, menuGerenciar, itemCriarNotas, 
            itemListar, itemLogout, itemPerfil
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
    
    private void arrumarCoresComboBox() {
        // Seta a cor escura no fundo do combobox
        comboBoxOrdenacao.setBackground(new Color(51, 51, 51));
        comboBoxOrdenacao.setForeground(new Color(230, 230, 230));
        
        // Seta a cor escura no menu que aparece
        comboBoxOrdenacao.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Se o mouse estiver passando por cima dos items
                if(isSelected) {
                    c.setBackground(new java.awt.Color(85, 85, 85)); 
                    c.setForeground(new Color(255, 255, 255));
                } 
                else {
                    c.setBackground(new Color(51, 51, 51)); 
                    c.setForeground(new Color(220, 220, 220));
                }
                return c;
            }
        });
    }
    
    public final void arrumarTexto() {
        int quantidadeNotas = listaAFNotas.size() + listaSFNotas.size() + listaCNotas.size();
        
        try {
            NotaDAO dao = new NotaDAO();
            int resultado = dao.contar(Sessao.idUsuario);
            txtBoasVindas.setText("Seja Bem-Vindo, " + Sessao.apelido);
            txtTarefasUser.setText("Suas Tarefas: " + resultado);
            txtTarefasTotais.setText("Tarefas totais: " + quantidadeNotas);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    private void ordenarLista(ArrayList<Nota> lista, int filtro) {
        switch(filtro) {
            // Deixa o n2 > n1 para ser em ordem decrescente
            case 0 -> lista.sort((n1, n2) -> Integer.compare(n2.getPrioridade(), n1.getPrioridade()));
            
            // Deixa o n1 > n2 para ser em ordem crescente
            case 1 -> lista.sort((n1, n2) -> Integer.compare(n1.getPrioridade(), n2.getPrioridade()));
            
            // Prazo Mais longo (ordem crescente)
            case 2 -> lista.sort((n1, n2) -> {
                // Os prazos "Indefinidos" (null) vão pro final da fila!
                if (n1.getPrazo() == null && n2.getPrazo() == null) {
                    return 0;
                } 
                
                // Joga o n1 pro fim
                if (n1.getPrazo() == null) {
                    return 1;  
                }
                
                // Joga o n2 pro fim    
                if(n2.getPrazo() == null) {
                    return -1;
                } 
                
                // Fica primeiro quem tiver mais em cima (1) 
                return n2.getPrazo().compareTo(n1.getPrazo()); 
            });
            
            // Prazo mais curto (ordem decrescente)
            case 3 -> lista.sort((n1, n2) -> {
                // Os prazos "Indefinidos" (null) vão pro final da fila!
                if (n1.getPrazo() == null && n2.getPrazo() == null) {
                    return 0;
                } 
                
                // Joga o n1 pro fim
                if (n1.getPrazo() == null) {
                    return 1;  
                }
                
                // Joga o n2 pro fim    
                if(n2.getPrazo() == null) {
                    return -1;
                } 
                
                // Fica primeiro quem tiver mais em cima (1) 
                return n1.getPrazo().compareTo(n2.getPrazo()); 
            });
            
            // Compara os nomes ignorando se são letras maiúsculas ou minúsculas
            case 4 -> lista.sort((n1, n2) -> n1.getNome().compareToIgnoreCase(n2.getNome()));     
        }   
    }
   
    /* 
        Dividi a função recarregarNotas em três por dois motivos:
        Divisão de trabalhos e por conta de termos a ordenação.
    
        A função antiga fazia tudo, pegava as notas no banco, 
        dividia elas por categoria, criava o cartão com as informações
        e aí distribuia nos paineis de acordo com a categoria.
        
        Agora, como a gente ordena as notas por lista (ordenarLista), 
        como a função antiga pega as notas direto do banco, ela vinha bagunçada.
        Cada função faz uma parte do código.
    */
    
    // Puxa as notas do banco e ordena pelas categorias
    // Deixando final pra que outras classes que possam herdar Main
    // não consigam modificar o carregarNotas.
    public final void carregarNotas() {
        try {
            // Limpa a lista para poder não duplicar
            listaAFNotas.clear();
            listaSFNotas.clear();
            listaCNotas.clear();
            
            // Puxa os dados do banco
            NotaDAO dao = new NotaDAO();
            ArrayList<Nota> notas = dao.listar();
            
            // Preenche as listas dependendo da categoria das notas
            // e seta a sua prioridade
            for(Nota n : notas) {
                switch (n.getCategoria()) {
                    case "AF" -> listaAFNotas.add(n);
                    case "SF" ->listaSFNotas.add(n);                    
                    case "C" -> listaCNotas.add(n);                    
                    default -> listaAFNotas.add(n);
               }
                switch(n.getPrioridade()) {
                    case 3 -> n.setPrioridadeFormatada("Alta");
                    case 2 -> n.setPrioridadeFormatada("Média");
                    case 1 -> n.setPrioridadeFormatada("Baixa");
                    default -> n.setPrioridadeFormatada("Baixa");
                }
            }
            
            // Manda ordenar
            ordenarNotas();
        }   
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar as notas na lista: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Ordena as notas de acordo com o modo de ordenação
    // Os dois são privados porque o carregarNotas já chama em cadeia os dois 
    // carregarNotas -> ordenarNotas -> criarNotas
    private void ordenarNotas() {
        // Pega o indice escolhido (por padrão é o indice 0)
        int indiceEscolhido = comboBoxOrdenacao.getSelectedIndex();
        
        // Ordena as listas da função de carregar as notas
        ordenarLista(listaAFNotas, indiceEscolhido);
        ordenarLista(listaSFNotas, indiceEscolhido);
        ordenarLista(listaCNotas, indiceEscolhido);
        
        // Cria os cartões e joga na tela
        criarNotas();
    }
    
    // Cria as notas nos respectivos campos
    private void criarNotas() {
        try {
            // Limpa as colunas (pra não ter notas duplicadas)
            painelAFNotas.removeAll();
            painelSFNotas.removeAll();
            painelCNotas.removeAll();
            
            // Foreach maroto pra instanciar as notas nas listas
            for(Nota n : listaAFNotas) {
                CartaoNota cartao = new CartaoNota(n, n.getPrioridadeFormatada());
                painelAFNotas.add(cartao);
                painelAFNotas.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
            }
            
            for(Nota n : listaSFNotas) {
                CartaoNota cartao = new CartaoNota(n, n.getPrioridadeFormatada());
                painelSFNotas.add(cartao);
                painelSFNotas.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
            }
            
            for(Nota n : listaCNotas) {
                CartaoNota cartao = new CartaoNota(n, n.getPrioridadeFormatada());
                painelCNotas.add(cartao);
                painelCNotas.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
            }
            
            // Manda o Java Swing recarregar a tela 
            painelAFNotas.revalidate();
            painelAFNotas.repaint();
            
            painelSFNotas.revalidate();
            painelSFNotas.repaint();
            
            painelCNotas.revalidate();
            painelCNotas.repaint();
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o Kanban:\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> comboBoxOrdenacao;
    private javax.swing.JMenuItem itemCriar;
    private javax.swing.JMenuItem itemCriarNotas;
    private javax.swing.JMenuItem itemListar;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JMenuItem itemPerfil;
    private javax.swing.JMenu menuGerenciar;
    private javax.swing.JPopupMenu menuPopup;
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
    private javax.swing.JLabel txtAFTopo;
    private javax.swing.JLabel txtBoasVindas;
    private javax.swing.JLabel txtCTopo;
    private javax.swing.JLabel txtOrdenar;
    private javax.swing.JLabel txtSFTopo;
    private javax.swing.JLabel txtTarefasTotais;
    private javax.swing.JLabel txtTarefasUser;
    // End of variables declaration//GEN-END:variables

    
}
