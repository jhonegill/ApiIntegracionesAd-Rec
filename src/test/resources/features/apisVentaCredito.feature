@integraciones

Feature: Validar El Consumo De Las APIS De Venta Credito
  @metodoInsertarAdmisionCliente
  Scenario:  Creacion de Pre Envios
    Given registro de datos cliente credito y destinatario
    When  consume el metodo  llamado servicio InsertarAdmision
    Then  generacion de numero de preenvio
  @metodoInsertarRecogidaCliente
  Scenario: Creacion de Recogidas
    Given registro de datos cliente credito y de preenvio(s) a recoger
    When consume el metodo  llamado InsertarRecogidaCliente
    Then generacion de numero de recogida

