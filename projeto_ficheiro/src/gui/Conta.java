package gui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Conta {
    protected JFrame frame;

    public Conta(JFrame janela) {
        frame = new JFrame("Conta");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 270);
        frame.setLocationRelativeTo(janela);

        ImageIcon logo = new ImageIcon(getClass().getResource("/gui/Gear.png"));
        frame.setIconImage(logo.getImage());
    }

    public String[] getUser(String email, String senha) {
        try (BufferedReader br = new BufferedReader(new FileReader("projeto_ficheiro/user_information/admin.json"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.contains(email) && linha.contains(senha)) {
                    return new String[] {email, senha};
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new String[] {"erro"};
    }
}