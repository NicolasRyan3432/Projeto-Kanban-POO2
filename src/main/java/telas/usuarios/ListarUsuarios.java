
package telas.usuarios;

import database.UsuarioDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Usuario;
import telas.Main;
import util.EstiloGlobal;
import util.Sessao;


public class ListarUsuarios extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListarUsuarios.class.getName());

    
    public ListarUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Painel Kanban - Listar Usuários");
        initComponents();
        arrumarTabela();
        inicializarTabela();
        configurarCampoPesquisa();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        txtListarUsuarios = new javax.swing.JLabel();
        painelInfo = new javax.swing.JPanel();
        txtPesquisar = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        painelScrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        btnAlterarStatus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 1010));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(1040, 1010));
        setResizable(false);

        painelTopo.setBackground(new java.awt.Color(130, 130, 130));
        painelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtListarUsuarios.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 20)); // NOI18N
        txtListarUsuarios.setForeground(new java.awt.Color(230, 230, 230));
        txtListarUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtListarUsuarios.setText("Listar Usuários");

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtListarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtListarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelInfo.setBackground(new java.awt.Color(51, 51, 51));
        painelInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPesquisar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        txtPesquisar.setForeground(new java.awt.Color(220, 220, 220));
        txtPesquisar.setText("Pesquisar:");

        campoPesquisa.setBackground(java.awt.Color.gray);
        campoPesquisa.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

        painelScrollTabela.setBackground(java.awt.Color.gray);
        painelScrollTabela.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelScrollTabela.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tabela.setBackground(java.awt.Color.gray);
        tabela.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        tabela.setForeground(java.awt.Color.gray);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Login", "Nome", "Permissao", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        painelScrollTabela.setViewportView(tabela);

        btnModificar.setBackground(new java.awt.Color(61, 61, 61));
        btnModificar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(230, 230, 230));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        btnFechar.setBackground(new java.awt.Color(61, 61, 61));
        btnFechar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(230, 230, 230));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnCriar.setBackground(new java.awt.Color(0, 110, 0));
        btnCriar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnCriar.setForeground(new java.awt.Color(230, 230, 230));
        btnCriar.setText("Criar");
        btnCriar.addActionListener(this::btnCriarActionPerformed);

        btnAlterarStatus.setBackground(new java.awt.Color(41, 41, 41));
        btnAlterarStatus.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnAlterarStatus.setForeground(new java.awt.Color(255, 77, 77));
        btnAlterarStatus.setText("Desativar");
        btnAlterarStatus.addActionListener(this::btnAlterarStatusActionPerformed);

        javax.swing.GroupLayout painelInfoLayout = new javax.swing.GroupLayout(painelInfo);
        painelInfo.setLayout(painelInfoLayout);
        painelInfoLayout.setHorizontalGroup(
            painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInfoLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelInfoLayout.createSequentialGroup()
                        .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(painelScrollTabela, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelInfoLayout.createSequentialGroup()
                                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCriar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAlterarStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(77, 77, 77))
                    .addGroup(painelInfoLayout.createSequentialGroup()
                        .addComponent(txtPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))))
        );
        painelInfoLayout.setVerticalGroup(
            painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInfoLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(painelScrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnCriar))
                .addGap(18, 18, 18)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterarStatus)
                    .addComponent(btnFechar))
                .addGap(37, 37, 37))
        );

        getContentPane().add(painelInfo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAlterarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarStatusActionPerformed
        AlterarStatusUsuario();
    }//GEN-LAST:event_btnAlterarStatusActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        Color cor = new Color(41, 41, 41);
        
        // 1. Descobre qual linha o usuário clicou
        int linhaSelecionada = tabela.getSelectedRow();
        
        // Se realmente tem uma linha selecionada...
        if (linhaSelecionada != -1) {
            // 2. Pega a palavra "Ativo" ou "Inativo" (Mude o 4 para o número da sua coluna de status)
            String status = tabela.getValueAt(linhaSelecionada, 4).toString();

            // 3. Pinta o botão e muda o texto na hora!
            if (status.equals("Ativo")) {
                btnAlterarStatus.setText("Desativar");
                btnAlterarStatus.setBackground(cor);
                btnAlterarStatus.setForeground(new Color(255, 77, 77));
            } 
            else {
                btnAlterarStatus.setText("Reativar");
                btnAlterarStatus.setBackground(cor);
                btnAlterarStatus.setForeground(new Color(255, 193, 7));
            }
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        try {
            Window telaPrincipal = SwingUtilities.getWindowAncestor(this);
            CriarUsuarios tela = new CriarUsuarios((JFrame) telaPrincipal, true);
            tela.setLocationRelativeTo(this);
            tela.setVisible(true);
            inicializarTabela();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar a tela de criar usuarios:\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int linhaSelecionada = tabela.getSelectedRow();
        
        // Se não tiver selecionado uma linha antes
        if(linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha primeiro antes de tentar modificar!!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int posicaoModelo = tabela.convertRowIndexToModel(linhaSelecionada);
            int id = Integer.parseInt(tabela.getModel().getValueAt(posicaoModelo, 0).toString());
            
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.buscar(id);
            

      
            Window telaPrincipal = SwingUtilities.getWindowAncestor(this);
            CriarUsuarios tela = new CriarUsuarios((JFrame) telaPrincipal, true, usuario);
            tela.setLocationRelativeTo(this);
            tela.setVisible(true);
            inicializarTabela();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar a tela de modificar usuarios:\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListarUsuarios dialog = new ListarUsuarios(new javax.swing.JFrame(), true);
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
    
    private void inicializarTabela() {
        // Força o modelo padrão de tabela a não deixar modificar o conteúdo da linha
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override 
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        
        // Adiciona as colunas no modelo
        modelo.addColumn("Id");
        modelo.addColumn("Login");
        modelo.addColumn("Apelido");
        modelo.addColumn("Permissão");
        modelo.addColumn("Status");
        
        try {
            UsuarioDAO dao = new UsuarioDAO();
            ArrayList<Usuario> listaUsuarios = dao.listar();
            String permissao;
            String ativo = "Ativo";
            
            for(Usuario u : listaUsuarios) {
                if(u.getPermissao() == 1) {
                    permissao = "Administrador";
                }
                else {
                    permissao = "Usuário";
                }
                
                if(u.getAtivo() != 1) {
                    ativo = "Inativo";
                }
                
                // Já vem ordenadinho com ATIVOS primeiro e ADMINISTRADORES primeiro
                modelo.addRow(new Object[]{
                u.getId(),
                u.getLogin(),
                u.getApelido(),
                permissao,
                ativo
                });
            }
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        
        // Seta o modelo na tabela
        tabela.setModel(modelo);
        RowSorter<TableModel> ordenador = new TableRowSorter<>(modelo);
        tabela.setRowSorter(ordenador);
    }
    
    private void AlterarStatusUsuario() {
        int posicaoLinha = tabela.getSelectedRow();

        if(posicaoLinha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!!", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        // Pega a linha e converte o index pra um modelo
        int posicaoModelo = tabela.convertRowIndexToModel(posicaoLinha);
        int id = Integer.parseInt(tabela.getModel().getValueAt(posicaoModelo, 0).toString());
        
        if(id == Sessao.idUsuario) {
            JOptionPane.showMessageDialog(this, "ERRO GRAVISSÍMO!! Por que você deseja desativar o próprio usuário?", "ERRO!!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Depois, pega o modelo da tabela, o valor da posição do modelo 
        // e na linha que tá a posição e transforma tudo em string
        String login = tabela.getModel().getValueAt(posicaoModelo, 2).toString();
        String status = tabela.getModel().getValueAt(posicaoModelo, 4).toString();
        
        int modo = -1;
        int resposta = -1;
        
        switch(status) {
            case "Ativo" -> {
                // Pega a resposta, se for sim (0), deleta aquela linha
                resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente desativar o usuário " + login + "?", 
                    "Confirmar Desativação...", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                modo = 0;
            }
            case "Inativo" -> {
                resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente reativar o usuário " + login + "?", 
                    "Confirmar Reativação...", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                modo = 1;
            }
        }
        

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                UsuarioDAO dao = new UsuarioDAO();                    
                int resultado = dao.alterarStatus(id, modo);
                
                switch(resultado) {
                    case 1 -> {
                        if(modo == 0) {
                            JOptionPane.showMessageDialog(this, "Usuário desativado com sucesso!!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(this, "Usuário reativado com sucesso!!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        inicializarTabela();
                    }
                    case 0 -> JOptionPane.showMessageDialog(this, "É proibido desativar todos os administradores!!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void pesquisar() {
        // Pega o modelo da tabela
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        
        //Pega e cria um filtro a partir do modelo
        TableRowSorter filtro = new TableRowSorter(modelo);
        
        //Pega o texto do campo
        String termoBusca = campoPesquisa.getText();
        
        // Se o texto for igual a zero, ele não passa o filtro, se não, pega e pesquisa nas tabelas se tem o texto
        if (termoBusca.length() == 0) {
            filtro.setRowFilter(null);
        } 
        else {
            filtro.setRowFilter(RowFilter.regexFilter("(?i)" + termoBusca));
        }
        tabela.setRowSorter(filtro);
    }

    private void configurarCampoPesquisa() {
        campoPesquisa.getDocument().addDocumentListener(
                new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                pesquisar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pesquisar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pesquisar();
            }
        }
        );
    }
    
    private void arrumarTabela() {
        // Cria os renderizadores (é nele que a gente coloca as cores de fundo da tabela)
        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer();
        
        // Aqui temos que substituir o método que pega os componentes da célula da tabela
        // para setar a cor de hover que queremos
        DefaultTableCellRenderer renderizadorC = new DefaultTableCellRenderer() {
            @Override 
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
                // Deixa o Java fazer o trabalho dele
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Aqui que é controlado as cores caso estiver clicado ou não 
                if(isSelected) {
                    setBackground(new Color(0, 110, 0));
                    setForeground(new Color(220, 220, 220));
                }
                else {
                    setForeground(new Color(220, 220, 220));
                    setBackground(new Color(100, 100, 100));
                }
                return this;
            }
        };
        
        // Cria o modelo padrão de coluna
        DefaultTableColumnModel col = new DefaultTableColumnModel();
        
        // Cria o cabeçalho pegando como base o que já tem na tabela (por enquanto tá vazio)
        JTableHeader cabecalho = tabela.getTableHeader();
        
        // Renderizador passado para o cabeçalho
        renderizador.setOpaque(true);
        renderizador.setBackground(new Color(51, 51, 51));
        renderizador.setForeground(new Color(220, 220, 220));
        renderizador.setFont(new Font("FiraCode Nerd Font", 0, 18));
        
        // O DefaultTableCellRenderer por baixo dos panos é um JLabel (herda de JLabel) 
        // então conseguimos setar uma borda marota nele!
        renderizador.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        
        // Renderizador das colunas
        renderizadorC.setFont(new Font("FiraCode Nerd Font", 0, 18));
        renderizadorC.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        
        // Seta o renderizador padrão do cabeçalho como o renderizador
        cabecalho.setDefaultRenderer(renderizador);
        
        // Seta a tabela que ele se liga
        cabecalho.setTable(tabela);
        
        // Desabilita a movimentação das colunas
        cabecalho.setReorderingAllowed(false);
        cabecalho.setResizingAllowed(false);
        
        // Seta o cabeçalho que eu criei na tabela (antes só tinha criado o cabeçalho
        // e falado para ele: "olha, esse daqui é teu pai (tabela), gruda nele".
        tabela.setTableHeader(cabecalho);
        
        // Seta o renderizador padrão pegando tudo na tela (Object.class)
        tabela.setDefaultRenderer(Object.class, renderizadorC);
        
        // Altura das linhas
        tabela.setRowHeight(45);
        
        // Margem da linha
        tabela.setRowMargin(3);
        
        // Modo da coluna (para colocar os espaçamentos)
        tabela.setColumnModel(col);
        
        // Faz com que a tabela pegue todo o espaço disponível do scroll pane
        tabela.setFillsViewportHeight(true);
        
        // Força a aparecer as linhas do grid
        tabela.setGridColor(new Color(150, 150, 150));
        tabela.setShowGrid(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarStatus;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JPanel painelInfo;
    private javax.swing.JScrollPane painelScrollTabela;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel txtListarUsuarios;
    private javax.swing.JLabel txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
