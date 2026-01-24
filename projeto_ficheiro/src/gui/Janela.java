package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {
    private JMenu menu;
    private JMenu opcoes;
    private JMenu ajuda;
    private JMenu sair;

    private JMenuBar menuBar;

    private JMenuItem registrar;
    private JMenuItem pesquisar;
    private JMenuItem listar;
    private JMenuItem alterar;
    private JMenuItem excluir;
    private JMenuItem confirmar;
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

        ImageIcon background = new ImageIcon(getClass().getResource("/gui/Background.png"));

        this.getContentPane().setBackground(Color.lightGray);

        //Label
        JLabel label = new JLabel(background);
        this.add(label, BorderLayout.CENTER);

        //Menu
        menuBar = new JMenuBar();

        ajuda =  new JMenu("Ajuda");

        confirmar = new JMenuItem("Confirmar");
        confirmar.addActionListener(this);

        menuLogin = new JMenuItem("Login");
        menuLogin.addActionListener(this);

        menuSignin = new JMenuItem("Signin");
        menuSignin.addActionListener(this);

        registrar = new JMenuItem("Registrar");
        alterar = new JMenuItem("Alterar");
        pesquisar = new JMenuItem("Pesquisar");
        listar = new JMenuItem("Listar");
        excluir = new JMenuItem("Excluir");

        menu = new JMenu("Entrar");
        menu.add(menuLogin);
        menu.add(menuSignin);

        opcoes = new JMenu("Opções");
        sair = new JMenu("Sair");

        opcoes.add(registrar);
        opcoes.add(pesquisar);
        opcoes.add(listar);
        opcoes.add(alterar);
        opcoes.add(excluir);

        menuBar.add(opcoes);
        opcoes.setEnabled(false);
        menuBar.add(ajuda);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuLogin) {
            Login login = new Login(this);
        } else if (e.getSource() == menuSignin) {
            Signin signin = new Signin(this);
        } else if (e.getSource() == confirmar) {
            opcoes.setEnabled(false);
            sair.setEnabled(false);
            sair.setVisible(false);

            menu.setEnabled(true);
            menu.setVisible(true);

            JOptionPane.showMessageDialog(null, "Sessão encerrada.", "Logout", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void loginSucedido() {
        menu.setEnabled(false);
        menu.setVisible(false);

        opcoes.setEnabled(true);
        sair.add(confirmar);
        sair.setEnabled(true);
        sair.setVisible(true);
        menuBar.add(sair);

        getJMenuBar().revalidate();
        getJMenuBar().repaint();
    }
}