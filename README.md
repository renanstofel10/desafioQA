# DesafioQA

### Objetivo do Desafio
Verificar suas habilidades em elaborar cenários de testes e em programação necessárias para automatização dos testes.

# Desafio 1

Criar um projeto de automação versionado no Github (https://github.com/), utilizando BDD e em linguagem de programação de sua preferencia os cenários para as duas funcionalidades abaixo:


1 - No site https://www.unimed.coop.br/ validar a seguinte sequência de ações:

 *   Acessar Guia Médico

 *   Realizar uma pesquisa de médicos no Rio de Janeiro.

 *   Validar a apresentação do resultados com a Especialidade e Cidade
 

2 - No mesmo site, validar:

 *    Acessar Guia Médico

 *   Realizar uma pesquisa de médicos no Rio de Janeiro.

 *   Validar nas paginas 1, 2, e 3 do resultado, NÃO apresentação do resultados com cidade São Paulo
 

 
# Desafio 2

Criar um projeto de automação versionado no Github (https://github.com/), para automatizar API utilizando framework de sua preferencia os cenários para as duas funcionalidades abaixo:

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

**Desenvolva uma solução em Ruby para atender aos critérios da história abaixo, usando TDD:**

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

O candidato deverá implementar a solução e enviar um pull request para este repositório com a solução.

*O processo de Pull Request funciona da seguinte maneira:**

* Candidato fará um fork desse repositório (não irá clonar direto!)
* Fará seu projeto nesse fork.
* Commitará e subirá as alterações para o SEU fork.
* Irá enviar um Pull Request para este repositório.

### ATENÇÃO
* Não se deve tentar fazer o PUSH diretamente para ESTE repositório!!!

### HOW TO RUN
* Descreva aqui os passos necessários para executar a automação.


