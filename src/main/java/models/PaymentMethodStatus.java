package models;

/**
 * Define los posibles estados en los que se puede encontrar un método de pago.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 * @see PaymentMethod
 */
public enum PaymentMethodStatus {
  ACTIVE("Active"),
  INACTIVE("Inactive");

  /**
   * Nombre largo del estado.
   */
  private final String statusName;

  /**
   * Inicializa las constantes de los estados con sus respectivos nombres.
   *
   * @param statusName Nombre largo del estado.
   */
  PaymentMethodStatus(String statusName) {
    this.statusName = statusName;
  }

  /**
   * Retorna el nombre largo del estado.
   */
  public String getStatusName() {
    return statusName;
  }
}
