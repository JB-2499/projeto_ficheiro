import gui.Janela;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Janela janela = new Janela();

        ImageIcon imagem = new ImageIcon(janela.getClass().getResource("/gui/imagem.png"));
        JLabel rotulo = new JLabel("Isso é um teste.");
        rotulo.setIcon(imagem);


        rotulo.setVerticalAlignment(JLabel.CENTER);
        rotulo.setHorizontalAlignment(JLabel.CENTER);

        rotulo.setVerticalTextPosition(JLabel.TOP);
        rotulo.setHorizontalTextPosition(JLabel.CENTER);
        rotulo.setForeground(Color.DARK_GRAY);
        rotulo.setIconTextGap(20);

        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 5);
        rotulo.setBorder(border);

        janela.add(rotulo);
        janela.setVisible(true);
    }
}