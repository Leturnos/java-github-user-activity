# GitHub User Activity CLI

Uma ferramenta de linha de comando (CLI) desenvolvida em **Java 21** que consome a **API do GitHub** para exibir as atividades públicas recentes de um usuário.

Este projeto foi desenvolvido como solução para o desafio [GitHub User Activity CLI do roadmap.sh](https://roadmap.sh/projects/github-user-activity).

A aplicação busca eventos públicos, processa os dados retornados pela API e exibe um resumo formatado das interações do usuário por repositório.

---

## 🚀 Funcionalidades

- **Resumo de atividades**  
  Exibe eventos como *Push*, *Star (Watch)*, *Issues*, *Pull Requests* e outros, agrupados e formatados para leitura no terminal.

- **Segurança de tipos**  
  Utiliza um `enum` para mapear os tipos de eventos da API do GitHub, evitando comparações frágeis com `String` e lidando de forma segura com eventos desconhecidos.

- **Tratamento de erros**
  - Validação dos argumentos de entrada do CLI
  - Detecção de usuário inexistente (HTTP 404)
  - Aviso quando o limite de requisições da API é atingido (HTTP 403)

- **Execução facilitada no Windows**  
  Inclui um script `.cmd` que permite executar a aplicação como um comando nativo (`github-activity <username>`).

---

## 🛠️ Tecnologias Utilizadas

- **Java 21** – Linguagem e versão do compilador configurada no `pom.xml`
- **Maven** – Gerenciamento de dependências e automação de build
- **Jackson Databind** – Conversão de JSON da API do GitHub para objetos Java (DTOs)

---

## 📦 Build e Instalação

Antes de usar a aplicação, é necessário gerar o JAR executável.

1. Clone o repositório
2. Na raiz do projeto, execute:

```bash
mvn clean package
```
Esse comando gera um Fat JAR na pasta target/, contendo todas as dependências necessárias para execução.

---

## 💻 Como Usar

No Windows (via terminal ainda na raiz)

Utilize o comando:

```
github-activity <username>
```

OBS: Para não precisar adicionar ao PATH, utilize .\ antes de github-activity para o Windows entender que você deseja rodar o arquivo da pasta

Exemplo:

```
.\github-activity Leturnos
```

Também é possível executar diretamente o JAR:

```
java -jar target/java-github-user-activity-1.0-SNAPSHOT.jar <username>
```

---

## 📄 Exemplo de Saída

```
Output:
- Pushed 10 commit(s) to Leturnos/java-github-user-activity
- Created 1 resource(s) in Leturnos/java-github-user-activity
- Created 1 resource(s) in Leturnos/hashtag-python-journey
- Pushed 1 commit(s) to Leturnos/udemy-java-spring
- Pushed 17 commit(s) to Leturnos/rocketseat-spring-trip-planner
```

---

## 🏗️ Estrutura do Projeto

- Main.java
  
Responsável por validar a entrada do usuário e iniciar o fluxo da aplicação.

- ApiConfig.java
  
Configura o cliente HTTP, realiza a requisição à API do GitHub e trata respostas e erros.

- CliFormatter.java
  
Contém a lógica de processamento, agrupamento e formatação dos eventos para exibição no terminal.

- GitHubEventType.java

Enum responsável por mapear os tipos de eventos retornados pela API para constantes Java seguras.

- dto/
  
Contém as classes de modelo (GitHubEvent, Repo) utilizadas pelo Jackson para mapear o JSON da API.

--- 

## ⚖️ Licença

Esse projeto está sob a Licença MIT
