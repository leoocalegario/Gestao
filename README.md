# 📌 Sistema de Gerenciamento com Spring Boot

## 📝 Descrição do Projeto

Este projeto foi desenvolvido utilizando **Java com Spring Boot** e **Maven**, na **IDE Spring Tool Suite (STS)**. O sistema permite o gerenciamento de clientes, funcionários, produtos e vendas, utilizando uma arquitetura baseada nos princípios **MVC (Model-View-Controller)**.

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Maven**
- **Banco de Dados MySQL/PostgreSQL (pode ser configurado)**
- **Lombok** (para redução de boilerplate code)

## 📂 Estrutura do Projeto

```
/src/main/java/app
│── controller/         # Controladores REST
│   ├── ClienteController.java
│   ├── FuncionarioController.java
│   ├── ProdutoController.java
│   ├── VendaController.java
│
│── entity/             # Entidades do banco de dados
│   ├── Cliente.java
│   ├── Funcionario.java
│   ├── Produto.java
│   ├── Venda.java
│
│── repository/         # Repositórios JPA para acesso ao banco
│   ├── ClienteRepository.java
│   ├── FuncionarioRepository.java
│   ├── ProdutoRepository.java
│   ├── VendaRepository.java
│
│── service/            # Lógica de negócios
│   ├── ClienteService.java
│   ├── FuncionarioService.java
│   ├── ProdutoService.java
│   ├── VendaService.java
```

## ⚙️ Configuração do Banco de Dados

1. No arquivo `application.properties`, configure as credenciais do banco:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
   spring.datasource.username=root
   spring.datasource.password=senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

2. Execute o banco de dados (caso utilize MySQL ou PostgreSQL, certifique-se de que ele está rodando).

## ▶️ Como Executar o Projeto

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```

2. **Importe o projeto no STS:**
   - `File > Import > Existing Maven Projects`

3. **Baixe as dependências:**
   ```sh
   mvn clean install
   ```

4. **Execute a aplicação:**
   ```sh
   mvn spring-boot:run
   ```

## 🛠 Endpoints Disponíveis
| Método | Endpoint             | Descrição                          |
|--------|----------------------|----------------------------------|
| GET    | `/clientes`          | Lista todos os clientes        |
| POST   | `/clientes`          | Cadastra um novo cliente       |
| GET    | `/clientes/{id}`     | Busca um cliente por ID        |
| PUT    | `/clientes/{id}`     | Atualiza os dados de um cliente |
| DELETE | `/clientes/{id}`     | Remove um cliente              |

(Endpoints semelhantes estão disponíveis para funcionários, produtos e vendas.)

## 🔥 Melhorias Futuras
- Implementação de autenticação com **JWT e Spring Security**.
- Integração com um sistema de pagamento.
- Dashboard para análise de vendas.


