package persistance.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Propuestas;
import model.Usuario;
import persistance.UsuarioDAO;
import persistance.commons.ConnectionProvider;
import persistance.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Usuario toUsuario(ResultSet result) {
		try {
			return new Usuario(result.getInt(1),
							result.getString(2), 
							result.getString(3),
							result.getString(4),
							result.getInt(5) == 1,  //IsAdmin
							result.getString(6),
							result.getDouble(7),
							result.getInt(8) == 1  //Active
							);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Usuario> findAll() {
		try {
			String query = "SELECT * FROM USUARIO";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}


	@Override
	public ArrayList<Propuestas> saveItinerario(Usuario u) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			String query = "UPDATE USUARIO SET PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ? WHERE ID_USUARIO = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, u.getPresupuesto());
			statement.setDouble(2, u.getTiempo());
			statement.setInt(3, u.getIdUsuario());
			statement.executeUpdate();

			for (Propuestas comprada : u.getItinerarioUsuario()) {

				if (comprada.getEsPromo() == false) {
					String query2 = "INSERT INTO ITINERARIO (ID_USUARIO, ID_ATRACCION, ID_PROMOCION) VALUES (?, ?, ?)";
					PreparedStatement statement2 = conn.prepareStatement(query2);
					statement2.setInt(1, u.getIdUsuario());
					statement2.setInt(2, comprada.getIdAtraccion());
					statement2.setInt(3, comprada.getIdPromocion());
					statement2.executeUpdate();

					String query3 = "UPDATE ATRACCION SET CUPO = ? WHERE ID_ATRACCION = ?";
					PreparedStatement statement3 = conn.prepareStatement(query3);
					statement3.setInt(1, comprada.getCupo());
					statement3.setInt(2, comprada.getIdAtraccion());
					statement3.executeUpdate();
				}
				if (comprada.getEsPromo()) {
					for (Propuestas a : comprada.getPromoList()) {
						String query5 = "UPDATE ATRACCION SET CUPO = ? WHERE ID_ATRACCION = ?";
						PreparedStatement statement5 = conn.prepareStatement(query5);
						statement5.setInt(1, a.getCupo());
						statement5.setInt(2, a.getIdAtraccion());
						statement5.executeUpdate();

						String query2 = "INSERT INTO ITINERARIO (ID_USUARIO, ID_ATRACCION, ID_PROMOCION) VALUES (?, ?, ?)";
						PreparedStatement statement2 = conn.prepareStatement(query2);
						statement2.setInt(1, u.getIdUsuario());
						statement2.setInt(2, a.getIdAtraccion());
						statement2.setInt(3, comprada.getIdPromocion());
						statement2.executeUpdate();
					}
				}
			}

		} catch (SQLException e) {
			conn.rollback();
		} finally {
			conn.commit();
		}
		return u.getItinerarioUsuario();
	}

	@Override
	public int countAll() {
		try {
			String query = "SELECT COUNT(1) AS TOTAL FROM USUARIO";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			results.next();

			int total = results.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	// Agregar campos PASSWORD y ADMIN
	@Override
	public int insert(Usuario t) {
		try {
			String query = "INSERT INTO USUARIO (NOMBRE, PASSWORD, ADMIN, TIPO_FAVORITO, PRESUPUESTO, TIEMPO_DISPONIBLE) VALUES (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setString(2, t.getPassword());
			statement.setInt(3, t.isAdmin() ? 1 : 0);
			statement.setString(4, t.getTipoAtraccionFavorita());
			statement.setDouble(5, t.getPresupuesto());
			statement.setDouble(6, t.getTiempo());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Usuario t) {
		try {
			String query = "UPDATE USUARIO SET NOMBRE = ? SET PASSWORD = ? SET PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ? WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setString(2, t.getPassword());
			statement.setDouble(3, t.getPresupuesto());
			statement.setDouble(4, t.getTiempo());
			statement.setInt(5, t.getIdUsuario());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Integer id) {
		try {
			String query = "UPDATE USUARIO SET ACTIVE = 0 WHERE ID = ?"; // Cambiado de esta consulta a la que puse "DELETE FROM USUARIO WHERE ID_USUARIO = ?"
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario findByIdUsuario(int idUsuario) {
		try {
			String query = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idUsuario);

			ResultSet results = statement.executeQuery();

			Usuario usuario = null;
			if (results.next()) {
				usuario = toUsuario(results);
			}
			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario findByNombre(String nombre) {
		try {
			String query = "SELECT * FROM USUARIO WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nombre);

			ResultSet results = statement.executeQuery();

			Usuario usuarios = null;
			while (results.next()) {
				usuarios =(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Usuario> findByTipoFavorito(String atraccionFavorita) {
		try {
			String query = "SELECT * FROM USUARIO WHERE TIPO_FAVORITO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, atraccionFavorita);

			ResultSet results = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Usuario> findByPresupuesto(int presupuesto) {
		try {
			String query = "SELECT * FROM USUARIO WHERE PRESUPUESTO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, presupuesto);

			ResultSet results = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Usuario> findByTiempoDisponible(double tiempoDisponible) {
		try {
			String query = "SELECT * FROM USUARIO WHERE TIEMPO_DISPONIBLE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, tiempoDisponible);

			ResultSet results = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}


	@Override
	public int delete(Usuario t) {
		try {
			String query = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, t.getIdUsuario());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
