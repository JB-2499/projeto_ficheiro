package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Conta implements ActionListener {
    JButton botaoLog;
    JButton botaoCancelar;
    JFrame quadro;
    JTextField email;
    JPasswordField senha;

    public Login(JFrame janela) {
        super(janela);
        quadro = janela;
        this.frame.setLayout(null);

        //Panels
        JPanel panel1 = new JPanel();
        {
            panel1.setLayout(new BorderLayout());
            panel1.setLayout(null);
            panel1.setBackground(Color.DARK_GRAY);
            panel1.setBounds(0, 0, 400, 40);
        }

        JPanel panel2 = new JPanel();
        {
            panel2.setLayout(new BorderLayout());
            panel2.setBackground(Color.white);
            panel2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
            panel2.setOpaque(true);
            panel2.setLayout(null);
            panel2.setBounds(0, 40, 384, 191);
        }

        //TextFields
        email = new JTextField();
        email.setBounds(90 , 20, 200, 25);
        email.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(email);

        senha = new JPasswordField();
        senha.setBounds(90 , 60, 200, 25);
        panel2.add(senha);

        //Buttons
        botaoLog = new JButton("Login");
        {
            botaoLog.setBackground(Color.lightGray);
            botaoLog.setBounds(100, 140, 80, 30);
            botaoLog.setFont(new Font("Arial", Font.BOLD, 10));
            botaoLog.addActionListener(this);
            botaoLog.setFocusable(false);
            panel2.add(botaoLog);
        }

        botaoCancelar = new JButton("Cancelar");
        {
            botaoCancelar.setBackground(Color.lightGray);
            botaoCancelar.setFont(new Font("Arial", Font.BOLD, 10));
            botaoCancelar.setBounds(200, 140, 80, 30);
            botaoCancelar.addActionListener(this);
            botaoCancelar.setFocusable(false);
            panel2.add(botaoCancelar);
        }

        //Labels
        JLabel titulo = new JLabel("Bem-vindo de volta!");
        {
            titulo.setFont(new Font("Arial", Font.BOLD, 25));
            titulo.setBackground(Color.darkGray);
            titulo.setForeground(Color.white);
            titulo.setOpaque(true);
            titulo.setBounds(70, 4, 240, 30);
            panel1.add(titulo);
        }

        JLabel textLog = new JLabel("Email:");
        {
            textLog.setFont(new Font("Arial", Font.BOLD, 15));
            textLog.setOpaque(true);
            textLog.setBounds(44, 20, 45, 25);
            panel2.add(textLog);
        }

        JLabel textSenha = new JLabel("Senha:");
        {
            textSenha.setFont(new Font("Arial", Font.BOLD, 15));
            textSenha.setOpaque(true);
            textSenha.setBounds(39, 60, 50, 25);
            panel2.add(textSenha);
        }

        this.frame.add(panel1);
        this.frame.add(panel2);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoLog) {
            String textoEmail = email.getText();

            char[] senhaArray = senha.getPassword();
            String textoSenha = new String(senhaArray);

            String[] info = getUser(textoEmail, textoSenha);

            if (textoEmail.equalsIgnoreCase(info[0]) && textoSenha.equals(info[1])) {
                this.frame.dispose();

                if (this.quadro instanceof Janela) {
                    ((Janela) this.quadro).loginSucedido();
                }

                JOptionPane.showMessageDialog(null, "<html>Login efetuado com sucesso.<br>Bem-vindo!</html>");
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha errados!");
            }
        } else if (e.getSource() == botaoCancelar) {
            this.frame.dispose();
        }
    }
}
