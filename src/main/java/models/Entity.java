package models;

import java.util.UUID;

/**
 * Esta clase es la abstracción base para todos los elementos de la aplicación.
 *
 * Su responsabilidad es de proveer a todos los elementos el atributo de "id"
 * que permite identificar a cada instancia para cada clase.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public abstract class Entity {
  private UUID id;

  /**
   * Inicializa el objeto con el identificador.
   *
   * @throws NullPointerException Si occurrió un error en el método setId().
   */
  protected Entity() throws NullPointerException {
    setId(generateId());
  }

  /**
   * Regresa el valor del identificador.
   *
   * @return Número del UUID almacenado como identificador, convertido en una
   *         cadena de texto.
   */
  protected String getId() {
    return id.toString();
  }

  /**
   * Cambia el valor del identificador.
   *
   * @param id Nuevo número para el identificador.
   * @throws NullPointerException Si el identificador pasado apunta a nulo.
   */
  protected void setId(UUID id) throws NullPointerException {
    if (id == null) {
      throw new NullPointerException("The supplied identifier is null.");
    }
    this.id = id;
  }

  /**
   * Genera un identificador válido para la entidad.
   *
   * @return Objeto UUID que se puede utilizar como identificador.
   */
  private UUID generateId() {
    return UUID.randomUUID();
  }

  /**
   * Cambia el identificador utilizando internamente la generación de otro UUID.
   */
  protected void changeId() {
    setId(generateId());
  }
}
