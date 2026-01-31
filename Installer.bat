@echo off
setlocal

:: Configurações
set "REPO_URL=https://github.com/JB-2499/projeto_ficheiro.git"
set "FOLDER_NAME=projeto_ficheiro"
set "SHORTCUT_NAME=Projeto Ficheiro"

echo [1/3] Clonando o repositorio...
git clone %REPO_URL%
cd %FOLDER_NAME%

echo [2/3] Organizando arquivos...
:: Garante que as pastas de dados existam
if not exist "user_information" mkdir "user_information"

:: Define os caminhos para o atalho
set "TARGET_PATH=%CD%\output\artifacts\projeto_ficheiro_jar\projeto_ficheiro.jar"
set "ICON_PATH=%CD%\src\gui\logo.png"

echo [3/3] Criando atalho na Area de Trabalho...
powershell -ExecutionPolicy Bypass -Command ^
    "$s=(New-Object -COM WScript.Shell).CreateShortcut('%USERPROFILE%\Desktop\%SHORTCUT_NAME%.lnk'); ^
    $s.TargetPath='java.exe'; ^
    $s.Arguments='-jar \"%TARGET_PATH%\"'; ^
    $s.WorkingDirectory='%CD%'; ^
    $s.IconLocation='%ICON_PATH%'; ^
    $s.Save()"

echo.
echo Concluido! O atalho '%SHORTCUT_NAME%' foi criado na sua Area de Trabalho.
pause