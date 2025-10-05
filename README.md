# Projeto Ferramentas com Spring Security e CRUD

Este projeto implementa um sistema de gerenciamento de ferramentas utilizando Spring Boot, Spring Security, Spring Data JPA com PostgreSQL e Thymeleaf para a interface web.

## Funcionalidades

- **Autenticação e Autorização:** Sistema de login e registro de usuários com Spring Security.
- **CRUD de Ferramentas:** Operações de Criar, Ler, Atualizar e Deletar ferramentas.
- **Banco de Dados PostgreSQL:** Persistência de dados de usuários e ferramentas.
- **Interface Web:** Páginas HTML dinâmicas com Thymeleaf para interação do usuário.
- **Lombok:** Utilizado para reduzir código boilerplate.

## Estrutura do Projeto

```
ferramentas/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/ferramentas/
│   │   │       ├── config/        # Configurações de segurança
│   │   │       ├── controller/    # Controladores MVC
│   │   │       ├── model/         # Modelos de dados (Ferramenta, User)
│   │   │       ├── repository/    # Repositórios JPA
│   │   │       └── FerramentasApplication.java # Classe principal
│   │   └── resources/
│   │       ├── static/            # Arquivos estáticos (CSS)
│   │       ├── templates/         # Templates HTML (Thymeleaf)
│   │       └── application.properties # Configurações da aplicação
├── pom.xml                      # Configurações do Maven
└── ...
```

## Como Executar

### Pré-requisitos

- Java Development Kit (JDK) 17
- Apache Maven
- PostgreSQL instalado e rodando

### Configuração do Banco de Dados

1.  **Crie o banco de dados `ferramentasdb` no PostgreSQL:**
    ```bash
    sudo -u postgres psql -c "CREATE DATABASE ferramentasdb;"
    ```
2.  **Crie o usuário `postgres` com a senha `password` (se ainda não existir) e conceda privilégios:**
    ```bash
    sudo -u postgres psql -c "ALTER USER postgres WITH PASSWORD 'password';"
    sudo -u postgres psql -c "GRANT ALL PRIVILEGES ON DATABASE ferramentasdb TO postgres;"
    ```
3.  **Configure o `pg_hba.conf` para permitir autenticação por senha:**
    Edite o arquivo `/etc/postgresql/14/main/pg_hba.conf` (o caminho pode variar dependendo da versão do PostgreSQL) e altere as linhas que contêm `scram-sha-256` para `password`.
    Exemplo:
    ```
    # IPv4 local connections:
    host    all             all             127.0.0.1/32            password
    # IPv6 local connections:
    host    all             all             ::1/128                 password
    ```
4.  **Reinicie o serviço PostgreSQL:**
    ```bash
    sudo service postgresql restart
    ```

### Passos para Rodar a Aplicação

1.  **Navegue até o diretório do projeto:**
    ```bash
    cd /home/ubuntu/ferramentas
    ```

2.  **Compile o projeto Maven:**
    ```bash
    ./mvnw clean install -DskipTests
    ```

3.  **Execute a aplicação Spring Boot:**
    ```bash
    java -jar target/*.jar
    ```

4.  **Acesse a aplicação:**
    Abra seu navegador e acesse `http://localhost:8080`.

## Telas da Aplicação

- **Página Inicial (`/`):** `index.html`
- **Login (`/login`):** `login.html`
- **Registro (`/register`):** `register.html`
- **Listagem de Ferramentas (`/ferramentas`):** `ferramentas.html`
- **Formulário de Ferramentas (`/ferramentas/new` ou `/ferramentas/edit/{id}`):** `ferramenta-form.html`

## Credenciais Padrão

Para testes, você pode registrar um novo usuário através da página `/register`.

## Deploy

Para realizar o deploy, você pode utilizar plataformas como Heroku, Render, Fly.io, entre outros. O processo de deploy varia conforme a plataforma escolhida, mas geralmente envolve:

1.  Configurar o ambiente da plataforma (JDK, PostgreSQL).
2.  Fazer o push do código para um repositório Git (GitHub, GitLab).
3.  Configurar a integração contínua/deploy contínuo na plataforma.
4.  Garantir que as variáveis de ambiente para o banco de dados estejam corretas na plataforma.

**Observação:** Para este checkpoint, o deploy não foi realizado em uma plataforma externa, mas a aplicação está pronta para ser empacotada e implantada.
