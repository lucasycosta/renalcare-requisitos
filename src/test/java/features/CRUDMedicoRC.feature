Feature: Cadastrar medico

  Background: 
    Given login medico
    And clicar em Cadastrar no menu na lateral
    And clicar em Medico dentro de Cadastrar
    When abrir a tela de cadastro de Medico

  @web @medico @registrarMedSuc
  Scenario Outline: Registrar Medico com sucesso
    And preencher campo com nome "<nome>" medico
    And preencher campo com email "<email>" medico
    And preencher campo com sexo "<sexo>" medico
    And preencher campo com crm "<crm>" medico
    And preencher campo com cpf "<cpf>" medico
    And preencher campo com telefone "<telefone>" medico
    And preencher campo com data "<data>" medico
    And clicar no botao Cadastrar medico
    Then retorna a mensagem "<mensagem>" para medico

    Examples: 
      | nome    | email         | sexo      | crm | cpf         | telefone    | data     | mensagem                |
      | medico1 | tst@mail.com  | Masculino | 123 | 11111111111 | 11111111111 | 01012000 | Cadastrado com sucesso! |
      | medico2 | tst2@mail.com | Feminino  | 235 | 22222222222 | 22222222222 | 01012000 | Cadastrado com sucesso! |
      | medico3 | tst3@mail.com | Masculino | 879 | 33333333333 | 11111111111 | 01012000 | Cadastrado com sucesso! |
      | medico4 | tst4@mail.com | Feminino  | 524 | 44444444444 | 11111111111 | 01012000 | Cadastrado com sucesso! |

  @web @medico @registrarMedErro
  Scenario Outline: Registrar Medico com campos em branco
    And preencher nome "<nome>" do medico
    And preencher email "<email>" do medico
    And preencher sexo "<sexo>" do medico
    And preencher crm "<crm>" medico
    And preencher cpf "<cpf>" do medico
    And preencher telefone "<telefone>" do medico
    And preencher data "<data>" do medico
    Then retorna a mensagem "<mensagem>" na tela de medico

    Examples: 
      | nome    | email        | sexo      | crm | cpf         | telefone    | data     | mensagem                                 |
      |         | tst@mail.com | Masculino | 123 | 11111111111 | 11111111111 | 01012000 | O campo Nome é obrigatório               |
      | TesteRC |              | Masculino | 123 | 22222222222 | 11111111111 | 01012000 | O campo Email é obrigatório              |
      | TesteRC | tst@mail.com |           | 123 | 33333333333 | 11111111111 | 01012000 | O campo Sexo é obrigatório               |
      | TesteRC | tst@mail.com | Masculino | 123 |             | 11111111111 | 01012000 | O campo CPF é obrigatório                |
      | TesteRC | tst@mail.com | Masculino | 123 | 11111111111 |             | 01012000 | O campo Telefone é obrigatório           |
      | TesteRC | tst@mail.com | Masculino | 123 | 11111111111 | 11111111111 |          | O campo Data de nascimento é obrigatório |
      | TesteRC | tst@mail.com | Masculino |     | 11111111111 | 11111111111 |          | O campo CRM é obrigatório                |

  @web @medico @consultarMed
  Scenario Outline: Consultar Medico cadastrado
    When rolar pagina de medico
    When buscar o medico pelo "<nome>"
    Then o retorna o nome do medico "<nome>"
    Then o retorna o email do medico "<email>"
    Then o retorna o cpf medico "<cpf>"
    Then o retorna o telefone medico "<telefone>"

    Examples: 
      | nome    | email         | cpf            | telefone        |
      | medico1 | tst@mail.com  | 111.111.111-11 | (11) 11111-1111 |
      | medico2 | tst2@mail.com | 222.222.222-22 | (22) 22222-2222 |
      | medico3 | tst3@mail.com | 333.333.333-33 | (11) 11111-1111 |
      | medico4 | tst4@mail.com | 444.444.444-44 | (11) 11111-1111 |

  @web @medico @alterarMed
  Scenario Outline: Alterar medico cadastrado
    When role pagina de medico
    When inserir "<nome>" para buscar medico
    When o registro do medico com "<nome>" retornar
    When clicar no icone de edicao de medico
    When os dados do medico serao apresentados
    Then altere o nome do medico "<nome2>"
    Then clique em Alterar medico
    Then mensagem de alteracao do cadastro "<mensagem>"

    Examples: 
      | nome    | nome2   | mensagem              |
      | medico1 | Medico1 | Alterado com sucesso! |
      | medico2 | Medico2 | Alterado com sucesso! |
      | medico3 | Medico3 | Alterado com sucesso! |
      | medico4 | Medico4 | Alterado com sucesso! |

  @web @medico @excluirMed
  Scenario Outline: Deletar medico cadastrado
    When role pagina de medico para baixo
    When insera "<nome>" no campo de busca de medico
    When o registro do medico do "<nome>" retornar
    When clicar no icone de exclusão do medico
    When clicar em SIM para desabilitar medico
    Then mensagem "<mensagem>" de desabilitar medico
    Examples: 
      | nome    | mensagem                  |
      | Medico1 | Desabilitado com sucesso! |
      | Medico2 | Desabilitado com sucesso! |
      | Medico3 | Desabilitado com sucesso! |
      | Medico4 | Desabilitado com sucesso! |
      
@web @medico @emailMedInvalido
  Scenario Outline: Email invalido medico
    And preencher o campo email invalido do medico "<email>"
    Then mensagem "<mensagem>" de email invalido medico

    Examples: 
      | email       | mensagem                               |
      | aaaaaa      | O campo Email deve ser um email válido |
      | aaaaaa@     | O campo Email deve ser um email válido |
      | aaaaaa@.com | O campo Email deve ser um email válido |
      | aaaaaa@mail | O campo Email deve ser um email válido |
      | aaaaaa.com  | O campo Email deve ser um email válido |
