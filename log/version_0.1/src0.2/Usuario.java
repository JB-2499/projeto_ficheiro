import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    private int idade;

    public String getNome() {
        return this.nome;
    }

    public void setNome(Scanner sc) {
        while (true) {
            System.out.println("Digite o nome: ");
            String novo_nome = sc.nextLine();
            if (novo_nome != null && !novo_nome.isEmpty()) {
                this.nome = novo_nome;
                break;
            } else {
                System.out.println("Erro! o nome não pode estar em branco!");
            }
        }
    }

    public String getEmail() {
        return this.email;
    }

    public boolean emailExiste(String arquivo, String email) {
        boolean existe = false;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",");

                if (dados[1].equalsIgnoreCase(email + "@email.com")) {
                    existe = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo!");
        }
        return existe;
    }

    public void setEmail(Scanner sc, String arquivo) {
        while (true) {
            System.out.println("Digite o email: ");
            String novo_email = sc.nextLine();

            if (novo_email != null && !novo_email.isEmpty() && !novo_email.contains("@")) {
                if (!emailExiste(arquivo, novo_email)) {
                    this.email = (novo_email + "@email.com");
                    break;
                } else {
                    System.out.println("Erro!!! O email digitado já existe!");
                }
            } else if (novo_email == null || novo_email.isEmpty()) {
                System.out.println("Erro! o email nao pode estar em branco!");
            } else {
                System.out.println("Erro! deve ser digitado apenas o nome do email, o resto é adicionado automaticamente.");
            }
        }
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(Scanner sc) {
        while (true) {
            System.out.println("Digite a idade: ");
            int novo_idade = sc.nextInt();
            sc.nextLine();

            if (novo_idade >= 0) {
                this.idade = novo_idade;
                break;
            } else {
                System.out.println("Erro! não é possível ter uma idade negativa");
            }
        }
    }
}