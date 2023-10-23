package models;

/**
 * PhysicalPoint modela los puntos físicos que se pueden utilizar para hacer
 * transacciones monetarias en el sistema.
 *
 * Estos puntos físicos tienen la función de permitir la recarga de las
 * tarjetas, y el pago de los cobros que queden como pendientes en la
 * plataforma.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public class PhysicalPoint extends Place {

  public PhysicalPoint(Integer id, String address) {
    super(id, address);
  }
}
