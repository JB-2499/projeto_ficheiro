package gui;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {
    public Janela() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(340, 400);
        this.setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/gui/logo.png"));
        this.setIconImage(icon.getImage());

        this.getContentPane().setBackground(Color.lightGray);
    }
}