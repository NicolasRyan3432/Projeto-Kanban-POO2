
package telas.usuarios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.StyleConstants;

public class ListarUsuarios extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListarUsuarios.class.getName());

    
    public ListarUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Painel Kanban - Listar Usuários");
        initComponents();
        arrumarTabela();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        txtListarUsuarios = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        painelScrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setText("Pesquisar:");

        jTextField1.setBackground(java.awt.Color.gray);
        jTextField1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N

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

        jButton1.setBackground(new java.awt.Color(0, 0, 110));
        jButton1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(230, 230, 230));
        jButton1.setText("Modificar");

        jButton2.setBackground(new java.awt.Color(61, 61, 61));
        jButton2.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(230, 230, 230));
        jButton2.setText("Fechar");

        jButton3.setBackground(new java.awt.Color(0, 110, 0));
        jButton3.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(230, 230, 230));
        jButton3.setText("Criar");

        jButton4.setBackground(new java.awt.Color(185, 0, 0));
        jButton4.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(230, 230, 230));
        jButton4.setText("Excluir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelScrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1)))
                .addGap(225, 225, 225))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(painelScrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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
        
        // Força o modelo padrão de tabela a não deixar modificar o conteúdo da linha
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override 
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        
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

        // Adiciona as colunas no modelo
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Login");
        
        // Linhas de teste, serão removidas após a criação do DAO do Usuário
        modelo.addRow(new Object[] {
            1,
            "joao",
            "rola"
        });
        modelo.addRow(new Object[] {
            1,
            "joao",
            "rola"
        });
        modelo.addRow(new Object[] {
            1,
            "joao",
            "rola"
        });
        
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
        
        // Seta o modelo na tabela
        tabela.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane painelScrollTabela;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel txtListarUsuarios;
    // End of variables declaration//GEN-END:variables
}
