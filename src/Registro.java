import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Registro extends Conta implements ActionListener, KeyListener {
    JButton botaoCad;
    JButton botaoCancelar;

    JTextField nome;
    JTextField email;
    JTextField idade;

    public Registro(JFrame janela) {
        super(janela);
        this.frame.setTitle("Registro");
        this.frame.setSize(400,290);
        this.frame.setLayout(null);

        //region Panels
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setLayout(null);
        panel1.setBackground(Color.DARK_GRAY);
        panel1.setBounds(0, 0, 400, 40);
        this.frame.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.white);
        panel2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        panel2.setOpaque(true);
        panel2.setLayout(null);
        panel2.setBounds(0, 40, 384, 211);
        this.frame.add(panel2);
        //endregion

        //region TextFields
        nome = new JTextField();
        nome.setBounds(90 , 20, 200, 25);
        nome.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(nome);

        email = new JTextField();
        email.setBounds(90 , 60, 200, 25);
        email.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(email);

        idade = new JTextField();
        idade.addKeyListener(this);
        idade.setBounds(90 , 100, 200, 25);
        idade.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(idade);
        //endregion

        //region Buttons
        botaoCad = new JButton("Cadastrar");
        botaoCad.setBackground(Color.lightGray);
        botaoCad.setBounds(100, 160, 80, 30);
        botaoCad.setFont(new Font("Arial", Font.BOLD, 10));
        botaoCad.addActionListener(this);
        botaoCad.setFocusable(false);
        panel2.add(botaoCad);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBackground(Color.lightGray);
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 10));
        botaoCancelar.setBounds(200, 160, 80, 30);
        botaoCancelar.addActionListener(this);
        botaoCancelar.setFocusable(false);
        panel2.add(botaoCancelar);
        //endregion

        //region Labels
        JLabel titulo = new JLabel("Insira os dados do indivíduo");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBackground(Color.darkGray);
        titulo.setForeground(Color.white);
        titulo.setOpaque(true);
        titulo.setBounds(70, 4, 350, 30);
        panel1.add(titulo);

        JLabel textNam = new JLabel("Nome:");
        textNam.setFont(new Font("Arial", Font.BOLD, 15));
        textNam.setOpaque(true);
        textNam.setBounds(44, 20, 45, 25);
        panel2.add(textNam);

        JLabel textLog = new JLabel("Email:");
        textLog.setFont(new Font("Arial", Font.BOLD, 15));
        textLog.setOpaque(true);
        textLog.setBounds(46, 60, 45, 25);
        panel2.add(textLog);

        JLabel textIdade = new JLabel("Idade:");
        textIdade.setFont(new Font("Arial", Font.BOLD, 15));
        textIdade.setOpaque(true);
        textIdade.setBounds(44, 100, 50, 25);
        panel2.add(textIdade);
        //endregion

        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoCancelar) {
            this.frame.dispose();
        } else if (e.getSource() == botaoCad) {
            String nomeStr = nome.getText();
            String emailStr = email.getText();
            int idadeInt = Integer.parseInt(idade.getText());
            int id = gerarId();

            if (idadeInt < 0 || idadeInt > 130) {
                JOptionPane.showMessageDialog(null, "Idade não pode ser abaixo de 0 ou acima de 130.", "Logout", JOptionPane.WARNING_MESSAGE);
            } else if (emailStr.isEmpty() || nomeStr.isEmpty() || idade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Logout", JOptionPane.WARNING_MESSAGE);
            } else {
                ficheiro.registrar(nomeStr, emailStr, idadeInt, id);

                JOptionPane.showMessageDialog(null, "Pessoa registrada com sucesso!");
                this.frame.dispose();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE))) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            botaoCad.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int gerarId() {
        try (BufferedReader br = new BufferedReader(new FileReader("user_information/dados.csv"))) {
            String linha;
            int maior = 1;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                try {
                    int idAtual =  Integer.parseInt(dados[3].trim());
                    if (idAtual >= maior) {
                        maior = idAtual + 1;
                    }
                } catch (NumberFormatException n) {
                    System.out.println("Erro ao ler Id.");
                }
            }

            return maior;
        } catch (IOException a) {
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivo", "Erro", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(a);
        }
    }
}
