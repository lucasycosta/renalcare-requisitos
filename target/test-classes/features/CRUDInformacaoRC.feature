Feature: Cadastrar informacao

  Background: 
    Given login informacao
    And clicar em informacao
    When abrir a tela de cadastro de informacao

  @web @informacao @registrarinformacaoSuc
  Scenario Outline: Registrar informacao com sucesso
    And preencher campo com titulo "<titulo>" informacao
    And preencher campo com subtitulo "<subtitulo>" informacao
    And preencher campo com texto "<texto>" informacao
    And clicar no botao Cadastrar informacao
    Then retorna a mensagem "<mensagem>" para informacao

    Examples: 
      | titulo        | subtitulo | texto                    | mensagem                |
      | Dúvidas       | info1     | textoooooooo ooooooooooo | Cadastrado com sucesso! |
      | Farmácia      | info2     | textoooooooo ooooooooooo | Cadastrado com sucesso! |
      | Nutrição      | info3     | textoooooooo ooooooooooo | Cadastrado com sucesso! |
      | Tratamento    | info4     | textoooooooo ooooooooooo | Cadastrado com sucesso! |
      | Psicologia    | info5     | textoooooooo ooooooooooo | Cadastrado com sucesso! |
      | Renal crônica | info6     | textoooooooo ooooooooooo | Cadastrado com sucesso! |
      | Sobre rins    | info7     | textoooooooo ooooooooooo | Cadastrado com sucesso! |
      | Transplante   | info8     | textoooooooo ooooooooooo | Cadastrado com sucesso! |

  @web @informacao @registrarinformacaoErro
  Scenario Outline: Registrar informacao com campos em branco
    And preencher titulo "<titulo>" do informacao
    And preencher subtitulo "<subtitulo>" do informacao
    And preencher texto "<texto>" do informacao
    Then retorna a mensagem "<mensagem>" na tela de informacao

    Examples: 
      | titulo   | subtitulo | texto                    | mensagem                        |
      |          | info1     | textoooooooo ooooooooooo | O campo Título é obrigatório    |
      | Farmácia |           | textoooooooo ooooooooooo | O campo Subtítulo é obrigatório |
      | Nutrição | info3     |                          | O campo Texto é obrigatório     |

  @web @informacao @consultarinformacao
  Scenario Outline: Consultar informacao cadastrado
    When rolar pagina de informacao
    When buscar o informacao pelo "<subtitulo>"
    Then o retorna o titulo da informacao "<titulo>"
    Then o retorna o subtitulo da informacao "<subtitulo>"
    Then o retorna o data de cadastro do informacao "<data>"

    Examples: 
      | titulo        | subtitulo | data       |
      | Dúvidas       | info1     | 23/06/2023 |
      | Farmácia      | info2     | 23/06/2023 |
      | Nutrição      | info3     | 23/06/2023 |
      | Tratamento    | info4     | 23/06/2023 |
      | Psicologia    | info5     | 23/06/2023 |
      | Renal crônica | info6     | 23/06/2023 |
      | Sobre rins    | info7     | 23/06/2023 |
      | Transplante   | info8     | 23/06/2023 |

  @web @informacao @alterarinformacao
  Scenario Outline: Alterar informacao cadastrado
    When role pagina de informacao
    When inserir "<subtitulo>" para buscar informacao
    When o registro do informacao com "<subtitulo>" retornar
    When clicar no icone de edicao de informacao
    When os dados do informacao serao apresentados
    Then altere o titulo do informacao "<titulo>"
    Then clique em Alterar informacao
    Then mensagem de alteracao do cadastro da informacao "<mensagem>"

    Examples: 
      | titulo        | subtitulo | mensagem              |
      | Dúvidas       | info2     | Alterado com sucesso! |
      | Farmácia      | info1     | Alterado com sucesso! |
      | Nutrição      | info4     | Alterado com sucesso! |
      | Tratamento    | info3     | Alterado com sucesso! |
      | Psicologia    | info5     | Alterado com sucesso! |
      | Renal crônica | info6     | Alterado com sucesso! |
      | Sobre rins    | info8     | Alterado com sucesso! |
      | Transplante   | info7     | Alterado com sucesso! |

  @web @informacao @excluirinformacao
  Scenario Outline: Desabilitar informacao cadastrado
    When role pagina de informacao para baixo
    When insera "<subtitulo>" no campo de busca de informacao
    When o registro do informacao do "<subtitulo>" retornar
    When clicar no icone de exclusão do informacao

    #Then mensagem "<mensagem>" de desabilitar informacao
    Examples: 
      | subtitulo | mensagem                  |
      | info1     | Desabilitado com sucesso! |
      | info2     | Desabilitado com sucesso! |
      | info3     | Desabilitado com sucesso! |
      | info4     | Desabilitado com sucesso! |
      | info5     | Desabilitado com sucesso! |
      | info6     | Desabilitado com sucesso! |
      | info7     | Desabilitado com sucesso! |
      | info8     | Desabilitado com sucesso! |
