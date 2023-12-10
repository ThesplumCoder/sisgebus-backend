package models;

/**
 * Contiene las posibles clasificaciones de buses que existen en el sistema.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 * @see Bus
 */
public enum BusClassification {
  FEEDER("Alimentador"),
  PRETRUNK("Pre-troncal"),
  TRUNK("Troncal");

  /**
   * Nombre completo de la clasificación del bus.
   */
  private final String description;

  /**
   * Inicializa las clasificaciones de bus con su respectivo nombre completo.
   *
   * @param description Nombre completo de la clasificación de bus.
   */
  BusClassification(String description) {
    this.description = description;
  }

  /**
   * Retorna el nombre completo de la clasificación.
   */
  public String getDescription() {
    return description;
  }
}
