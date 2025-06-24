
package kontagro.controlador.clases;

import kontagro.modelo.dao.clases.UsuarioDao;
import kontagro.modelo.entidad.Usuario;
import kontagro.vista.login.FrmLogin;

/**
 *
 * @author LeidyGiraldo
 */
public class LoginControlador {
    
   private final UsuarioDao usuarioDAO;
   private final FrmLogin vistaLogin;  

    public LoginControlador(UsuarioDao usuarioDAO, FrmLogin vistaLogin) {
        this.usuarioDAO = usuarioDAO;
        this.vistaLogin = vistaLogin;
    }
   
       public void validarLogin() {
         String user = vistaLogin.getUsuario();
         String password = vistaLogin.getPassword();
           
        Usuario usuario = usuarioDAO.obtenerUsuario(user, password);

        if (usuario == null || usuario.getEstado().equals("bloqueado")) {
            System.out.println("Usuario bloqueado o no existe.");
          
        }

//        if (BCrypt.checkpw(password, user.getContrasena())) {
//            usuarioDAO.resetearIntentos(usuario); // Reiniciamos los intentos fallidos en caso de éxito
//            return true;
//        } else {
//            int intentosFallidos = user.getIntentosFallidos() + 1;
//            usuarioDAO.actualizarIntentosFallidos(usuario, intentosFallidos);
//
//            if (intentosFallidos >= 3) {
//                usuarioDAO.bloquearUsuario(usuario);  // Bloqueamos al usuario después de 3 intentos fallidos
//                System.out.println("Usuario bloqueado por 3 intentos fallidos.");
//            }
//
//            return false;
//        }
    }
    
}
