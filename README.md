[English](#registry-manager-project)

# Projeto ficheiro
## Por: João Barreto
Este programa consiste em um sistema de gerenciamento de ficheiros, onde em cada ficheiro podem ser 
registradas e gerenciadas pessoas. O projeto foi desenvolvido com o intuito de criar um sistema 
capaz de realizar as funções de CRUD com permanência de dados e com uma interface gráfica amigável 
ao usuário, tudo isso com o objetivo final ser um desafio para por em prática meus conhecimentos 
sobre a linguagem Java.
>Status do projeto: fizalizado, com a possibilidade de eventual reabertura para melhorias futuras.

> versão atual do programa: 1.0

> Versão Java: JDK 21
<br>

# ⚙️Funcionamento
O código pode ser executado tanto da maneira tradicional, por meio de um compilador, quanto 
clicando no arquivo executável "Projeto ficheiro.exe", contido no diretório "output/artifacts/projeto_ficheiro_jar". 
Para baixar o código no computador, abra o prompt de comando e dê os seguintes comandos:

<br>

Criar pasta para o projeto:
~~~~html
mkdir projeto_ficheiro
~~~~

Abrir pasta onde o projeto será baixado:
~~~~html
cd projeto_ficheiro
~~~~

Baixar projeto:
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
- Adição de um sisteam de detecção automática de idioma, que altera o idioma do sistema de acordo com o pc do usuário.
<br><br>

[Português](#projeto-ficheiro)

# Registry manager project
## By: João Barreto

This program consists in a registry management system, where in each registry it´s possible to 
register and manage individuals. The final goal of the project was to develop a system capable 
of performing all of the basic operations of data management, Create, Read, Update and Delete 
(CRUD), and store the data in the machine, so it can be used again when needed (data permanence). 
Also, the system should have a "User-Friendly" interface. I created this project to be a practical 
challenge to apply my knowledge about the Java language, and improve my programming skills.

>Project status: Completed, with the possibility of an eventual re-opening for future improvement.

>Latest program version: 1.0

> Java version: JDK 21
<br>

# ⚙️How it works
The code can be executed both in the traditional way, by using a compilator, and by using the executable 
file named "Projeto ficheiro.exe", contained in the following directory: "output/artifacts/projeto_ficheiro_jar".
To download the code in your PC, open the command prompt by pressing "Win" + "r", writing "cmd" and pressing "enter",
then, copy and paste each of the commands below in the prompt.

<br>
Create the directory for cloning the repository:

~~~~html
mkdir projeto_ficheiro
~~~~

Open the directory:
~~~~html
cd projeto_ficheiro
~~~~

Download the project:
~~~~html
git clone "https://github.com/JB-2499/projeto_ficheiro"
~~~~
<br>

When running the program, you may observe that all of the actions are disabled. This happens 
because it's required for the user to login to the system, or register a new account if needeed. 
When the user create a new account and/or enter the system, a new proprietary registry is assigned 
to them, wich can only be acessed by it's respective owner, and only then, the management functions 
become available.
The program can execute the functions listed below:

<br>

Function    | What it does
------------|-------------
Register:   | When you select this option, a new window is opened, where the user must inform the required information about the person wich will be registered. After that, when the "confirm" button is clicked, the person will be given an unique Id and registered in the system.
Search:     | Returns the all the information about a person, wich is searched by it's Id.
List:       | Opens the table containing all the registered people.
Update:     | A person's data can be updated directly on the table opened in the function above, except by the "Id" column. This happens because "Id" is the primary key of each person, and therefore it's used by the system to reference each register.
Delete:     | To remove a specific person from the registry, the user must provide it's respective Id number and then click the "Confirm" button.
Clean Registry: | To delete the entire registry, the user must delete their account, wich is possible by loging in the system and clicking in the button labeled "delete account", then, all of the data of the user is deleted, and their proprietary registry is deleted.
<br>

# 🗂️Directory hierarchy
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
directory | function
----------|-------
projeto_ficheiro | Contains all the files needed to run the program.
old_versions | contains the beta and legacy versions of the system, wich are far more basic, lacking a proper administrations system and graphic interface for example, just the most basic functions.
output/artifacts/projeto_ficheiro_jar | Contains the program's ".jar", the "starter.bat", wich starts the program without having to open the compilator, and the executable file for the system.
src | Here are stored all the classes for the program and the "/gui" directory, that's where the image files used in the interface are stored.
user_information | Here are stored all the ".csv" files, in wich every registry is kept, and the "admin.json" file, wich stores account information for the administrators.
<br>

# 🛠️Requirements
For the Java program to be sucessfully executed, the following software components must be installed in your machine:
- Java (JDK 21 or newer).
- Gson library for Java.
- Swing library for Java.
<br>

# 👨‍💻Differences from the last version
- Implementation of a user friendly graphic interface.
- Implementation of the administrator and proprietary registry system.
<br>

# 💾Planned improvements for the next release
- Improvement of the GUI.
- Addition of more functionalities, such as searching users by email or name.
- Addition of an automatic language detection system, wich should change the program's language depending on the user's pc's utilized language.
