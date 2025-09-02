public class Usuario {
    private String nome;
    private String email;
    private int idade;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novo_nome) {
        while (true) {
            if (novo_nome != null) {
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

    public void setEmail(String novo_email) {
        while (true) {
            if (novo_email != null) {
                this.email = novo_email;
                break;
            } else {
                System.out.println("Erro! o email nao pode estar em branco!");
            }
        }
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int novo_idade) {
        while (true) {
            if (novo_idade >= 0) {
                this.idade = novo_idade;
                break;
            } else {
                System.out.println("Erro! não é possível ter uma idade negativa");
            }
        }
    }
}