Documentação do Sistema de Doações
Documentação Completa do Sistema de Doações
Introdução
O Sistema de Doações é uma API desenvolvida em Spring Boot para gerenciar campanhas,
doações, instituições de caridade, itens doados e doadores. Ele foi projetado para facilitar a
administração de doações, integrando diferentes entidades relacionadas ao processo.
1. Instruções de Configuração
1. Certifique-se de ter os seguintes pré-requisitos instalados:
- Java 11 ou superior.
- Maven.
- Banco de dados relacional (MySQL ou PostgreSQL recomendado).
2. Clone o repositório público do projeto no GitHub com o comando:
 git clone https://github.com/GustPS/projeto-doacoes.git
3. Navegue até o diretório raiz do projeto.
4. Configure o banco de dados no arquivo application.properties, fornecendo as credenciais
corretas:
spring.datasource.url=jdbc:postgresql://localhost:5432/doacoesspring.datasource.username=postgr
esspring.datasource.password=postgres
2. Como Rodar o Sistema
Documentação do Sistema de Doações
1. No diretório raiz do projeto, instale as dependências executando:
 mvn clean install
2. Inicie o sistema com o comando:
 mvn spring-boot:run
3. A API estará acessível no endereço: http://localhost:8080.
4. Você pode acessar a documentação Swagger em: http://localhost:8080/swagger-ui.html.
3. Estrutura do Projeto
O projeto segue uma arquitetura organizada em camadas:
- **Controller**: Camada que lida com as requisições HTTP e retorna respostas adequadas.
- **Service**: Contém a lógica de negócio.
- **Repository**: Gerencia a interação com o banco de dados usando Spring Data JPA.
- **Model**: Representa as entidades do banco de dados.
- **Exception Handling**: Tratamento centralizado de erros.
4. Relacionamentos das Entidades
O sistema inclui os seguintes relacionamentos principais entre entidades:
- **Campanha**:
 - Relacionada a várias doações (`@OneToMany`).
- **Doacao**:
 - Relacionada a um doador (`@ManyToOne`).
 - Relacionada a uma instituição de caridade (`@ManyToOne`).
Documentação do Sistema de Doações
- **Doador**:
 - Relacionado a múltiplas doações (`@OneToMany`).
- **InstituicaoCaridade**:
 - Relacionada a múltiplas campanhas e doações (`@OneToMany`).
- **ItemDoacao**:
 - Relacionado a várias doações (`@ManyToMany`).
5. Testando a API
Para testar a API, você pode utilizar a interface Swagger ou ferramentas como Postman.
### Exemplo de Requisição:
- **Listar todos os itens de doação**:
 Endpoint: GET /api/item-doacao
 Exemplo de Resposta:
 ```json
 [
 { "id": 1, "nome": "Roupa", "descricao": "Roupa usada", "categoria": "Vestuário" }
 ]
- **Criar um novo item de doação**:
 Endpoint: POST /api/item-doacao
 Body:
 ```json
 { "nome": "Alimentos", "descricao": "Arroz e feijão", "categoria": "Alimentação" }
 ```
- **Excluir um item de doação**:
Documentação do Sistema de Doações
 Endpoint: DELETE /api/item-doacao/{id}
