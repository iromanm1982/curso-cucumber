Feature: Registro de un cliente

  Scenario: Cliente se registra con exito
    Given Miku quiere crear una cuenta
    When El envia la información requerida por la cuenta
    Then El deberia ver la cuenta creada

  Scenario: Cliente tiene error en el login
    Given Miku quiere crear una cuenta
    When El envia la información requerida por la cuenta
    Then El deberia ver que el registro ha fallado