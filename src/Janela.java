import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {
    private JMenu menu;
    private JMenu opcoes;
    private JMenu sair;
    private JMenu menuDelete;

    private JMenuBar menuBar;

    private Login login;

    private JMenuItem registrar;
    private JMenuItem pesquisar;
    private JMenuItem listar;
    private JMenuItem deletar;
    private JMenuItem confirmar;
    private JMenuItem confirmar2;
    private JMenuItem menuLogin;
    private JMenuItem menuSignin;

    private Ficheiro ficheiro;

    public Janela() {
        //region Frame
        this.setTitle("Ficheiro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 360);
        this.setResizable(false);
        this.setLayout(new BorderLayout(5, 5));

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setLocationRelativeTo(null);

        this.ficheiro = new Ficheiro();

        ImageIcon icon = new ImageIcon(getClass().getResource("/gui/logo.png"));
        this.setIconImage(icon.getImage());

        ImageIcon background = new ImageIcon(getClass().getResource("/gui/Background.png"));

        this.getContentPane().setBackground(Color.lightGray);
        //endregion

        //region Label
        JLabel label = new JLabel(background);
        this.add(label, BorderLayout.CENTER);
        //endregion

        //region Menu
        menuBar = new JMenuBar();

        confirmar = new JMenuItem("Sair");
        confirmar.addActionListener(this);

        confirmar2 = new JMenuItem("Confirmar");
        confirmar2.addActionListener(this);

        menuLogin = new JMenuItem("Login");
        menuLogin.addActionListener(this);

        menuSignin = new JMenuItem("Signin");
        menuSignin.addActionListener(this);

        registrar = new JMenuItem("Registrar");
        registrar.addActionListener(this);

        pesquisar = new JMenuItem("Pesquisar");
        pesquisar.addActionListener(this);

        listar = new JMenuItem("Listar");
        listar.addActionListener(this);

        deletar = new JMenuItem("Deletar");
        deletar.addActionListener(this);

        menu = new JMenu("Entrar");
        menu.add(menuLogin);
        menu.add(menuSignin);

        opcoes = new JMenu("Opções");
        sair = new JMenu();
        menuDelete = new JMenu("Deletar conta");

        opcoes.add(registrar);
        opcoes.add(pesquisar);
        opcoes.add(listar);
        opcoes.add(deletar);

        menuBar.add(opcoes);
        opcoes.setEnabled(false);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu);
        //endregion

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuLogin) {
            login = new Login(this, ficheiro);
        } else if (e.getSource() == menuSignin) {
            Signin signin = new Signin(this);
        } else if (e.getSource() == confirmar) {
            opcoes.setEnabled(false);
            sair.setEnabled(false);
            sair.setVisible(false);

            menuDelete.setEnabled(false);
            menuDelete.setVisible(false);

            menu.setEnabled(true);
            menu.setVisible(true);

            JOptionPane.showMessageDialog(null, "Sessão encerrada.", "Logout", JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == listar) {
            Tabela tabela = new Tabela(this, ficheiro);

        } else if (e.getSource() == registrar) {
            Registro registro = new Registro(this, ficheiro);
        } else if (e.getSource() == pesquisar) {
            Pesquisa pesquisa = new Pesquisa(this, ficheiro);
        } else if (e.getSource() == deletar) {
            Deletar deletar = new Deletar(this, ficheiro);
        } else if (e.getSource() == confirmar2) {
            confirmar.doClick();
            login.deletar();
        }
    }

    public void loginSucedido(String nome) {
        menu.setEnabled(false);
        menu.setVisible(false);

        menuDelete.add(confirmar);
        menuDelete.setText("Deletar conta");
        menuDelete.add(confirmar2);
        menuDelete.setEnabled(true);
        menuDelete.setVisible(true);

        opcoes.setEnabled(true);
        sair.add(confirmar);
        sair.setText(nome);
        sair.setEnabled(true);
        sair.setVisible(true);

        ficheiro.arquivo = "user_information/" + nome.trim().toLowerCase() + ".csv";

        menuBar.add(menuDelete);
        menuBar.add(sair);

        getJMenuBar().revalidate();
        getJMenuBar().repaint();
    }
}