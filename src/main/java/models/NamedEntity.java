package models;

/**
 * Esta clase es la abstracción base para todos los elementos de la aplicación a
 * los que se les puede asignar un nombre.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public abstract class NamedEntity extends Entity {
  private String name;

  /**
   * Inicializa el objeto con el identificador y un nombre.
   *
   * @param id   Identificador que se le quiere dar al objeto.
   * @param name Nombre que se le quiere dar al objeto.
   */
  protected NamedEntity(Integer id, String name) {
    super(id);
  }

  protected String getName() {
    return this.name;
  }

  protected void setName(String name) throws IllegalArgumentException {
    if (name.isBlank()) {
      String errMsg = "The name can't be empty.";
      throw new IllegalArgumentException(errMsg);
    }
    this.name = name;
  }
}
