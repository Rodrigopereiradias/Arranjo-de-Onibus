Estrutura do Projeto
arranjo-onibus/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── aplication/
│   │   │   │   └── Main.java
│   │   │   ├── entity/
│   │   │   │   ├── Onibus.java
│   │   │   │   ├── Passageiro.java
│   │   │   │   └── WordGenerator.java
│   └── resources/
├── pom.xml

Descrição dos Arquivos
Main.java
Localização: src/main/java/aplication/Main.java

Descrição:

Esta é a classe principal da aplicação.
Gerencia a interface gráfica para entrada de dados dos passageiros.
Cria um objeto Onibus e preenche suas vagas com objetos Passageiro.
Exibe diálogos para entrada de dados e validação.
Mostra a relação completa de passageiros ao final.
Onibus.java
Localização: src/main/java/entity/Onibus.java

Descrição:

Representa um ônibus com um número fixo de vagas para passageiros.
Contém métodos para adicionar passageiros às vagas, mostrar o status das vagas e exibir informações detalhadas dos passageiros.
Inclui getters e setters para manipulação das variáveis vagas e totalVagas.
Passageiro.java
Localização: src/main/java/entity/Passageiro.java

Descrição:

Representa um passageiro com informações pessoais como nome, CPF, idade e sexo.
Contém um construtor para inicializar essas informações.
Inclui getters e setters para acessar e modificar as variáveis.
WordGenerator.java
Localização: src/main/java/entity/WordGenerator.java

Descrição:

Responsável por gerar um documento Word com a relação dos passageiros.
Utiliza a biblioteca Apache POI para criar e manipular o documento Word.
Cria uma tabela no documento e preenche com os dados dos passageiros.
Adiciona campos adicionais para informações do motorista e uma observação de segurança.
Salva o documento na pasta “Documentos” do usuário.
pom.xml
Localização: Raiz do projeto

Descrição:

Arquivo de configuração do Maven para o projeto.
Define as dependências necessárias, como Apache POI para manipulação de documentos Word e Log4j para logging.
Configura plugins para criar o arquivo JAR do projeto e um JAR com todas as dependências incluídas.
Especifica o identificador do grupo (groupId), o nome do artefato (artifactId) e a versão do projeto (version).
