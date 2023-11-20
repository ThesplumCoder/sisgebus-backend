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
   * @param name Nombre que se le quiere dar al objeto.
   * @throws NullPointerException     Si ocurrió un error con el método setName()
   *                                  o en los constructores de las superclases.
   * @throws IllegalArgumentException Si ocurrió un error con el método setName().
   */
  protected NamedEntity(String name) throws NullPointerException, IllegalArgumentException {
    super();
    setName(name);
  }

  /**
   * Retorna el nombre del objeto.
   *
   * @return Nombre en forma de texto.
   */
  protected String getName() {
    return this.name;
  }

  /**
   * Cambia el valor del nombre.
   *
   * @param name Nuevo nombre para el objeto.
   * @throws NullPointerException     Si el valor pasado como nombre apunta a
   *                                  nulo.
   * @throws IllegalArgumentException Si el texto para el nombre está vacío o solo
   *                                  contiene espacios en blanco.
   */
  protected void setName(String name) throws NullPointerException, IllegalArgumentException {
    if (name == null) {
      throw new NullPointerException("The supplied name is null.");
    }
    if (name.isBlank()) {
      throw new IllegalArgumentException("The name can't be empty.");
    }

    this.name = name;
  }
}
