Feature: Login

  Background: 
    Given estar na tela de login

  @web @login @valido
  Scenario Outline: E-mail e senha válidos
    When inserir o e-mail "<email>"
    And inserir a senha "<senha>"
    And clicar no botão Entrar
    Then abrira a "<pagina>" inicial

    Examples: 
      | email                 | senha  | pagina                      |
      | lucasycosta@gmail.com | 123456 | http://44.201.232.138:3000/ |

  @web @login @invalido
  Scenario Outline: E-mail e/ou senha invalidos
    When inserir o e-mail "<email>"
    And inserir a senha "<senha>"
    And clique em Entrar
    Then apresenta "<mensagem>"

    Examples: 
      | email                 | senha  | mensagem                     |
      | lucasycosta@gmail.com | 895151 | Login e/ou senha inválido(s) |
      | teste@gmail.com       | 782166 | Login e/ou senha inválido(s) |
      | teste@gmail.com       | 123456 | Login e/ou senha inválido(s) |

  @web @login @vazio
  Scenario Outline: E-mail e/ou senha vazios ou invalidos
    When inserir um e-mail "<email>"
    And inserir uma senha "<senha>"
    Then apresenta a mensagem "<mensagem>"

    Examples: 
      | email             | senha  | mensagem                               |
      |                   | 123456 | O campo Email é obrigatório            |
      | raonikg@gmail.com |        | O campo Senha é obrigatório            |
      | teste.com         | 123456 | O campo Email deve ser um email válido |
