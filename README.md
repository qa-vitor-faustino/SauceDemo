# Automação de Testes Web do site SauceDemo com java, Selenium, Selenium WebDriver, Junit e Page Objects

Este é um projeto pessoal criado com o objetivo de estudar a automação de testes web utilizando o framework Selenium, Selenium WebDriver e o padrão de design Page Objects. O projeto visa aprimorar minhas habilidades em automação de testes, além de explorar a integração entre o Maven 3.9.4, Java 17 e o Selenium.

### Tecnologias Utilizadas

-   Java 17: A linguagem de programação utilizada para escrever os testes e as classes do projeto.

-   Maven 3.9.4: Uma ferramenta de gerenciamento de dependências e construção do projeto.

-   JUnit: Um framework de teste utilizado para criar e executar os testes automatizados.

-   Selenium: Uma ferramenta que permite a interação com páginas da web através de automação de navegador.

-   Padrão de Design Page Objects: Um padrão utilizado para organizar e encapsular a interação com os elementos da aplicação web por página.

### Estrutura do Projeto

O projeto segue a seguinte estrutura de diretórios:

    projeto-automacao-testes-web/
    ├── src/
    │   ├── test/
    │   │   ├── java/
    │   │   │   ├── methods/
    │   │   │   │   ├── testMethods.java
    │   │   │   ├── pages/
    │   │   │   │   ├── HomePage.java
    │   │   │   │   ├── ProductsPage.java
    │   │   │   ├── runner/
    │   │   │   │   ├── Browsers.java
    │   │   │   ├── tests/
    │   │   │   │   ├── HomePageTests.java
    │   │   │   │   ├── ProductsPageTests.java
    │   │   │   └── Utils/
    │   │   │       ├── DriversFactory.java
    │   │   │       └── WebUrls.java
    ├── pom.xml
    └── README.md

### Descrição dos Componentes

- methods/: Contém classes que definem métodos reutilizáveis 
para realizar ações específicas durante os testes.

- pages/: Contém as classes que representam as páginas do site, seguindo o padrão Page Object. Cada página possui métodos para interagir com os elementos da página.
- runner/: Contém configurações relacionadas à execução dos testes, como definição de navegadores.

- tests/: Contém as classes de teste que utilizam as classes de objetos de página para realizar as interações e asserções.

- Utils/: Contém classes utilitárias, como a fábrica de drivers para gerenciar a instância do WebDriver, e classes para armazenar URLs do site.

### Como Começar

1. Clone o Repositório: Clone este repositório para o seu ambiente de desenvolvimento local.

2. Configuração: Certifique-se de ter o Maven 3.9.4 e o Java 17 instalados. As dependências do projeto serão gerenciadas pelo Maven, mas você pode conferir e ajustar as versões das dependências no arquivo pom.xml.

3. Defina suas Page Objects: Crie classes para representar as páginas da aplicação em src/main/java/pages. Cada classe deve conter os elementos da página e os métodos de interação.

4. Escreva seus Testes: Crie classes de teste em src/test/java/tests, utilizando as Page Objects criadas. Essas classes conterão os cenários de teste.

5. Execute os Testes: Utilize as classes em src/test/java/runners para executar os testes. Você pode rodar os testes individualmente ou em conjunto.
