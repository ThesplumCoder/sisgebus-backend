package models;

/**
 * PaymentMethod
 */
public class PaymentMethod extends NamedEntity {
  private String status;

  /**
   * Crea un método de pago que se puede identificar con un identificador y un
   * nombre.
   *
   * @param id   Identificador del método de pago.
   * @param name Nombre del método de pago.
   */
  public PaymentMethod(Integer id, String name) {
    super(id, name);
  }

  /**
   * Cambia el estado del método de pago, esto con el fin de poder activar o
   * desactivar algunos métodos en ocasiones especiales.
   */
  public void changeStatus() {
    //
  }
}
