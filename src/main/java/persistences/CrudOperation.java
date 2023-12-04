package persistences;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import exceptions.CrudOperationException;
import utilities.ConnectionDB;

/**
 * Esta clase me permite utilizar las operaciones más comunes sobre la base de
 * datos, para cualquier entidad.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
public abstract class CrudOperation {
  private ConnectionDB cDB = new ConnectionDB("sisgebus_backend", "localhost:3306", "sisgebus_backend_user",
      "sisgebus_backend_pss");
  private String entity;

  /**
   * Configura el objeto para que utilice las operaciones CRUD sobre la entidad
   * que se indique.
   *
   * @param entity Nombre de la entidad como está identificada en BD.
   */
  public CrudOperation(String entity) throws CrudOperationException {
    if (!(entity.isBlank())) {
      this.entity = entity;
    } else {
      throw new CrudOperationException("The entity isn't valid.");
    }
  }

  /**
   * Retorna todos los registros de la entidad que se solicita.
   *
   * @return Todos los registros encontrados en la tabla de la entidad. Si la
   *         operación falló entonces devuelve nulo.
   */
  protected ResultSet getAll() {
    Connection conn = cDB.getConnection();
    Statement stmt;
    ResultSet rs = null;
    String selecQuery = "SELECT * FROM " + entity + ";";

    try {
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = stmt.executeQuery(selecQuery);
      return rs;
    } catch (SQLException sqlex) {
      Logger.getLogger(CrudOperation.class.getName()).log(Level.SEVERE, null, sqlex);
    } finally {
      cDB.closeConnection();
    }
    return rs;
  }

  /**
   * Inserta un registro en la tabla de la entidad.
   *
   * @param values Valores de la entidad que se quiere registrar en BD.
   */
  protected void addOne(List<String> values) {
    Connection conn = cDB.getConnection();
    Statement stmt;
    String insertQuery;

    String unitedValues = stringsCommaSprtd(values);
    insertQuery = "INSERT INTO " + entity + " VALUES (" + unitedValues + ");";
    System.out.println(insertQuery);

    try {
      stmt = conn.createStatement();
      stmt.execute(insertQuery);
    } catch (SQLException sqlex) {
      sqlex.printStackTrace();
    } finally {
      cDB.closeConnection();
    }
  }

  /**
   * Inserta un registro en la tabla de la entidad.
   *
   * @param columns Una lista con todos los nombres de columnas que se quieren
   *                tomar en cuenta para hacer la inserción. Se toma en cuenta el
   *                orden en que están en la lista.
   * @param values  Valores de la entidad que se quiere registrar en BD.
   */
  protected void addOne(List<String> columns, List<String> values) throws CrudOperationException {
    if (columns.size() != values.size()) {
      throw new CrudOperationException("The amount of columns against the values is different.");
    }

    Connection conn = cDB.getConnection();
    Statement stmt;
    String insertQuery;

    String unitedValues = stringsCommaSprtd(values);
    String unitedColumns = stringsCommaSprtd(columns);
    insertQuery = "INSERT INTO " + entity + "(" + unitedColumns + ")" + " VALUES (" + unitedValues + ");";

    try {
      stmt = conn.createStatement();
      stmt.execute(insertQuery);
    } catch (SQLException sqlex) {
      sqlex.printStackTrace();
    } finally {
      cDB.closeConnection();
    }
  }

  /**
   * Permite concantenar los elementos de una lista de palabras en un solo objeto.
   *
   * Con la lista que recibe la recorre para ir agregando cada elemento a la
   * cadena de respuesta, y a cada uno lo va separando con comas.
   *
   * @param words Lista de palabras a unir.
   * @return Cadena con todas las palabras de la lista suministrada, separadas por
   *         comas.
   */
  private String stringsCommaSprtd(List<String> words) {
    StringBuilder res = new StringBuilder();

    for (String word : words) {
      res.append(word + ",");
    }
    res.deleteCharAt(res.length() - 1);
    return res.toString();
  }

  /**
   * Elimina registros en BD según el parámetro escogido para filtrar y su valor
   * deseado para el o los registros que son objetivo.
   *
   * @param parameter Nombre de la columna por la que se desea filtrar.
   * @param value     Valor que debe tener el registro en la columna especificada
   *                  para ser tenido en cuenta en la eliminación.
   */
  protected void deleteByParameter(String parameter, String value) {
    Connection conn = cDB.getConnection();
    Statement stmt;
    String delByParam;

    delByParam = "DELETE FROM " + entity + " WHERE " + parameter + "=" + value + ";";
    try {
      stmt = conn.createStatement();
      stmt.execute(delByParam);
    } catch (SQLException sqlex) {
      sqlex.printStackTrace();
    } finally {
      cDB.closeConnection();
    }
  }
}
