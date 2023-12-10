package models;

/**
 * Define los posibles valores que puede tomar el tipo del método de uso.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 * @see UseMethod
 */
public enum UseMethodType {
  DIGITAL("Digital"),
  PHYSICAL("Físico");

  /**
   * Nombre largo del tipo.
   */
  private final String name;

  /**
   * Inicializa las constantes de los tipos con su respectivo nombre.
   *
   * @param name Nombre largo del tipo.
   */
  UseMethodType(String name) {
    this.name = name;
  }

  /**
   * Retorna el nombre largo del tipo.
   */
  public String getName() {
    return name;
  }
}
