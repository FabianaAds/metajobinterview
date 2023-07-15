#encoding: UTF-8
#language: en
  @SmokeScenario
  Feature: Login
    Como cliente cadastrado no "E-Commerce"
    Gostaria de realizar a compra de ao menos 3 produtos

  Background:
    Given Estou logado na plataforma automationexercise
  @SmokeTest
  Scenario: Adicionar produtos ao carrinho
    And Adiciono o primeiro produto ao carrinho 2x
   And Adiciono o segundo produto ao carrinho
   And Removo o produto adicionado 2x
   But Adiciono o produto removido novamente 1x
   When Realizo o pedido em Proceed to checkout
   Then Deve ser possivel realizar a compra dos produtos com sucesso.

#exemplos
