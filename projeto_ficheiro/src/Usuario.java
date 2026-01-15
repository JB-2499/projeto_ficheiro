import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
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

                if (dados[1].equalsIgnoreCase(email)) {
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

            if (novo_email != null && !novo_email.isEmpty()) {
                if (emailExiste(arquivo, novo_email)) {
                    System.out.println("Erro!!! O email digitado já existe.");
                } else if (!novo_email.contains("@")) {
                    System.out.println("Erro! Digite um email válido.");
                } else {
                    this.email = (novo_email);
                    break;
                }
            } else {
                System.out.println("Erro! O email não pode estar em branco.");
            }
        }
    }

    public void setEmail(String email) {
        this.email = (email);
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(Scanner sc) {
        while (true) {
            try {
                System.out.println("Digite a idade: ");
                int novo_idade = sc.nextInt();
                sc.nextLine();

                if (novo_idade >= 0 &&  novo_idade <= 130) {
                    this.idade = novo_idade;
                    break;
                } else {
                    System.out.println("Erro! não é possível ter uma idade negativa");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor numérico!");
                sc.nextLine();
            }
        }
    }
}
