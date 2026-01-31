import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Conta {
    protected JFrame frame;
    protected Ficheiro ficheiro;

    public Conta(JFrame janela) {
        frame = new JFrame("Conta");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 270);
        frame.setLocationRelativeTo(janela);
        this.ficheiro = new Ficheiro();

        ImageIcon logo = new ImageIcon(getClass().getResource("/gui/Gear.png"));
        frame.setIconImage(logo.getImage());
    }

    public String[] getUser(String email, String senha) {
        try (BufferedReader br = new BufferedReader(new FileReader("user_information/admin.json"))) {
            Gson gson = new Gson();

            Type lista = new TypeToken<List<Admin>>(){}.getType();
            List<Admin> admins = gson.fromJson(br, lista);

            if (admins == null) {
                admins = new ArrayList<>();
            }

            for (Admin admin : admins) {
                if (admin.getEmail().equalsIgnoreCase(email) && admin.getSenha().equals(senha)) {
                    return new String[]{admin.getNome(), admin.getEmail(), admin.getSenha()};
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new String[] {"erro"};
    }
}