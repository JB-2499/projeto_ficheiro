# Projeto ficheiro
O presente projeto foi realizado com o intuito de desenvolver minhas habilidades com a linguagem de programação Java. Para este propósito, desenvolvi um sistema basico que contém as funções de registrar pessoas, ler as informações registradas, alterar estas informações e exclui-las, ou seja, as funções mais básicas deste tipo de aplicação.

> Versão Java: JDK 17

> versão atual do programa: 1.0

<br><br>

# ⚠️Importânte!
Após a implementação de todas as funcionalidades de CRUD estipuladas, o projeto foi dado como encerrado. Entretanto, é posspivel que seu desenvolvimento seja reaberto futuramente, para
que sejam adicionadas novas funcionalidades e/ou aprimorar as já existentes. Para dar continuidade ao meu treinamento em Java, decidi iniciar uma sequencia deste projeto, que deve
executar as mesmas funcões do atual, mas sendo desenvolvido com o uso do Spring Boot. O novo projeto está disponível no repositório a seguir: "https://github.com/JB-2499/novo_ficheiro".

<br><br>

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

<br><br>
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

<br><br>

# 👨‍💻Alterações em relação à versão anterior:
Correção dos bugs que impediam o cadastro e a alteração dos dados do usuário.

<br><br>

# 💾Melhorias planejadas para uma eventual reabertura do projeto:
Criação de uma interface visual para o uso do programa.

Alteração do formato de arquivo utilizado para armazenamento de dados, de CSV para JSON.
