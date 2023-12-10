package models;

/**
 * PaymentMethod modela cada uno de los métodos de pago que soporta el sistema
 * para la compra de pasajes de bus.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
public class PaymentMethod extends NamedEntity {
  private PaymentMethodStatus status;

  /**
   * Crea un método de pago que tiene un identificador, y además posee un nombre
   * de uso común que lo identifica.
   *
   * @param id     Identificador numérico autogenerado por la BD.
   * @param name   Nombre del método de pago.
   * @param status Estado del método de pago.
   * @throws NullPointerException     Si ocurrió un error en el constructor de
   *                                  NamedEntity.
   * @throws IllegalArgumentException Si ocurrió un error en el constructor de
   *                                  NamedEntity.
   */
  public PaymentMethod(Integer id, String name, PaymentMethodStatus status)
      throws NullPointerException, IllegalArgumentException {
    super(id, name);
    setStatus(status);
  }

  /**
   * Retorna el estado.
   *
   * @return Constante de la enumeración que representa el estado.
   */
  public PaymentMethodStatus getStatus() {
    return status;
  }

  /**
   * Cambia el estado.
   *
   * @param status Nuevo estado para el método de pago.
   * @see PaymentMethodStatus
   */
  public void setStatus(PaymentMethodStatus status) {
    if (status == null) {
      throw new NullPointerException("The status can't be null.");
    }

    this.status = status;
  }
}
