[English](#file-manager-project)

# Projeto ficheiro
## Por: João Barreto
Este programa consiste em um sistema de gerenciamento de ficheiros, onde em cada ficheiro podem ser 
registradas e gerenciadas pessoas. O projeto foi desenvolvido com o intuito de criar um sistema 
capaz de realizar as funções de CRUD com permanência de dados e com uma interface gráfica amigável 
ao usuário, tudo isso com o objetivo final ser um desafio para por em prática meus conhecimentos 
sobre a linguagem Java.
>Status do projeto: fizalizado, com a possibilidade de eventual reabertura para melhorias futuras.

> versão atual do programa: 2.0

> Versão Java: JDK 21
<br>

# ⚙️Funcionamento
O código pode ser executado tanto da maneira tradicional, por meio de um compilador, quanto 
clicando no arquivo executável "Projeto ficheiro.exe", contido no diretório "output/artifacts/projeto_ficheiro_jar". 
Para baixar o código no computador, abra o prompt de comando e dê os seguintes comandos:

<br>

abrir a pasta da área de trabalho
~~~~html
cd desktop
~~~~

criar pasta para o projeto
~~~~html
mkdir projeto_ficheiro
~~~~

abrir pasta onde o projeto será baixado
~~~~html
cd projeto_ficheiro
~~~~

baixar projeto
~~~~html
git clone "https://github.com/JB-2499/projeto_ficheiro"
~~~~
<br>
Ao rodar o programa, pode-se observar que as opções de CRUD do ficheiro estão desabilitadas. 
Isso ocorre pois é necessário primeiramente que o usuário faça login ou crie uma conta como 
administrador de ficheiro. Ao criar uma conta e/ou fazer login, é fornecido um ficheiro privado 
à conta, que só pode ser acessado no programa pelo usuário proprietário, e são liberadas as funções 
de CRUD.
No programa existem as seguintes funcionalidades: 

<br>

Função    | O que faz
----------|-----------
Registro: | Ao selecionar está opção, é aberta uma nova janela, onde devem ser fornecidos os dados da pessoa a ser registrada, e após clicar no botão "Confirmar", a pessoa é registrada no ficheiro,possuindo um Id próprio gerado automaticamente.
Pesquisa: | Ao selecionar a opção "pesquisar", é aberta uma nova janela, onde podem ser consultados os dados de uma pessoa especifica do registro a partir de seu Id.
Tabela:   | Ao selecionar a opção "listar", é aberta uam janela contendo uma tabela com todas as pessoas registradas.
Atualizar:| As informações de uma pessoa são atualizadas dretamente na tabela da opção "listar". Porém note que o campo "Id" não pode ser alterado, pois cada Id deve ser único no sistema.
Deletar:  |Para remover uma pessoa do registro, selecione a opção "deletar", forneça o Id da pessoa a ser removida e clique no botão "Confirmar".
Limpar registro: | Para apagar completamente um ficheiro, basta deletar a conta de administrador correspondente, que é possível logando na conta e clicando no botão "deletar conta", assim, todos os dados do administrador são apagados e seu ficheiro é deletado.
<br>
  
# 🗂️Estrutura de diretórios
~~~~html

|--projeto_ficheiro
|  |--old_versions
|  |--output
|  |   |--artifacts
|  |   |   |--projeto_ficheiro_jar
|  |   |--production
|  |--src
|  |   |--gui
|  |--user_information

~~~~
diretório | função
----------|-------
projeto_ficheiro | Contém todos os arquivos e diretório necessários para rodar o programa.
old_versions | Contém a versão 1.0 e as betas do programa, que ainda não possuiam interface gráfica e contas de administrador, apenas as funcionalidades de CRUD de um único ficheiro.
output/artifacts/projeto_ficheiro_jar | Contém o ".jar" do programa, o arquivo "starter.bat", que inicia o programa sem a necessidade de abrir o compilador, e a versão executável do programa.
src | Contém todas as classes do programa e a pasta "/gui", onde ficam armazenados os arquivos de imagem utilizados pela interface.
user_information | aqui ficam armazenados os arquivos ".csv" que armazenam as informações do ficheiro de cada administrador, e o arquivo "admin.json", onde ficam registrados os dados da conta dos administradores.
<br>

# 🛠️Requisitos
Para que o programa seja executado com sucesso, devem estar instalados no computador os seguintes componentes de software:
- Versão do Java JDK 21 ou superior.
- Bibliotéca Gson para o Java.
- Bibliotéca Swing para o Java.
<br>

# 👨‍💻Alterações em relação à versão anterior:
- Implementação completa de uma interface gráfica amigável ao usuário.
- Implementação do sistema de administradores e ficheiros particulares.
<br>

# 💾Melhorias planejadas para uma eventual reabertura do projeto:
- Aprimoramento da interface gráfica.
- Adição de mais funcionalidades, como buscar pessoas por Email ou nome.
<br><br>

[Português](#projeto-ficheiro)

# File manager project
