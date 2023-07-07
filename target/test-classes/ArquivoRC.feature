Feature: Listagem

  Background: 
    Given login listagem
    And clicar em Arquivo

  @web @lista @pacienteDesabilitado
  Scenario Outline: listar pacientes desabilitados
    And clicar em Paciente dentro de Arquivo
    When abrir a "<pagina>" dos pacientes
    And buscar o "<nome>" do paciente
    Then o registro do paciente retorna com "<nome>", "<email>", "<cpf>" e "<data>"

    Examples: 
      | pagina                                     | nome                  | email                  | cpf            | data       |
      | http://44.201.232.138:3000/archive/patient | Paciente Desabilitado | desabilitado@gmail.com | 999.999.999-99 | 09/09/2000 |

  @web @lista @equipeDesabilitada
  Scenario Outline: listar equipe desabilitada
    And clicar em Equipe dentro de Arquivo
    When abrir a "<pagina>" da equipe
    When buscar o "<nome>" da equipe
    Then o registro da equipe retorna "<nome>", "<email>", "<cpf>", "<data>" e "<perfil>"

    Examples: 
      | pagina                                   | nome                | email                  | cpf            | data       | perfil     |
      | http://44.201.232.138:3000/archive/staff | Equipe Desabilitada | desabilitada@gmail.com | 888.888.888-88 | 09/09/2000 | ENFERMEIRA |

  @web @lista @pacienteExterno
  Scenario Outline: listar pacientes externos
    And clicar em Paciente Externo dentro de Arquivo
    Then abrir a "<pagina>" dos pacientes externos

    Examples: 
      | pagina                                                   |
      | http://44.201.232.138:3000/archive/patient?external=true |
