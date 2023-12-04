package persistences;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import exceptions.BusException;
import exceptions.CrudOperationException;
import models.Bus;

/**
 * BusData permite traer todos los registros de los buses de base de datos y
 * mapearlos en objetos para poder utilizarlos.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
public class BusData extends CrudOperation {

  /**
   * Crea el mapeador de clientes, y informa a la superclase que la entidad que va
   * a manejar es la del cliente.
   */
  public BusData() throws CrudOperationException {
    super("client");
  }

  /**
   * Retorna una lista con todos los buses que se trajeron desde la base de datos,
   * convertidos en objetos.
   *
   * @return Una lista de buses.
   */
  public List<Bus> getAllBuses() {
    List<Bus> buses = new ArrayList<>();
    Bus b;
    String id;
    String licensePlate;
    String type;
    List<String> helps;
    ResultSet rs = getAll();

    if (rs != null) {
      try {
        while (rs.next()) {
          id = rs.getString("id");
          licensePlate = rs.getString("license_plate");
          type = rs.getString("telephone_number");
          c = new Client(id, name, telephoneNumber);
          clients.add(c);
        }
      } catch (SQLException sqlex) {
        Logger.getLogger(ClientData.class.getName()).log(Level.SEVERE, null, sqlex);
      } catch (ClientException clex) {
        System.out.println(clex.getMessage());
      }
    }
    return clients;
  }

  /**
   * Inserta un cliente en la BD con los datos especificados.
   *
   * @param id              Identificador único del cliente nuevo.
   * @param name            Nombre del cliente nuevo.
   * @param telephoneNumber Número telefónico del cliente nuevo.
   */
  public void addOneClient(Long id, String name, String telephoneNumber) {
    List<String> data = new ArrayList<String>();
    data.add(id.toString());
    data.add("\"" + name + "\"");
    data.add("\"" + telephoneNumber + "\"");

    addOne(data);
  }

  /**
   * Elimina un cliente utilizando su identificador único.
   *
   * @param id Identificador único del cliente que se desea eliminar.
   */
  public void deleteById(Long id) {
    String idStr = id.toString();

    deleteByParameter("id", idStr);
  }
}
