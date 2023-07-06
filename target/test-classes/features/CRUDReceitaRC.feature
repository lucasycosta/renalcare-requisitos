Feature: Cadastrar receita

  Background: 
    Given login receita
    And clicar em Receita
    When abrir a tela de cadastro de receita

  @web @receita @registrarreceitaSuc
  Scenario Outline: Registrar receita com sucesso
    And preencher campo com titulo "<titulo>" receita
    And preencher campo com imagem "<imagem>" receita
    And preencher campo com ingredientes "<ingredientes>" receita
    And preencher campo com preparo "<preparo>" receita
    And preencher campo com observacao "<observacao>" receita
    And clicar no botao Cadastrar receita
    Then retorna a mensagem "<mensagem>" para receita

    Examples: 
      | titulo   | imagem               | ingredientes | preparo           | observacao | mensagem                |
      | receita1 | D:\\testereceita.jpg | sal e açucar | forno e geladeira | nada       | Cadastrado com sucesso! |
      | receita2 | D:\\testereceita.jpg | sal e açucar | forno e geladeira | nada       | Cadastrado com sucesso! |
      | receita3 | D:\\testereceita.jpg | sal e açucar | forno e geladeira | nada       | Cadastrado com sucesso! |
      | receita4 | D:\\testereceita.jpg | sal e açucar | forno e geladeira |            | Cadastrado com sucesso! |

  @web @receita @registrarreceitaErro
  Scenario Outline: Registrar receita com campos em branco
    And preencher titulo "<titulo>" do receita
    And preencher imagem "<imagem>" do receita
    And preencher ingredientes "<ingredientes>" do receita
    And preencher preparo "<preparo>" receita
    And preencher observacao "<observacao>" do receita
    Then retorna a mensagem "<mensagem>" na tela de receita

    Examples: 
      | titulo   | imagem               | ingredientes | preparo           | observacao | mensagem                              |
      |          | D:\\testereceita.jpg | sal e açucar | forno e geladeira | nada       | O campo Título é obrigatório          |
      | receita3 | D:\\testereceita.jpg |              | forno e geladeira | nada       | O campo Ingredientes é obrigatório    |
      | receita4 | D:\\testereceita.jpg | sal e açucar |                   |            | O campo Modo de preparo é obrigatório |

  @web @receita @consultarreceita
  Scenario Outline: Consultar receita cadastrado
    When rolar pagina de receita
    When buscar o receita pelo "<titulo>"
    Then o retorna o titulo da receita "<titulo>"
    Then o retorna o data de cadastro do receita "<data>"

    Examples: 
      | titulo   | data       |
      | receita1 | 06/07/2023 |
      | receita2 | 06/07/2023 |
      | receita3 | 06/07/2023 |
      | receita4 | 06/07/2023 |

  @web @receita @alterarreceita
  Scenario Outline: Alterar receita cadastrado
    When role pagina de receita
    When inserir "<titulo>" para buscar receita
    When o registro do receita com "<titulo>" retornar
    When clicar no icone de edicao de receita
    When os dados do receita serao apresentados
    Then altere o titulo do receita "<titulo2>"
    Then clique em Alterar receita
    Then mensagem de alteracao do cadastro da receita "<mensagem>"

    Examples: 
      | titulo   | titulo2  | mensagem              |
      | receita1 | Receita1 | Alterado com sucesso! |
      | receita2 | Receita2 | Alterado com sucesso! |
      | receita3 | Receita3 | Alterado com sucesso! |
      | receita4 | Receita4 | Alterado com sucesso! |

  @web @receita @excluirreceita
  Scenario Outline: Desabilitar receita cadastrado
    When role pagina de receita para baixo
    When insera "<titulo>" no campo de busca de receita
    When o registro do receita do "<titulo>" retornar
    When clicar no icone de exclusão do receita
    When clicar em SIM para deletar receita
    Then mensagem "<mensagem>" de deletar receita

    Examples: 
      | titulo   | mensagem              |
      | Receita1 | Deletado com sucesso! |
      | Receita2 | Deletado com sucesso! |
      | Receita3 | Deletado com sucesso! |
      | Receita4 | Deletado com sucesso! |
