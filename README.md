# 🚀 Locadora  SHABARAY 

> Sistema web desenvolvido em Java com Spring Boot para gerenciamento completo [alugar filmes].

---

## 🛠️ Tecnologias e Ferramentas

O projeto foi construído utilizando as seguintes tecnologias e padrões:

* **Linguagem:** [Java 17+](https://www.oracle.com/java/)
* **Framework:** [Spring Boot](https://spring.io/projects/spring-boot)
  * **Spring Web:** Criação de controladores MVC e APIs.
  * **Spring Data JPA:** Persistência e mapeamento objeto-relacional (ORM).
  * **Spring Security:** Autenticação e controle de acesso/perfis.
* **Template Engine:** [Thymeleaf](https://www.thymeleaf.org/) (Renderização de views no lado do servidor)
* **Banco de Dados:** [MySQL](https://www.mysql.com/) / MySQL Workbench
* **Gerenciador de Dependências:** [Maven](https://maven.apache.org/)
* **Controle de Versão:** Git & GitHub
* **Ambiente de Desenvolvimento:** IntelliJ IDEA

---

## 🏛️ Arquitetura do Projeto

O projeto segue o padrão arquitetural **MVC (Model-View-Controller)** em camadas, garantindo a separação de responsabilidades:

```text
src/
├── main/
│   ├── java/com/seuusuario/projeto/
│   │   ├── controller/      # Controladores web (Gerenciam as rotas HTTP)
│   │   ├── model/           # Entidades JPA (Mapeamento das tabelas do banco)
│   │   ├── repository/      # Interfaces de acesso ao banco de dados (Spring Data JPA)
│   │   ├── service/         # Regras de negócio da aplicação
│   │   └── security/        # Configurações de segurança e autenticação
│   └── resources/
│       ├── static/          # Arquivos estáticos (CSS, JS, imagens)
│       ├── templates/       # Páginas HTML (Thymeleaf)
│       └── application.properties # Configurações de conexão e do servidor
