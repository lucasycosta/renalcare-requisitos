Feature: Cadastrar Paciente

  Background: 
    Given login
    And clicar em Cadastrar no menu lateral
    And clicar em Paciente dentro de Cadastrar
    When abrir a tela de cadastro de paciente

  @web @paciente @registrarPacSuc
  Scenario Outline: Registrar Paciente com sucesso
    And preencher campo nome "<nome>"
    And preencher campo email "<email>"
    And preencher campo sexo "<sexo>"
    And preencher campo medico "<medico>"
    And preencher campo justificativa "<justificativa>"
    And preencher campo cpf "<cpf>"
    And preencher campo telefone "<telefone>"
    And preencher campo data "<data>"
    And preencher campo cns "<cns>"
    And clicar no botao Cadastrar paciente
    Then retornara a mensagem "<mensagem>"

    Examples: 
      | nome      | email         | sexo      | medico            | justificativa | cpf         | telefone    | data     | cns    | mensagem                |
      | Paciente1 | tst1@mail.com | Masculino | Lucas Medico Test | teste teste   | 11111111111 | 11111111111 | 01012000 | 111111 | Cadastrado com sucesso! |
      | Paciente2 | tst2@mail.com | Feminino  | Lucas Medico Test | teste         | 22222222222 | 22222222222 | 01012000 | 222222 | Cadastrado com sucesso! |
      | Paciente3 | tst3@mail.com | Masculino | Lucas Medico Test |               | 33333333333 | 33333333333 | 01012000 | 111111 | Cadastrado com sucesso! |
      | Paciente4 | tst4@mail.com | Feminino  | Lucas Medico Test | teste teste   | 44444444444 | 44444444444 | 01012000 |        | Cadastrado com sucesso! |

  @web @paciente @registrarPacErro
  Scenario Outline: Registrar Paciente com campos em branco
    And preencher nome "<nome>"
    And preencher email "<email>"
    And preencher sexo "<sexo>"
    And preencher medico "<medico>"
    And preencher cpf "<cpf>"
    And preencher telefone "<telefone>"
    And preencher data "<data>"
    Then retorna a mensagem "<mensagem>"

    Examples: 
      | nome    | email        | sexo      | medico      | justificativa | cpf         | telefone    | data     | cns    | mensagem                                 |
      |         | tst@mail.com | Masculino | KELLY LEAL  | teste teste   | 11111111111 | 11111111111 | 01012000 | 111111 | O campo Nome é obrigatório               |
      | TesteRC |              | Masculino | KELLY LEAL  | teste teste   | 11111111111 | 11111111111 | 01012000 | 111111 | O campo Email é obrigatório              |
      | TesteRC | tst@mail.com |           | KELLY LEAL  | teste teste   | 11111111111 | 11111111111 | 01012000 | 111111 | O campo Sexo é obrigatório               |
      | TesteRC | tst@mail.com | Masculino |             | teste teste   | 11111111111 | 11111111111 | 01012000 | 111111 | O campo Médico é obrigatório             |
      | TesteRC | tst@mail.com | Masculino | MedicoTeste | teste teste   |             | 11111111111 | 01012000 | 111111 | O campo CPF é obrigatório                |
      | TesteRC | tst@mail.com | Masculino | KELLY LEAL  | teste teste   | 11111111111 |             | 01012000 | 111111 | O campo Telefone é obrigatório           |
      | TesteRC | tst@mail.com | Masculino | MedicoTeste | teste teste   | 11111111111 | 11111111111 |          | 111111 | O campo Data de nascimento é obrigatório |

  @web @paciente @consultarPac
  Scenario Outline: Consultar paciente cadastrado
    When rolar a pagina
    When buscar o paciente pelo "<nome>"
    Then o retorna o nome do paciente "<nome>"
    Then o retorna o email dopaciente "<email>"
    Then o retorna o cpf paciente "<cpf>"
    Then o retorna o telefone paciente "<telefone>"

    Examples: 
      | nome      | email         | cpf            | telefone        |
      | Paciente1 | tst1@mail.com | 111.111.111-11 | (11) 11111-1111 |
      | Paciente2 | tst2@mail.com | 222.222.222-22 | (22) 22222-2222 |
      | Paciente3 | tst3@mail.com | 333.333.333-33 | (33) 33333-3333 |
      | Paciente4 | tst4@mail.com | 444.444.444-44 | (44) 44444-4444 |

  @web @paciente @alterarPac
  Scenario Outline: Alterar paciente cadastrado
    When role a pagina
    When inserir "<nome>" para buscar paciente
    When o registro do paciente com "<nome>" retornar
    When clicar no icone de edicao
    When os dados do paciente serao apresentados
    Then altere o "<nome2>"
    Then clique em Alterar
    Then mensagem "<mensagem>"

    Examples: 
      | nome      | nome2      | mensagem              |
      | Paciente1 | Paciente1. | Alterado com sucesso! |
      | Paciente2 | Paciente2. | Alterado com sucesso! |
      | Paciente3 | Paciente3. | Alterado com sucesso! |
      | Paciente4 | Paciente4. | Alterado com sucesso! |

  @web @paciente @excluirPac
  Scenario Outline: Desabilitar paciente cadastrado
    When role pagina
    When insera "<nome>" no campo de busca
    When o registro do paciente do "<nome>" retornar
    When clicar no icone de exclusão
    When clicar em SIM para desabilitar paciente
    Then mensagem "<mensagem>" para paciente

    Examples: 
      | nome       | mensagem                  |
      | Paciente1. | Desabilitado com sucesso! |
      | Paciente2. | Desabilitado com sucesso! |
      | Paciente3. | Desabilitado com sucesso! |
      | Paciente4. | Desabilitado com sucesso! |

  @web @paciente @emailPacInvalido
  Scenario Outline: Email invalido paciente
    And preencher o campo email invalido do paciente "<email>"
    Then mensagem "<mensagem>" de email invalido paciente

    Examples: 
      | email       | mensagem                               |
      | aaaaaa      | O campo Email deve ser um email válido |
      | aaaaaa@     | O campo Email deve ser um email válido |
      | aaaaaa@.com | O campo Email deve ser um email válido |
      | aaaaaa@mail | O campo Email deve ser um email válido |
      | aaaaaa.com  | O campo Email deve ser um email válido |
