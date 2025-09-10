import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ficheiro {
    public void criarUsuario(Scanner sc, String arquivo) {
        Usuario usuario = new Usuario();
        String[] dados = lerAtributos(sc, usuario, arquivo);

        boolean existe = new java.io.File(arquivo).exists();

        try (FileWriter fw = new FileWriter(arquivo, true)) {
            if (!existe) {
                fw.write("Nome,Email,Idade\n");
            }

            fw.write(dados[0] + "," + dados[1] + "," + dados[2] + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] lerAtributos(Scanner sc, Usuario usuario, String arquivo) {
        usuario.setNome(sc);

        usuario.setEmail(sc, arquivo);

        usuario.setIdade(sc);

        return new String[] {usuario.getNome(), usuario.getEmail(), Integer.toString(usuario.getIdade())};
    }

    public void ler(String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",");

                if (!linha.startsWith("Nome") && dados.length == 3) {
                    System.out.println("\nNome: " + dados[0] +  ", Email:" + dados[1] + ", Idade:" + dados[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
        }
    }
}
