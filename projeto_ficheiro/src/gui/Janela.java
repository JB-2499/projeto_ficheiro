package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {
    private JMenuItem menuLogin;
    private JMenuItem menuSignin;

    public Janela() {
        //Frame
        this.setTitle("Ficheiro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 360);
        this.setResizable(false);
        this.setLayout(new BorderLayout(5, 5));

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/gui/logo.png"));
        this.setIconImage(icon.getImage());

        this.getContentPane().setBackground(Color.lightGray);

        //Menu
        JMenuBar menuBar = new JMenuBar();


        menuLogin = new JMenuItem("Login");
        menuLogin.addActionListener(this);

        menuSignin = new JMenuItem("Signin");
        menuSignin.addActionListener(this);

        JMenu menu = new JMenu("Entrar");

        menuBar.add(menu);
        menu.add(menuLogin);
        menu.add(menuSignin);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuLogin) {
            Login login = new Login(this);
        } else if (e.getSource() == menuSignin) {
            Signin signin = new Signin(this);
        }
    }
}