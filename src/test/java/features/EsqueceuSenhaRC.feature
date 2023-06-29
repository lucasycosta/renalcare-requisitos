Feature: Esqueci Senha

  Background: 
    Given estar na tela login
    And clicar em "Esqueceu a senha?"
    When abrir a tela para digitar email

  @web @senha
  Scenario Outline: Esqueci a senha
    And digitar o "<email>"
    And clicar no botao "Esqueci a senha"
    Then mostrara a "<mensagem>"

    Examples: 
      | email                | mensagem              |
      | testesenha@gmail.com | Verifique o seu email |
      | teste@mail.com       | Email inválido        |

  @web @senha @vazio
  Scenario Outline: Campo email vazio
    And digitar "<email>"
    Then mostrara "<mensagem>"

    Examples: 
      | email | mensagem                     |
      |       | O campo E-mail é obrigatório |
