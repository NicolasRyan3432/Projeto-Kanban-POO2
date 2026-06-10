
package telas.usuarios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


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
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 1010));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(1040, 1010));
        setResizable(false);

        painelTopo.setBackground(new java.awt.Color(130, 130, 130));
        painelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtListarUsuarios.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
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

        tabela.setBackground(java.awt.Color.gray);
        tabela.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        tabela.setForeground(java.awt.Color.gray);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Login"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        painelScrollTabela.setViewportView(tabela);

        btnModificar.setBackground(new java.awt.Color(0, 0, 110));
        btnModificar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(230, 230, 230));
        btnModificar.setText("Modificar");

        btnFechar.setBackground(new java.awt.Color(61, 61, 61));
        btnFechar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(230, 230, 230));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnCriar.setBackground(new java.awt.Color(0, 110, 0));
        btnCriar.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnCriar.setForeground(new java.awt.Color(230, 230, 230));
        btnCriar.setText("Criar");

        btnExcluir.setBackground(new java.awt.Color(185, 0, 0));
        btnExcluir.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(230, 230, 230));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        javax.swing.GroupLayout painelInfoLayout = new javax.swing.GroupLayout(painelInfo);
        painelInfo.setLayout(painelInfoLayout);
        painelInfoLayout.setHorizontalGroup(
            painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCriar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77))
            .addGroup(painelInfoLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(painelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelScrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelInfoLayout.createSequentialGroup()
                        .addComponent(txtPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPesquisa)))
                .addGap(225, 225, 225))
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
                    .addComponent(btnExcluir)
                    .addComponent(btnFechar))
                .addGap(37, 37, 37))
        );

        getContentPane().add(painelInfo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirUsuario();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
        modelo.addColumn("Nome");
        modelo.addColumn("Login");
        modelo.addColumn("Permissão");
        
        // Linhas de teste, serão removidas após a criação do DAO do Usuário
        modelo.addRow(new Object[] {
            1,
            "JOAO",
            "rola",
            "Administrador"
        });
        modelo.addRow(new Object[] {
            1,
            "Joao",
            "rola",
            "Usuário"
        });
        modelo.addRow(new Object[] {
            1,
            "jo3ao",
            "rola"
        });
        
        // Seta o modelo na tabela
        tabela.setModel(modelo);
        RowSorter<TableModel> ordenador = new TableRowSorter<>(modelo);
        tabela.setRowSorter(ordenador);
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
    
    private void excluirUsuario() {
        int posicaoLinha = tabela.getSelectedRow();

        if (posicaoLinha >= 0) {
            // Pega a linha e converte o index pra um modelo
            int posicaoModelo = tabela.convertRowIndexToModel(posicaoLinha);
            
            // Depois, pega o modelo da tabela, o valor da posição do modelo 
            // e na linha que tá a posição e transforma tudo em string
            String login = tabela.getModel().getValueAt(posicaoModelo, 1).toString();
            
            // Pega a resposta, se for sim (0), deleta aquela linha
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente deletar a linha " + login + "?", 
                    "Confirmar Remoção...", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                // int id = Integer.parseInt(tabela.getModel().getValueAt(posicaoModelo, 0).toString());

                try {
                    // UsuarioDAO dao = new UsuarioDAO();                    
                    // dao.Remover(id);
                    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                    modelo.removeRow(posicaoModelo);
                    
                    
                    JOptionPane.showMessageDialog(this, "Login removido com sucesso!!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } 
        else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!!");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnExcluir;
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
