Feature: Cadastrar noticia

  Background: 
    Given login noticia
    And clicar em Noticia no menu
    When abrir a tela de cadastro de Noticia

  @web @noticia @registrarNotSuc
  Scenario Outline: Registrar noticia com sucesso
    And preencher campo com titulo "<titulo>"
    And preencher campo com data da publicacao "<dataPubli>"
    And preencher campo com imagem "<imagem>"
    And preencher campo com texto da noticia "<texto>"
    And clicar no botao Cadastrar noticia
    Then retorna a mensagem "<mensagem>" para noticia

    Examples: 
      | titulo   | dataPubli | imagem              | texto               | mensagem                |
      | noticia1 |  06062023 | D:\testenoticia.jpg | aaaaaaaaaaaaaaaaaaa | Cadastrado com sucesso! |
      | noticia2 |  07092022 | D:\testenoticia.jpg | aaaaaaaaaaaaaaaaaaa | Cadastrado com sucesso! |
      | noticia3 |  25112023 | D:\testenoticia.jpg | aaaaaaaaaaaaaaaaaaa | Cadastrado com sucesso! |
      | noticia4 |  01012000 | D:\testenoticia.jpg | aaaaaaaaaaaaaaaaaaa | Cadastrado com sucesso! |

  @web @noticia @registrarNotErro
  Scenario Outline: Registrar noticia com campos em branco
    And preencher tiulo "<tiulo>" da noticia
    And preencher data da publicacao "<dataPubli>" da noticia
    And preencher imagem "<imagem>" da noticia
    And preencher texto da noticia "<texto>" noticia
    Then retorna a mensagem "<mensagem>" na tela de noticia

    Examples: 
      | tiulo   | dataPubli | imagem               | texto              | mensagem                                 |
      |         |  26062023 | D:\\testenoticia.jpg | aaaaaaaaaaaaaaaaaa | O campo Título é obrigatório             |
      | TesteRC |           | D:\\testenoticia.jpg | bbbbbbbbbbbbbbbbbb | O campo Data de publicação é obrigatório |
      | TesteRC |  27072024 | D:\\testenoticia.jpg |                    | O campo Texto é obrigatório              |

  @web @noticia @consultarNot
  Scenario Outline: Consultar noticia cadastrado
    When rolar pagina de noticia
    When buscar o noticia pelo "<titulo>"
    Then o retorna o titulo da noticia "<titulo>"
    Then o retorna a data de cadastro da noticia "<dataCad>"
    Then o retorna a data de publicacao da noticia "<datapubli>"

    Examples: 
      | titulo   | dataCad    | datapubli  |
      | noticia1 | 06/07/2023 | 06/06/2023 |
      | noticia2 | 06/07/2023 | 07/09/2022 |
      | noticia3 | 06/07/2023 | 25/11/2023 |
      | noticia4 | 06/07/2023 | 01/01/2000 |

  @web @noticia @alterarNot
  Scenario Outline: Alterar noticia cadastrada
    When role pagina de noticia
    When inserir "<titulo>" para buscar noticia
    When o registro do noticia com "<titulo>" retorna
    When clicar no icone de edicao de noticia
    When os dados do noticia serao apresentados
    Then altere o nome do noticia "<titulo2>"
    Then clique em Alterar noticia
    Then mensagem de alteracao do cadastro da noticia "<mensagem>"

    Examples: 
      | titulo   | titulo2  | mensagem              |
      | noticia1 | Noticia1 | Alterado com sucesso! |
      | noticia2 | Noticia2 | Alterado com sucesso! |
      | noticia3 | Noticia3 | Alterado com sucesso! |
      | noticia4 | Noticia4 | Alterado com sucesso! |

  @web @noticia @excluirNot
  Scenario Outline: Deletar noticia cadastrado
    When role pagina de noticia para baixo
    When insera "<titulo>" no campo de busca de noticia
    When o registro do noticia do "<titulo>" retornar
    When clicar no icone de exclusão do noticia
    When clicar em SIM para deletar noticia
    Then mensagem "<mensagem>" de deletado noticia
    Examples: 
      | titulo   | mensagem              |
      | Noticia1 | Deletado com sucesso! |
      | Noticia2 | Deletado com sucesso! |
      | Noticia3 | Deletado com sucesso! |
      | Noticia4 | Deletado com sucesso! |
