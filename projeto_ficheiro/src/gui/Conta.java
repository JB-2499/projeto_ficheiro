package gui;

import javax.swing.*;
import java.awt.*;

public class Conta {
    JFrame frame;
    public Conta(JFrame janela) {
        frame = new JFrame("Conta");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.lightGray);
        frame.setSize(400, 270);
        frame.setLocationRelativeTo(janela);

        ImageIcon logo = new ImageIcon(getClass().getResource("/gui/Gear.png"));
        frame.setIconImage(logo.getImage());

        frame.setVisible(true);
    }
}