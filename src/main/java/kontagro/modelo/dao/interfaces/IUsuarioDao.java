
package kontagro.modelo.dao.interfaces;

import kontagro.modelo.entidad.Usuario;

/**
 *
 * @author LeidyGiraldo
 */
public interface IUsuarioDao {
    Usuario obtenerUsuario(String usuario, String contrasena);
    void actualizarIntentosFallidos(String usuario, int intentosFallidos);
    void bloquearUsuario(String usuario);
    void resetearIntentos(String usuario);
    
    
}
