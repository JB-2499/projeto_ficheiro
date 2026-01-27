package gui;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Signin extends Conta implements ActionListener, KeyListener {
    JButton botaoCad;
    JButton botaoCancelar;

    JTextField nome;
    JTextField email;
    JPasswordField senha;

    public Signin(JFrame janela) {
        super(janela);
        this.frame.setSize(400,290);
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
            panel2.setBounds(0, 40, 384, 211);
        }

        //TextFields
        nome = new JTextField();
        nome.setBounds(90 , 20, 200, 25);
        nome.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(nome);

        email = new JTextField();
        email.setBounds(90 , 60, 200, 25);
        email.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(email);

        senha = new JPasswordField();
        senha.setBounds(90 , 100, 200, 25);
        panel2.add(senha);

        //Buttons
        botaoCad = new JButton("Cadastrar");
        {
            botaoCad.setBackground(Color.lightGray);
            botaoCad.setBounds(100, 160, 80, 30);
            botaoCad.setFont(new Font("Arial", Font.BOLD, 10));
            botaoCad.addActionListener(this);
            botaoCad.setFocusable(false);
            panel2.add(botaoCad);
        }

        botaoCancelar = new JButton("Cancelar");
        {
            botaoCancelar.setBackground(Color.lightGray);
            botaoCancelar.setFont(new Font("Arial", Font.BOLD, 10));
            botaoCancelar.setBounds(200, 160, 80, 30);
            botaoCancelar.addActionListener(this);
            botaoCancelar.setFocusable(false);
            panel2.add(botaoCancelar);
        }

        //Labels
        JLabel titulo = new JLabel("Complete o cadastro para prosseguir");
        {
            titulo.setFont(new Font("Arial", Font.BOLD, 18));
            titulo.setBackground(Color.darkGray);
            titulo.setForeground(Color.white);
            titulo.setOpaque(true);
            titulo.setBounds(27, 4, 350, 30);
            panel1.add(titulo);
        }

        JLabel textNam = new JLabel("Nome:");
        {
            textNam.setFont(new Font("Arial", Font.BOLD, 15));
            textNam.setOpaque(true);
            textNam.setBounds(44, 20, 45, 25);
            panel2.add(textNam);
        }

        JLabel textLog = new JLabel("Email:");
        {
            textLog.setFont(new Font("Arial", Font.BOLD, 15));
            textLog.setOpaque(true);
            textLog.setBounds(44, 60, 45, 25);
            panel2.add(textLog);
        }

        JLabel textSenha = new JLabel("Senha:");
        {
            textSenha.setFont(new Font("Arial", Font.BOLD, 15));
            textSenha.setOpaque(true);
            textSenha.setBounds(39, 100, 50, 25);
            panel2.add(textSenha);
        }

        this.frame.add(panel1);
        this.frame.add(panel2);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeStr = nome.getText();
        String emailStr = email.getText();
        char[] senhaChr = senha.getPassword();
        String senhaStr = new String(senhaChr);



        if (e.getSource() == botaoCad) {
            if (emailStr.isEmpty() || senhaStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] info = getUser(emailStr, senhaStr);

                if (info[0].equals(emailStr)) {
                    JOptionPane.showMessageDialog(null, "Email fornecido já está em uso.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    List<Admin> admins = new ArrayList<>();
                    Gson gson = new Gson();
                    File arquivo = new File("projeto_ficheiro/user_information/admin.json");

                    if (arquivo.exists()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                            Type type = new TypeToken<List<Admin>>(){}.getType();
                            List<Admin> lista = gson.fromJson(br.readLine(), type);

                            if (lista != null) {
                                admins = lista;
                            }
                        } catch (IOException a) {
                            throw new RuntimeException(a);
                        }
                    }

                    admins.add(new Admin(nomeStr, emailStr, senhaStr));

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
                         gson.toJson(admins, bw);
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    } catch (IOException a) {
                        throw new RuntimeException(a);
                    }
                }
            }
        } else if (e.getSource() == botaoCancelar) {
            this.frame.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

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
}
