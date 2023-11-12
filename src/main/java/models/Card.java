package models;

/**
 * Card modela las tarjetas de acceso que se utilizan para las registradoras que
 * están en las diferentes estaciones del STM; además, estas tarjetas también se
 * usan para pagar el pasaje de los buses.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public class Card extends UseMethod {

  /**
   * Incializa una tarjeta del STM.
   *
   * @throws NullPointerException Si ocurre una excepción en el constructor de
   *                              UseMethod.
   */
  public Card() throws NullPointerException {
    super();
    changeType();
  }
}
