package models;

/**
 * PaymentMethod modela cada uno de los métodos de pago que soporta el sistema
 * para la compra de pasajes de bus.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
public class PaymentMethod extends NamedEntity {
  private String status;

  /**
   * Crea un método de pago que tiene un identificador, y además posee un nombre
   * de uso común que lo identifica.
   *
   * @param name Nombre del método de pago.
   * @throws NullPointerException     Si ocurrió un error en el constructor de
   *                                  NamedEntity.
   * @throws IllegalArgumentException Si ocurrió un error en el constructor de
   *                                  NamedEntity.
   */
  public PaymentMethod(String name) throws NullPointerException, IllegalArgumentException {
    super(name);

    status = "Available";
  }

  /**
   * Cambia el estado del método de pago, esto con el fin de poder activar o
   * desactivar algunos métodos en ocasiones especiales.
   *
   * Si el estado está disponible (Available) se cambia a indisponible (Not
   * Available), y viceversa.
   */
  public void changeStatus() {
    if (status.equals("Available")) {
      status = "Not available";
    } else {
      status = "Available";
    }
  }
}
