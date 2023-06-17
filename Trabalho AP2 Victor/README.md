# Projeto - versão 1.2

- Organização do código
  - [x] Tornar todos os atributos privados (ou protegidos) e todos os métodos públicos
  - [x] Criar um pacote "entidades" e mover as classes de entidades para lá
  - [x] Criar um pacote "cli" e mover o código da classe Main (incluindo os métodos) para a classe Cli.java
- Valor do ingresso
  - [x] Alterar a classe Partida para ter um parâmetro `double valorIngresso`
  - [x] Alterar classes Ingresso, IngressoInteira e IngressoMeia para utilizarem o atributo `valorIngresso` da classe `Partida`
  - [x] Alterar o método cli.venderIngresso remover a constante do valor do ingresso
  - [x] Alterar a interface por linha de comando para, ao criar uma partida, pedir para o usuário o valor do ingresso
- CRUD Partida
  - [x] Incluir uma opção para remover uma partida a partir do seu nome
  - [x] Incluir uma opção para editar as informações de uma partida (apenas data, local e valor do ingresso)
  - [x] Altere a opção de criar uma partida para não permitir criar uma partida com nome já definido
