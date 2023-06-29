Feature: Cadastrar equipe

  Background: 
    Given login equipe
    And clicar em Cadastrar no menu da lateral
    And clicar em equipe dentro de Cadastrar
    When abrir a tela de cadastro de equipe

  @web @equipe @registrareqSuc
  Scenario Outline: Registrar equipe com sucesso
    And preencher campo com nome "<nome>" equipe
    And preencher campo com email "<email>" equipe
    And preencher campo com sexo "<sexo>" equipe
    And preencher campo com perfil "<perfil>" equipe
    And preencher campo com cpf "<cpf>" equipe
    And preencher campo com telefone "<telefone>" equipe
    And preencher campo com data "<data>" equipe
    And clicar no botao Cadastrar equipe
    Then retorna a mensagem "<mensagem>" para equipe

    Examples: 
      | nome    | email         | sexo      | perfil        | cpf         | telefone    | data     | mensagem                |
      | equipe1 | tst1@mail.com | Masculino | Enfermeira    | 11111111111 | 11111111111 | 01012000 | Cadastrado com sucesso! |
      | equipe2 | tst2@mail.com | Feminino  | Nutricionista | 22222222222 | 22222222222 | 01012000 | Cadastrado com sucesso! |
      | equipe3 | tst3@mail.com | Masculino | Estoque       | 33333333333 | 33333333333 | 01012000 | Cadastrado com sucesso! |
      | equipe4 | tst4@mail.com | Feminino  | Secretaria    | 44444444444 | 44444444444 | 01012000 | Cadastrado com sucesso! |
      | equipe5 | tst5@mail.com | Feminino  | Farmacêutico  | 55555555555 | 55555555555 | 01012000 | Cadastrado com sucesso! |
      | equipe6 | tst6@mail.com | Feminino  | Psicólogo     | 66666666666 | 66666666666 | 01012000 | Cadastrado com sucesso! |

  @web @equipe @registrareqErro
  Scenario Outline: Registrar equipe com campos em branco
    And preencher nome "<nome>" do equipe
    And preencher email "<email>" do equipe
    And preencher sexo "<sexo>" do equipe
    And preencher perfil "<perfil>" equipe
    And preencher cpf "<cpf>" do equipe
    And preencher telefone "<telefone>" do equipe
    And preencher data "<data>" do equipe
    Then retorna a mensagem "<mensagem>" na tela de equipe

    Examples: 
      | nome    | email        | sexo      | perfil        | cpf         | telefone    | data     | mensagem                                 |
      |         | tst@mail.com | Masculino | Enfermeira    | 11111111111 | 11111111111 | 01012000 | O campo Nome é obrigatório               |
      | TesteRC |              | Masculino | Enfermeira    | 11111111111 | 11111111111 | 01012000 | O campo Email é obrigatório              |
      | TesteRC | tst@mail.com |           | Nutricionista | 11111111111 | 11111111111 | 01012000 | O campo Sexo é obrigatório               |
      | TesteRC | tst@mail.com | Masculino | Secretaria    |             | 11111111111 | 01012000 | O campo CPF é obrigatório                |
      | TesteRC | tst@mail.com | Masculino | Secretaria    | 11111111111 |             | 01012000 | O campo Telefone é obrigatório           |
      | TesteRC | tst@mail.com | Masculino | Estoque       | 11111111111 | 11111111111 |          | O campo Data de nascimento é obrigatório |
      | TesteRC | tst@mail.com | Masculino |               | 11111111111 | 11111111111 |          | O campo Perfil é obrigatório             |

  @web @equipe @consultareq
  Scenario Outline: Consultar equipe cadastrado
    When rolar pagina de equipe
    When buscar o equipe pelo "<nome>"
    Then o retorna o nome do equipe "<nome>"
    Then o retorna o email do equipe "<email>"
    Then o retorna o cpf equipe "<cpf>"
    Then o retorna o telefone equipe "<telefone>"
    Then o retorna o perfil equipe "<perfil>"

    Examples: 
      | nome    | email         | cpf            | telefone        | perfil        |
      | equipe1 | tst1@mail.com | 111.111.111-11 | (11) 11111-1111 | ENFERMEIRA    |
      | equipe2 | tst2@mail.com | 222.222.222-22 | (22) 22222-2222 | NUTRICIONISTA |
      | equipe3 | tst3@mail.com | 333.333.333-33 | (33) 33333-3333 | ESTOQUE       |
      | equipe4 | tst4@mail.com | 444.444.444-44 | (44) 44444-4444 | SECRETARIA    |
      | equipe5 | tst5@mail.com | 555.555.555-55 | (44) 44444-4444 | FARMACEUTICO  |
      | equipe6 | tst6@mail.com | 666.666.666-66 | (44) 44444-4444 | PSICOLOGO     |

  @web @equipe @alterareq
  Scenario Outline: Alterar equipe cadastrado
    When role pagina de equipe
    When inserir "<nome>" para buscar equipe
    When o registro do equipe com "<nome>" retornar
    When clicar no icone de edicao de equipe
    When os dados do equipe serao apresentados
    Then altere o nome do equipe "<nome2>"
    Then clique em Alterar equipe
    Then mensagem de alteracao do cadastro da equipe "<mensagem>"

    Examples: 
      | nome    | nome2   | mensagem              |
      | equipe1 | Equipe1 | Alterado com sucesso! |
      | equipe2 | Equipe2 | Alterado com sucesso! |
      | equipe3 | Equipe3 | Alterado com sucesso! |
      | equipe4 | Equipe4 | Alterado com sucesso! |
      | equipe5 | Equipe5 | Alterado com sucesso! |
      | equipe6 | Equipe6 | Alterado com sucesso! |

  @web @equipe @excluireq
  Scenario Outline: Desabilitar equipe cadastrado
    When role pagina de equipe para baixo
    When insera "<nome>" no campo de busca de equipe
    When o registro do equipe do "<nome>" retornar
    When clicar no icone de exclusão do equipe
    #Then mensagem "<mensagem>" de desabilitar equipe
    Examples: 
      | nome    | mensagem                  |
      | Equipe1 | Desabilitado com sucesso! |
      | Equipe2 | Desabilitado com sucesso! |
      | Equipe3 | Desabilitado com sucesso! |
      | Equipe4 | Desabilitado com sucesso! |
      | Equipe5 | Desabilitado com sucesso! |
      | Equipe6 | Desabilitado com sucesso! |
      
@web @equipe @emailEqpInvalido
  Scenario Outline: Email invalido equipe
    And preencher o campo email invalido do equipe "<email>"
    Then mensagem "<mensagem>" de email invalido equipe

    Examples: 
      | email       | mensagem                               |
      | aaaaaa      | O campo Email deve ser um email válido |
      | aaaaaa@     | O campo Email deve ser um email válido |
      | aaaaaa@.com | O campo Email deve ser um email válido |
      | aaaaaa@mail | O campo Email deve ser um email válido |
      | aaaaaa.com  | O campo Email deve ser um email válido |

