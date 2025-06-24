package kontagro.modelo.dao.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kontagro.modelo.conexion.Conexion;
import kontagro.modelo.dao.interfaces.IUsuarioDao;
import kontagro.modelo.entidad.Usuario;

/**
 *
 * @author LeidyGiraldo
 */
public class UsuarioDao implements IUsuarioDao {

    private final Connection conexion;

    public UsuarioDao(Connection conexion) {
        this.conexion = Conexion.getConnection();
    }

    public UsuarioDao() {
        this.conexion = Conexion.getConnection();
    }

    
    // Método para validar usuario
    @Override
    public Usuario obtenerUsuario(String usuario, String contrasena) {
        Usuario user= null;
        String query = "SELECT id_usuario, usuario, contrasena, intentos_fallidos, estado"
                + "FROM usuarios "
                + "WHERE usuario = ? AND contrasena = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new Usuario();
                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("contrasena"));
                user.setIntentosFallidos(rs.getInt("intentos_fallidos"));
                user.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void actualizarIntentosFallidos(String usuario, int intentosFallidos) {
        String query = "UPDATE usuarios SET intentos_fallidos = ?"
                + " WHERE usuario = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, intentosFallidos);
            stmt.setString(2, usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bloquearUsuario(String usuario) {
        String query = "UPDATE usuarios SET estado = 'bloqueado', fecha_bloqueo = CURRENT_TIMESTAMP WHERE usuario = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resetearIntentos(String usuario) {
        String query = "UPDATE usuarios SET intentos_fallidos = 0 WHERE usuario = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
