import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Ficheiro {
    public String arquivo;

    public void registrar(String nomeStr, String emailStr, int idadeInt, int id) {
        List<String> linhas = new ArrayList<>();
        File file = new File(arquivo);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException a) {
            throw new RuntimeException(a);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (String l : linhas) {
                bw.write(l + "\n");
            }
            bw.write(nomeStr + "," + emailStr + "," + idadeInt + "," + id);
        } catch (IOException a) {
            throw new RuntimeException(a);
        }
    }

    public String[] pesquisar(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            File file = new File(arquivo);

            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            while ((linha = br.readLine()) != null) {
                String[] linhas = linha.split(",");
                if (id == Integer.parseInt(linhas[3])) {
                    return new String[]{linhas[0], linhas[1], linhas[2]};
                }
            }
        } catch (IOException a) {
            return new String[] {"Erro"};
        }

        return new String[] {"Erro"};
    }

    public List<String> ler() {
        List<String> dados = new ArrayList<>();
        File arquivoData = new File(arquivo);

        if (!arquivoData.exists()) {
            System.out.println("Erro! O arquivo de armazenamento de dados não existe!");
            return dados;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoData))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.startsWith("Nome") && !linha.trim().isEmpty()) {
                    dados.add(linha);
                }
            }
            return dados;

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
        }

        return dados;
    }

    public void deletar(int id) {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] linhaSeparada = linha.split(",");

                if (id == Integer.parseInt(linhaSeparada[3])) {
                    continue;
                } else {
                    linhas.add(linha);
                }
            }
        } catch (IOException a) {
            throw new RuntimeException(a);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (String l : linhas) {
                bw.write(l + "\n");
            }
        } catch (IOException a) {
            throw new RuntimeException(a);
        }
    }

    public void registrarAdmin(String nomeStr, String emailStr, String senhaStr, String[] info) {
        if (info[0].equals(emailStr)) {
            JOptionPane.showMessageDialog(null, "Email fornecido já está em uso.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            List<Admin> admins = new ArrayList<>();
            Gson gson = new Gson();
            File arquivo = new File("user_information/admin.json");

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

    public void deletarAdmin(String email) {
        List<Admin> admins = new ArrayList<>();
        Gson gson = new Gson();
        File file = new File("user_information/admin.json");

        File dadosArquivo = new File(arquivo);
        if (dadosArquivo.exists()) {
            dadosArquivo.delete();
        }

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                Type type = new TypeToken<List<Admin>>(){}.getType();
                List<Admin> lista = gson.fromJson(br.readLine(), type);

                if (lista != null) {
                    admins = lista;
                }
            } catch (IOException a) {
                throw new RuntimeException(a);
            }
        }

        boolean encontrado = admins.removeIf(admin -> admin.getEmail().equalsIgnoreCase(email));

        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                gson.toJson(admins, bw);
                JOptionPane.showMessageDialog(null, "Conta deletada com sucesso!");
            } catch (IOException a) {
                throw new RuntimeException(a);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário com este e-mail não encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
