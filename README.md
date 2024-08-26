# GestaoDeTarefas 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white) ![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black) 
## Sobre
Sistema de Gestão de Tarefas que permite:
- Criar tarefas, identificando título, descrição, responsável, prioridade (alta, média ou baixa) e deadline (prazo/data de entrega);
- Listar tarefas de acordo com um filtro baseando-se no: 
	- Número da tarefa;
	- Título/Descrição;
	- Responsável;
	- Situação (Em andamento ou Concluída);
- Editar tarefas;
- Excluir tarefas;
- Concluir tarefas;
- Criar usuário;
## Detalhes técnicos
### A. Java Web utilizando JavaServer Faces (JSF)
### B. Banco de dados PostgreSQL
### C. JPA com Hibernate

## Como executar
### Pré-requisitos
- JDK 11
- Apache Tomcat 9.0
- Apache Maven
- IDE Eclipse
- PostgreSQL
- Dependência JSF 2.3 (conforme o arquivo pom.xml)
- Dependência Hibernate 4.3.8 (conforme o arquivo pom.xml)
### Passos para a instalação local
1. Clone o repositório ou baixe o arquivo compactado em .zip e descompacte;
2. Abra o projeto no Eclipse;
3. Restaure as dependências com o Maven. Para isso, navegue para `Project > Update Maven Project`;
4. Configure o compilador Java. Para isso, navegue para `Project > Properties > Java Compiler` e certifique-se de estar configurado para 11;
5. Acesse o arquivo `persistence.xml` no diretório `src/main/java/META-INF` e configure as propriedades de conexão com o banco desejado;
6. Navegue para `Project > Properties > Server` e configure o Apache Tomcat 9.0;
7. Em Project Explorer, clique com o botão direito do mouse sobre o projeto e clique em `Run As > Run on Server`.