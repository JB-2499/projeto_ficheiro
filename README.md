# Projeto ficheiro
Este programa consiste em um sistema de gerenciamento de ficheiros. Para utilizá-lo, cria-se uma conta de administrador de ficheiro, 
que recebe uma tabela própria para ser utilizada. No sistema é possível registrar pessoas, atualizar seus dados diretamente na tabela, 
buscar dados de uma pessoa pelo Id, vizualizar a tabela e deletar uma pessoa do registro. Para deletar a tabela inteira, pode-se deletar 
a conta de administrador ou deletar diretamente o arquivo .csv com o nome do usuário, onde após isso será criada uma nova automaticamente 
ao registrar uma pessoa.

> versão atual do programa: 2.0

> Versão Java: JDK 21
<br>

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
