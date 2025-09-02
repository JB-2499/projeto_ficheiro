import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ficheiro {
    public String[] lerAtributos(Scanner sc) {
        System.out.println("Digite o nome do usuario: ");
        String nome = sc.nextLine();

        System.out.println("Digite o email do usuario: ");
        String email = sc.nextLine();

        System.out.println("Digite a idade do usuario: ");
        String idade = sc.nextLine();

        String[] dados = {nome, email, idade};

        return dados;
    }

    public void criarUsuario(Scanner sc, String arquivo) {
        String[] dados = lerAtributos(sc);

        try (FileWriter fw = new FileWriter(arquivo, true)) {
            fw.write("{Nome: " + dados[0] + "; Idade: " + dados[2] + "; Email: " + dados[1] + "}\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ler(String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
        }
    }
}