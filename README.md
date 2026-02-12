# Projeto ficheiro
Este programa consiste em um sistema de gerenciamento de ficheiros, onde em cada ficheiro podem ser 
registradas e gerenciadas pessoas. O projeto foi desenvolvido com o intuito de criar um sistema 
capaz de realizar as funções de CRUD com permanência de dados e com uma interface gráfica amigável 
ao usuário, tudo isso com o objetivo final ser um desafio para por em prática meus conhecimentos 
sobre a linguagem Java.
>Status do projeto: fizalizado, com a possibilidade de reabertura para melhorias futuras.

> versão atual do programa: 2.0

> Versão Java: JDK 21
<br>

# ⚙️Funcionamento
Ao rodar o programa, pode-se observar que as opções de CRUD do ficheiro estão desabilitadas. 
Isso ocorre pois é necessário primeiramente que o usuário faça login ou crie uma conta como 
administrador de ficheiro. Ao criar uma conta e/ou fazer login, é fornecido um ficheiro privado 
à conta, que só pode ser acessado no programa pelo usuário proprietário, e são liberadas as funções 
de CRUD.
No programa existem as seguintes funcionalidades:

- Registro: Ao selecionar está opção, é aberta uma nova janela, onde devem ser fornecidos os dados
  da pessoa a ser registrada, e após clicar no botão "Confirmar", a pessoa é registrada no ficheiro,
  possuindo um Id próprio gerado automaticamente.
- Pesquisa: Ao selecionar a opção "pesquisar", é aberta uma nova janela, onde podem ser consultados os
  dados de uma pessoa especifica do registro a partir de seu Id.
- Tabela: Ao selecionar a opção "listar", é aberta uam janela contendo uma tabela com todas as pessoas
  registradas.
- Atualizar: As informações de uma pessoa são atualizadas dretamente na tabela da opção "listar". Porém
  note que o campo "Id" não pode ser alterado, pois cada Id deve ser único no sistema.
- Deletar: Para remover uma pessoa do registro, selecione a opção "deletar", forneça o Id da pessoa a ser
  removida e clique no botão "Confirmar".
- Limpar registro: Para apagar completamente um ficheiro, basta deletar a conta de administrador correspondente,
  que é possível logando na conta e clicando no botão "deletar conta", assim, todos os dados do administrador são
  apagados e seu ficheiro é deletado.

# 🗂️Organização do projeto
<br><br>
|projeto_ficheiro/

README.md

### src/

|--Main.java

|--Usuario.java

|--Ficheiro.java

|--Terminal.java


|--gui/

||--Janela.Java

||--logo.png


### user_information/

|--dados.csv


### old_versions/

<br>
onde:


### src:
>Main: a classe principal, onde é executado o ficheiro.

>Usuario: aqui são definidos os métodos relacionados ao "usuário" em si, getters e setters.

>Ficheiro: aqui são definidos os métodos para armazenar e ler a informação.

>Terminal: Versão alternativa da Main, onde a interação com o programa é feita por meio do terminal.

### src/gui:
>Janela: aqui é definida a base da Janela que serve como interface gráfica.

>Logo: imagem que serve como icone da janela.

### user_information:
>dados.csv: é onde são armazenadas as informações das pessoas.

### old_versions:
>aqui ficam armazenadas as versões anteriores do programa.

<br>

# 👨‍💻Alterações em relação à versão anterior:
Correção dos bugs que impediam o cadastro e a alteração dos dados do usuário.

<br>

# 💾Melhorias planejadas para uma eventual reabertura do projeto:
Criação de uma interface visual para o uso do programa.

Alteração do formato de arquivo utilizado para armazenamento de dados, de CSV para JSON.
