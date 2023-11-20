package models;

/**
 * Esta clase es la abstracción base para todos los elementos que podemos ubicar
 * por medio de una dirección.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public abstract class Place extends Entity {
  private String address;

  /**
   * Inicializa un lugar con la dirección.
   *
   * @param address Dirección que tiene el lugar.
   * @throws NullPointerException     Si ocurre una excepción en el constructor de
   *                                  Entity.
   * @throws IllegalArgumentException Si occurre una excepción en la asignación de
   *                                  dirección.
   */
  protected Place(String address) throws NullPointerException, IllegalArgumentException {
    super();
    setAddress(address);
  }

  /**
   * Regresa el valor de la dirección.
   *
   * @return Dirección en formato de texto.
   */
  protected String getAddress() {
    return this.address;
  }

  /**
   * Cambia el valor de la dirección.
   *
   * @param address Nueva dirección en formato texto.
   * @throws IllegalArgumentException Si la dirección está en blanco o contiene
   *                                  solo espacios.
   */
  protected void setAddress(String address) throws IllegalArgumentException, NullPointerException {
    if (address == null) {
      throw new NullPointerException("The address can't be null.");
    }
    if (address.isBlank()) {
      throw new IllegalArgumentException("The address can't be empty.");
    }
    this.address = address;
  }
}
