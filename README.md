Main.java
Localização: src/main/java/aplication/Main.java

Descrição:

Classe Principal: Esta classe contém o método main, que é o ponto de entrada da aplicação.
Configuração da Interface Gráfica: Utiliza UIManager para definir o tamanho da fonte dos componentes da interface gráfica.
Criação do Objeto Onibus: Instancia um objeto Onibus com 46 vagas.
Loop de Entrada de Dados:
Cria um painel (JPanel) para entrada de dados do passageiro.
Adiciona campos de texto (JTextField) para nome, CPF, idade e sexo.
Exibe um diálogo (JOptionPane) para entrada de dados.
Valida os dados inseridos e cria um objeto Passageiro.
Adiciona o passageiro ao ônibus e exibe as informações da vaga atualizada.
Exibição da Relação Completa de Passageiros: Ao final, exibe todas as vagas preenchidas em um diálogo.
Onibus.java
Localização: src/main/java/entity/Onibus.java

Descrição:

Variáveis:
vagas: Array que armazena os passageiros nas vagas do ônibus.
totalVagas: Número total de vagas no ônibus.
Construtor: Inicializa o array de vagas com o tamanho especificado.
Métodos:
adicionaPassageiro(Passageiro passageiro, int vaga): Adiciona um passageiro a uma vaga específica, retornando true se bem-sucedido e false caso contrário.
mostraVagas(): Exibe no console o status de todas as vagas, indicando se estão ocupadas ou vazias.
mostrarInformacoesPassageiros(): Exibe no console as informações detalhadas de todos os passageiros.
Getters e Setters: Métodos para acessar e modificar as variáveis vagas e totalVagas.
Passageiro.java
Localização: src/main/java/entity/Passageiro.java

Descrição:

Variáveis:
idade: A idade do passageiro.
nome: O nome do passageiro.
cpf: O CPF do passageiro.
sexo: O sexo do passageiro (true para masculino, false para feminino).
Construtor: Inicializa as variáveis nome, cpf, idade e sexo com os valores fornecidos.
Getters e Setters: Métodos para acessar e modificar as variáveis.
WordGenerator.java
Localização: src/main/java/entity/WordGenerator.java

Descrição:

Geração de Documento Word:
Utiliza a biblioteca Apache POI para criar e manipular documentos Word.
Cria um novo documento (XWPFDocument).
Adiciona um título ao documento.
Cria uma tabela e preenche com os dados dos passageiros.
Adiciona campos adicionais para informações do motorista.
Adiciona uma observação de segurança.
Salva o documento na pasta “Documentos” do usuário.
Verifica se o arquivo foi criado com sucesso.
Método addField: Adiciona um campo de texto ao documento.
pom.xml
Localização: Raiz do projeto

Descrição:

Informações do Projeto:
<groupId>: Identificador único do grupo ou organização do projeto.
<artifactId>: Nome do artefato do projeto.
<version>: Versão do projeto.
Dependências:
org.apache.poi:poi-ooxml: Biblioteca para manipulação de documentos Word.
org.apache.logging.log4j:log4j-core e org.apache.logging.log4j:log4j-api: Bibliotecas para logging.
junit:junit: Biblioteca para testes unitários.
Build:
Plugins:
maven-jar-plugin: Plugin para criar o arquivo JAR do projeto.
maven-assembly-plugin: Plugin para criar um JAR com todas as dependências incluídas.
Bibliotecas Utilizadas
Apache POI (org.apache.poi:poi-ooxml):
Utilizada para criar e manipular documentos Word.
Permite a criação de tabelas, parágrafos, e a formatação de texto dentro do documento.
Log4j (org.apache.logging.log4j:log4j-core e org.apache.logging.log4j:log4j-api):
Utilizada para logging, ou seja, registrar informações de execução do programa.
Ajuda na depuração e monitoramento da aplicação.
JUnit (junit:junit):
Utilizada para escrever e executar testes unitários.
Ajuda a garantir que o código funcione conforme esperado.
