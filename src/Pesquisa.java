import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pesquisa extends Conta implements ActionListener, KeyListener {
    private JTextField id;

    private JPanel panel3;
    private JPanel panel2;

    private JLabel nome;
    private JLabel email;
    private JLabel idade;
    private JLabel idLabel;
    private JLabel textNome;
    private JLabel textEmail;
    private JLabel textIdade;

    private JButton botaoConfirmar;
    private JButton botaoCancelar;
    private JButton botaoVoltar;

    public Pesquisa (JFrame janela, Ficheiro fx) {
        super(janela);
        this.frame.setTitle("Pesquisar");
        this.ficheiro = fx;

        //region Panels
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setLayout(null);
        panel1.setBackground(Color.DARK_GRAY);
        panel1.setBounds(0, 0, 400, 40);
        this.frame.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.white);
        panel2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        panel2.setOpaque(true);
        panel2.setLayout(null);
        panel2.setBounds(0, 40, 384, 211);
        this.frame.add(panel2);

        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(Color.white);
        panel3.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        panel3.setOpaque(true);
        panel3.setLayout(null);
        panel3.setBounds(0, 40, 384, 211);
        //endregion

        //region Labels
        JLabel titulo = new JLabel("Buscar dados do indivíduo");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBackground(Color.darkGray);
        titulo.setForeground(Color.white);
        titulo.setOpaque(true);
        titulo.setBounds(85, 4, 350, 30);
        panel1.add(titulo);

        JLabel textId = new JLabel("Id:");
        textId.setFont(new Font("Arial", Font.BOLD, 15));
        textId.setOpaque(true);
        textId.setBounds(125, 80, 20, 25);
        panel2.add(textId);

        int xPos1 = 52;
        int xpos2 = 100;

        textNome = new JLabel("Nome:");
        textNome.setFont(new Font("Arial", Font.BOLD, 15));
        textNome.setOpaque(true);
        textNome.setBounds(xPos1, 50, 50, 25);

        textEmail = new JLabel("Email:");
        textEmail.setFont(new Font("Arial", Font.BOLD, 15));
        textEmail.setOpaque(true);
        textEmail.setBounds(xPos1, 90, 50, 25);

        textIdade = new JLabel("Idade:");
        textIdade.setFont(new Font("Arial", Font.BOLD, 15));
        textIdade.setOpaque(true);
        textIdade.setBounds(xPos1, 130, 50, 25);

        nome = new JLabel();
        nome.setFont(new Font("Arial", Font.BOLD, 15));
        nome.setBackground(Color.lightGray);
        nome.setForeground(Color.darkGray);
        nome.setOpaque(true);
        nome.setBounds(xpos2, 50, 200, 25);

        email = new JLabel();
        email.setFont(new Font("Arial", Font.BOLD, 15));
        email.setBackground(Color.lightGray);
        email.setForeground(Color.darkGray);
        email.setOpaque(true);
        email.setBounds(xpos2, 90, 200, 25);

        idade = new JLabel();
        idade.setFont(new Font("Arial", Font.BOLD, 15));
        idade.setBackground(Color.lightGray);
        idade.setForeground(Color.darkGray);
        idade.setOpaque(true);
        idade.setBounds(xpos2, 130, 200, 25);

        idLabel = new JLabel();
        idLabel.setFont(new Font("Arial", Font.BOLD, 18));
        idLabel.setBackground(Color.darkGray);
        idLabel.setForeground(Color.white);
        idLabel.setOpaque(true);
        idLabel.setBounds(50, 120, 200, 30);

        //endregion

        //region TextFields
        id = new JTextField();
        id.addKeyListener(this);
        id.setBounds(145 , 80, 100, 25);
        id.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(id);
        //endregion

        //region Buttons
        botaoConfirmar = new JButton("Pesquisar");
        botaoConfirmar.setBackground(Color.lightGray);
        botaoConfirmar.setBounds(95, 180, 85, 30);
        botaoConfirmar.setFont(new Font("Arial", Font.BOLD, 10));
        botaoConfirmar.addActionListener(this);
        botaoConfirmar.setFocusable(false);
        panel2.add(botaoConfirmar);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBackground(Color.lightGray);
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 10));
        botaoCancelar.setBounds(200, 180, 80, 30);
        botaoCancelar.addActionListener(this);
        botaoCancelar.setFocusable(false);
        panel2.add(botaoCancelar);

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBackground(Color.lightGray);
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 10));
        botaoVoltar.setBounds(150, 180, 80, 30);
        botaoVoltar.addActionListener(this);
        botaoVoltar.setFocusable(false);
        panel3.add(botaoVoltar);
        //endregion

        this.frame.getRootPane().setDefaultButton(botaoConfirmar);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoConfirmar) {
            int idInt = Integer.parseInt(id.getText());

            String[] dados = ficheiro.pesquisar(idInt);

            panel2.setVisible(false);
            this.frame.add(panel3);
            this.frame.getRootPane().setDefaultButton(botaoVoltar);

            nome.setText(dados[0]);
            nome.revalidate();
            nome.repaint();

            email.setText(dados[1]);
            email.revalidate();
            email.repaint();

            idade.setText(dados[2]);
            idade.revalidate();
            idade.repaint();

            panel3.add(nome);
            panel3.add(email);
            panel3.add(idade);
            panel3.add(textNome);
            panel3.add(textEmail);
            panel3.add(textIdade);

            panel3.revalidate();
            panel3.repaint();
            panel3.setVisible(true);

            this.frame.revalidate();
            this.frame.repaint();
        } else if (e.getSource() == botaoCancelar) {
            this.frame.dispose();
        } else if (e.getSource() == botaoVoltar) {
            this.frame.getRootPane().setDefaultButton(botaoConfirmar);
            panel2.setVisible(true);
            panel3.setVisible(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
