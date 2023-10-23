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

  protected Place(Integer id, String address) throws IllegalArgumentException {
    super(id);
    setAddress(address);
  }

  protected String getAddress() {
    return this.address;
  }

  protected void setAddress(String address) throws IllegalArgumentException {
    if (address.isBlank()) {
      String errMsg = "The address can't be empty.";
      throw new IllegalArgumentException(errMsg);
    }
    this.address = address;
  }
}
