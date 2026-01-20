import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ficheiro {
    public void criarUsuario(Scanner sc, String arquivo, Usuario usuario) {
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

    public void alterarUsuario(Scanner sc, String arquivo, Usuario usuario, int operacao) {
        System.out.println("Digite o email completo do usuário a ser selecionado: ");
        String email = sc.nextLine().toLowerCase();

        List<String> linhasAtualizadas = new ArrayList<>();
        boolean usuarioEncontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                if (linha.startsWith("Nome")) {
                    linhasAtualizadas.add(linha);
                    continue;
                }

                String[] dados = linha.split(",");

                if (dados.length > 1 && (dados[1].equalsIgnoreCase(email) || (dados[1] + "@email.com").equalsIgnoreCase(email))) {
                    if (operacao == 1) {
                        usuarioEncontrado = true;

                        System.out.println("Usuário encontrado! Digite os novos dados:");

                        String[] dados_atualizados = lerAtributos(sc, usuario, arquivo);

                        String linha_atualizada = String.join(",", dados_atualizados);
                        linhasAtualizadas.add(linha_atualizada);
                    } else if (operacao == 2) {
                        usuarioEncontrado = true;
                        System.out.println("Usuário removido com sucesso!");
                    }
                } else {
                    linhasAtualizadas.add(linha);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (usuarioEncontrado) {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(arquivo))) {
                for (String linha : linhasAtualizadas) {
                    bf.write(linha + "\n");
                }

                System.out.println("Informações atualizadas com sucesso!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Usuário não encontrado.");
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

            int linhas = 0;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",");

                if (dados.length == 3 && !linha.startsWith("Nome")) {
                    System.out.println("\nNome: " + dados[0] +  ", Email:" + dados[1] + ", Idade:" + dados[2]);
                    linhas++;
                }
            }

            if (linhas == 0) {
                System.out.println("Lista vazia.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
        }
    }
}
