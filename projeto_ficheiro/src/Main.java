import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String arquivo = "user_information/dados.csv";
        Scanner sc = new Scanner(System.in);

        Usuario usuario = new Usuario();

        Ficheiro ficheiro = new Ficheiro();

        while (true) {
            try {
                System.out.println("______________________");
                System.out.println("|1 =  Criar usuário  |");
                System.out.println("|2 =  Ler ficheiro   |");
                System.out.println("|3 = Alterar usuário |");
                System.out.println("|4 = Remover usuário |");
                System.out.println("|5 =      Sair       |");
                System.out.println("----------------------");
                System.out.println("\nO que deseja fazer? ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    ficheiro.criarUsuario(sc, arquivo, usuario);
                } else if (opcao == 2) {
                    ficheiro.ler(arquivo);
                } else if (opcao == 3) {
                    ficheiro.alterarUsuario(sc, arquivo, usuario, 1);
                } else if(opcao == 4) {
                    ficheiro.alterarUsuario(sc, arquivo, usuario, 2);
                } else if (opcao == 5) {
                    System.out.println("Programa finalizado com sucesso.");
                    break;
                } else {
                    System.out.println("Erro!!! Digite uma opção válida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Digite um valor válido!");
                sc.nextLine();
            }
        }
        sc. close();
    }
}