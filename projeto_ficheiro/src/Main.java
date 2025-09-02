import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String arquivo = "dados.txt";
        Scanner sc = new Scanner(System.in);

        Ficheiro ficheiro = new Ficheiro();

        while (true) {
            System.out.println("----------------------");
            System.out.println("|1 =  Criar usuário  |");
            System.out.println("|2 =  Ler ficheiro   |");
            System.out.println("|3 =      Sair       |");
            System.out.println("----------------------");
            System.out.println("\nO que deseja fazer? ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                ficheiro.criarUsuario(sc, arquivo);
            } else if (opcao == 2) {
                ficheiro.ler(arquivo);
            } else if (opcao == 3) {
                System.out.println("Programa finalizado com sucesso.");
                break;
            }
        }
        sc. close();
    }
}