Feature: Framework puede conectar con base de datos

  @database
  Scenario: Puede leer y escribir de la base de datos
    Given Luka tiene un usuario registrado
    When ella pregunta por el usuario
    Then ella deberia recuperar el usuario