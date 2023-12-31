Feature: Cadastrar Gerente

  Background: 
    Given login Gerente
    And clicar em Cadastrar no menu a esquerda
    And clicar em Gerente dentro de Cadastrar
    When abrir a tela de cadastro de gerente

  @web @gerente @registrarGerSuc
  Scenario Outline: Registrar Gerente com sucesso
    And preencher campo com nome "<nome>"
    And preencher campo com email "<email>"
    And preencher campo com sexo "<sexo>"
    And preencher campo com cpf "<cpf>"
    And preencher campo com telefone "<telefone>"
    And preencher campo com data "<data>"
    And clicar no botao Cadastrar gerente
    Then retorna a mensagem "<mensagem>" para gerente

    Examples: 
      | nome     | email         | sexo      | cpf         | telefone    | data     | mensagem                |
      | Gerente1 | tst1@mail.com | Masculino | 11111111111 | 11111111111 | 01012000 | Cadastrado com sucesso! |
      | Gerente2 | tst2@mail.com | Feminino  | 22222222222 | 22222222222 | 01012000 | Cadastrado com sucesso! |
      | Gerente3 | tst3@mail.com | Masculino | 33333333333 | 33333333333 | 01012000 | Cadastrado com sucesso! |
      | Gerente4 | tst4@mail.com | Feminino  | 44444444444 | 44444444444 | 01012000 | Cadastrado com sucesso! |

  @web @gerente @registrarGerErro
  Scenario Outline: Registrar Gerente com campos em branco
    And preencher nome "<nome>" do gerente
    And preencher email "<email>" do gerente
    And preencher sexo "<sexo>" do gerente
    And preencher cpf "<cpf>" do gerente
    And preencher telefone "<telefone>" do gerente
    And preencher data "<data>" do gerente
    Then retorna a mensagem "<mensagem>" na tela de gerente

    Examples: 
      | nome    | email        | sexo      | cpf         | telefone    | data     | mensagem                                 |
      |         | tst@mail.com | Masculino | 11111111111 | 11111111111 | 01012000 | O campo Nome é obrigatório               |
      | TesteRC |              | Masculino | 11111111111 | 11111111111 | 01012000 | O campo Email é obrigatório              |
      | TesteRC | tst@mail.com |           | 11111111111 | 11111111111 | 01012000 | O campo Sexo é obrigatório               |
      | TesteRC | tst@mail.com | Masculino |             | 11111111111 | 01012000 | O campo CPF é obrigatório                |
      | TesteRC | tst@mail.com | Masculino | 11111111111 |             | 01012000 | O campo Telefone é obrigatório           |
      | TesteRC | tst@mail.com | Masculino | 11111111111 | 11111111111 |          | O campo Data de nascimento é obrigatório |

  @web @gerente @consultarGer
  Scenario Outline: Consultar Gerente cadastrado
    When rolar pagina
    When buscar o gerente pelo "<nome>"
    Then o retorna o nome do gerente "<nome>"
    Then o retorna o email do gerente "<email>"
    Then o retorna o cpf gerente "<cpf>"
    Then o retorna o telefone gerente "<telefone>"

    Examples: 
      | nome     | email         | cpf            | telefone        |
      | Gerente1 | tst1@mail.com | 111.111.111-11 | (11) 11111-1111 |

  @web @gerente @alterarGer
  Scenario Outline: Alterar Gerente cadastrado
    When role pagina de gerente
    When inserir "<nome>" para buscar Gerente
    When o registro do gerente com "<nome>" retornar
    When clicar no icone de edicao de gerente
    When os dados do gerente serao apresentados
    Then altere o nome do gerente "<nome2>"
    Then clique em Alterar gerente
    Then mensagem de alteracao "<mensagem>"

    Examples: 
      | nome     | nome2     | mensagem              |
      | Gerente1 | Gerentee1 | Alterado com sucesso! |
      | Gerente2 | Gerentee2 | Alterado com sucesso! |
      | Gerente3 | Gerentee3 | Alterado com sucesso! |
      | Gerente4 | Gerentee4 | Alterado com sucesso! |

  @web @gerente @excluirGer
  Scenario Outline: Desabilitar Gerente cadastrado
    When role pagina para baixo
    When insera "<nome>" no campo de busca de gerente
    When o registro do gerente do "<nome>" retornar
    When clicar no icone de exclusão do gerente
    When clicar em SIM para desabilitar gerente
    Then mensagem "<mensagem>" de desabilitar gerente

    Examples: 
      | nome      | mensagem                  |
      | Gerentee1 | Desabilitado com sucesso! |
      | Gerentee2 | Desabilitado com sucesso! |
      | Gerentee3 | Desabilitado com sucesso! |
      | Gerentee4 | Desabilitado com sucesso! |

  @web @Gerico @emailGerInvalido
  Scenario Outline: Email invalido gerente
    And preencher o campo email invalido do gerente "<email>"
    Then mensagem "<mensagem>" de email invalido gerente

    Examples: 
      | email       | mensagem                               |
      | aaaaaa      | O campo Email deve ser um email válido |
      | aaaaaa@     | O campo Email deve ser um email válido |
      | aaaaaa@.com | O campo Email deve ser um email válido |
      | aaaaaa@mail | O campo Email deve ser um email válido |
      | aaaaaa.com  | O campo Email deve ser um email válido |
