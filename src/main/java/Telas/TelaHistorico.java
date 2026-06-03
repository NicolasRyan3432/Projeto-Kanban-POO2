
package Telas;

import DB.NotaDAO;
import Modelo.Nota;
import Modelo.CartaoNota;
import Modelo.HistoricoNota;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaHistorico extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaHistorico.class.getName());
    private final Nota notaAtual;
    
    public TelaHistorico(java.awt.Frame parent, boolean modal, Nota notaAtual) {
        super(parent, modal);
        this.notaAtual = notaAtual;
        this.setTitle("Painel Kanban - Histórico");
        initComponents();
        
        recarregarNotas();
        // Aumenta a quantidade de pixels que a tela desce por rolagem
        painelScroll.getVerticalScrollBar().setUnitIncrement(20);   
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelConteiner = new javax.swing.JPanel();
        painelScroll = new javax.swing.JScrollPane();
        painelNotas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(1240, 800));
        setPreferredSize(new java.awt.Dimension(1240, 134));
        setResizable(false);

        painelTopo.setBackground(new java.awt.Color(102, 102, 102));
        painelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 230, 230));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Histórico");

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(painelTopo, java.awt.BorderLayout.PAGE_START);

        painelConteiner.setBackground(new java.awt.Color(51, 51, 51));
        painelConteiner.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelConteiner.setPreferredSize(new java.awt.Dimension(1240, 32771));

        painelScroll.setBackground(new java.awt.Color(51, 51, 51));
        painelScroll.setBorder(null);
        painelScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        painelScroll.setPreferredSize(new java.awt.Dimension(1240, 692));

        painelNotas.setBackground(new java.awt.Color(51, 51, 51));
        painelNotas.setLayout(new java.awt.BorderLayout(8, 8));
        painelScroll.setViewportView(painelNotas);

        javax.swing.GroupLayout painelConteinerLayout = new javax.swing.GroupLayout(painelConteiner);
        painelConteiner.setLayout(painelConteinerLayout);
        painelConteinerLayout.setHorizontalGroup(
            painelConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1196, Short.MAX_VALUE)
        );
        painelConteinerLayout.setVerticalGroup(
            painelConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(painelConteiner, java.awt.BorderLayout.CENTER);

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
                TelaHistorico dialog = new TelaHistorico(new javax.swing.JFrame(), true, null);
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
    
    // Aqui continua o recarregar porque não tem ordenação 
    // (não precisa, mas se quiser dá pra ordenar por prioridade, ou por modificação mais recente)
    public final void recarregarNotas() {
        try {
            // Cria um painelGrid com três colunas com oito de espaço entre eles
            JPanel painelGrid = new JPanel(new GridLayout(0, 3, 5, 5));
            painelGrid.setOpaque(false); 
            
            // Limpa as colunas (pra não ter notas duplicadas)
            painelNotas.removeAll();
           
            // Puxa os dados do banco
            NotaDAO dao = new NotaDAO();
            ArrayList<HistoricoNota> notas = dao.listarHistorico(notaAtual.getId());
            
            // For Each maroto pra instanciar as notas
            for(HistoricoNota n : notas) {
                String prioridade;
                
                switch(n.getPrioridadeAntiga()) {
                    case 3 -> prioridade = "Alta";
                    case 2 -> prioridade = "Média";
                    case 1 -> prioridade = "Baixa";
                    default -> prioridade = "Baixa";
                }
                
                // Cria o cartao agora passando a nota atual (n) e a prioridade como parâmetro
                // Aqui vai vir do Usuario, como n tá criado ainda, deixei aqui assim msm.
                CartaoNota cartao = new CartaoNota(this.notaAtual, n, prioridade);
                
                // Adiciona primeiro no grid ao invés de adicionar no painelNotas
                painelGrid.add(cartao);
            }
            // Aqui cria paineis vazios para não deixar a nota ocupar todo o espaço disponível (o grid por padrão faz isso)
            // quando o tamanho é menor do que 3
            int resto = notas.size() % 3;
            if (resto != 0) {
                int fantasmas = 3 - resto;
                for (int i = 0; i < fantasmas; i++) {
                    JPanel painelFantasma = new JPanel();
                    painelFantasma.setOpaque(false);
                    painelGrid.add(painelFantasma);
                }
            }
            
            // Adiciona o grid no topo do painelNotas para não esticar as linhas
            painelNotas.add(painelGrid, BorderLayout.NORTH);
            
            // Manda o Java Swing recarregar a tela 
            painelNotas.revalidate();
            painelNotas.repaint();
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Erro ao carregar o Kanban: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelConteiner;
    private javax.swing.JPanel painelNotas;
    private javax.swing.JScrollPane painelScroll;
    private javax.swing.JPanel painelTopo;
    // End of variables declaration//GEN-END:variables
}
