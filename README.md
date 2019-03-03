# DesafioQA

### Objetivo do Desafio
Verificar suas habilidades em elaborar cenários de testes e em programação necessárias para automatização dos testes.

# Desafio 1

Criar um projeto de automação utilizando BDD e em linguagem de programação de sua preferencia os cenários para as duas funcionalidades abaixo:


1 - No site https://www.unimed.coop.br/ validar a seguinte sequência de ações:

 *   Acessar Guia Médico

 *   Realizar uma pesquisa de médicos no Rio de Janeiro.

 *   Validar a apresentação do resultados com a Especialidade e Cidade
 

2 - No mesmo site, validar:

 *    Acessar Guia Médico

 *   Realizar uma pesquisa de médicos no Rio de Janeiro.

 *   Validar nas paginas 1, 2, e 3 do resultado, NÃO apresentação do resultados com cidade São Paulo
 

 
# Desafio 2

Criar um projeto de automação para API utilizando framework de sua preferencia os cenários para as duas funcionalidades abaixo:

EndPoint
http://www.omdbapi.com/?i=[ID_DO_FILME]&apikey=[API_KEY]

Parametros
*   ID_DO_FILME: tt1285016
*   API_KEY= 52ec71bf

**ID_DO_FILME e API_KEY deverão ser passados por variaveis GLOBAIS**

1 - No endpoint validar o response para:

 *   Titulo do Filme
 *   Ano do Filme
 *   Idioma do filme
 

2 - No endpoint validar o response para:

 *   Busca filme inexistente


# Desafio 3

**Desenvolva uma solução em linguagem de programação de sua preferencia para atender aos critérios da história abaixo, usando TDD:**

**Como** lojista

**Quero** saber quanto de desconto posso conceder no carrinho

**Para** fidelizar um cliente

Critérios
* Acima de R$ 100 e abaixo de R$ 200 => 10%
* Acima de R$ 200 e abaixo de R$ 300 => 20%
* Acima de R$ 300 e abaixo de R$ 400 => 25%
* Acima de R$ 400 => 30%
* Se existir no carrinho um filme com gênero ação somar + 5% de desconto

<img src="https://github.com/eduardocini/DesafioQA/blob/master/DesafioQA.PNG" width="500" height="280" alt="" title="" />

Regras
* Criar somente uma classe
* Carrinho será um array de int com ids dos filmes
* Passar sempre valor da compra + id do filme

### Processo de submissão

O candidato deverá implementar a solução para os 3 desafios e enviar um pull request para este repositório com a solução.

*O processo de Pull Request funciona da seguinte maneira:**

* Candidato fará um fork desse repositório (não irá clonar direto!)
* Fará seu projeto nesse fork.
* Commitará e subirá as alterações para o SEU fork.
* Irá enviar um Pull Request para este repositório.

### ATENÇÃO
* Não se deve tentar fazer o PUSH diretamente para ESTE repositório!!!

### HOW TO RUN
**Desafio 1:**
**Pré-Requisitos:** 
1. Realizar download e instalação do Eclipse e JDK disponível nos sites:
https://www.eclipse.org/downloads/
https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html

2. Instalar o plugin do Cucumber no Eclipse conforme abaixo:
https://www.toolsqa.com/cucumber/install-cucumber-eclipse-plugin/

3. Importando projeto JAVA no Eclipse:
3.1. Clique em "File > Import";
3.2. Selecione "General > Projects from Folder or Archive", em seguida clique em Next;
3.3. Clique em Directory;
3.4. Selecione o local do projeto e clique em "OK";
3.4. Clique em Finish.

**Execução:**
No diretório "src > Runner", clicar com botão direito na classe TestRunner.java e selecionar "Run As > 1 JUnit Test".

* No arquivo TestRunner.java contém as configurações de execução que estão parametrizadas por tags, leia mais no site abaixo: 
"https://www.toolsqa.com/cucumber/cucumber-tags/"



**Desafio 2:**
**Pré-Requisitos:** Configurar o Nodejs em sua máquina conforme passo a passo descrito no endereço:
https://nodejs.org/en/download/package-manager/

**Obs.:** Para verificar a instalação e versão instalada, execute o  comando abaixo no teminal:
$ node --version 

**Execução:**
*Passo 1:*
Abra o terminal de sua preferência.

*Passo 2:*
Navegue até o diretório do projeto.
Ex.: $ cd Documents/project_name

*Passo 3:*
Adicionar as dependências que serão utilizadas no projet:
$ npm install --global mocha
$ npm install supertest
$ npm install joi
$ npm install joi-assert

**Obs.:** Note que foi adicionado a pasta "node_modules" no diretório de seu projeto.

*Passo 4:*
Por fim, execute o comando abaixo para executar os testes:
$ mocha nome_arquivo.js



**Desafio 3:**
**Pré-Requisitos:** Configurar o Ruby em sua máquina conforme passo a passo descrito no endereço:
https://www.ruby-lang.org/pt/documentation/installation/

**Execução:**
*Passo 1:*
Abra o terminal de sua preferência.

*Passo 2:*
Navegue até o diretório do projeto.
Ex.: $ cd Documents/Project

*Passo 3:*
Por fim, execute o comando abaixo para executar os testes:
$ruby nome_arquivo.rb
