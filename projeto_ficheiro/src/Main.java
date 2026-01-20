import gui.Janela;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Janela janela = new Janela();
        janela.setLayout(null);

        //Label
        ImageIcon imagem = new ImageIcon(janela.getClass().getResource("/gui/imagem.png"));
        JLabel rotulo = new JLabel("Isso é um teste.");
        rotulo.setIcon(imagem);

        rotulo.setVerticalTextPosition(JLabel.TOP);
        rotulo.setHorizontalTextPosition(JLabel.CENTER);
        rotulo.setForeground(Color.DARK_GRAY);
        rotulo.setIconTextGap(5);

        rotulo.setBounds(60, 20, imagem.getIconWidth(), imagem.getIconHeight()+35);

        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 5);
        rotulo.setBorder(border);

        //Panel
        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(Color.lightGray);
        painelCentral.setLayout(null);

        JPanel painelUp = new JPanel();
        painelUp.setLayout(null);
        painelUp.setBackground(Color.DARK_GRAY);
        painelUp.setAlignmentY(Component.TOP_ALIGNMENT);

        painelUp.setBounds(0, 0, 340, 30);
        painelCentral.setBounds(0, 30, 340, 370);

        //Button
        JButton botao1 = new JButton("Anterior");
        botao1.setFont(new Font("Arial", Font.BOLD, 11));
        botao1.setBounds(5, 5, 80, 20);

        JButton botao2 = new JButton("Próxima");
        botao2.setFont(new Font("Arial", Font.BOLD, 11));
        botao2.setBounds(240, 5, 80, 20);

        painelUp.add(botao1);
        painelUp.add(botao2);
        painelCentral.add(rotulo);
        janela.add(painelUp);
        janela.add(painelCentral);
        janela.setVisible(true);
    }
}