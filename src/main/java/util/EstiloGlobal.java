
package util;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

// Classe para poder aplicar o tema do JOptionPane em qualquer classe
// É inserido no metodo main da classe
public class EstiloGlobal {
    public static void aplicarTema() {
        Font fonte = new Font("FiraCode Nerd Font", 0, 16);
        Color backgroundClaro = new Color(102,102,102);
        Color backgroundBotao = new Color(61, 61, 61);
        Color clique = new Color(81, 81, 81);
        Color texto = new Color(220, 220, 220);
        ColorUIResource corFocus = new ColorUIResource(new java.awt.Color(0, 0, 0, 0));

        // Muda o fundo de todos os painéis, pop-ups e botões
        UIManager.put("control", backgroundClaro); 
    
        // Muda o fundo de tabelas, listas e caixas de texto
        UIManager.put("nimbusLightBackground", backgroundClaro);
                
        UIManager.put("OptionPane.background", backgroundClaro);

        UIManager.put("OptionPane.messageForeground", texto);
        UIManager.put("OptionPane.messageFont", fonte);
        UIManager.put("OptionPane.font", fonte);
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "OK");
        
        UIManager.put("Panel.background", backgroundClaro);
        
        UIManager.put("Label.foreground", texto);
        
        UIManager.put("Button.background", backgroundBotao);
        UIManager.put("Button.font", fonte);
        UIManager.put("Button.foreground", texto);
        UIManager.put("Button.focus", corFocus);
        UIManager.put("Button.select", clique);

        Border linha = BorderFactory.createLineBorder(new Color(100, 100, 100), 2, true);

        Border espaco = BorderFactory.createEmptyBorder(5, 15, 5, 15);

        UIManager.put("Button.border", BorderFactory.createCompoundBorder(linha, espaco));
        
    }
}
