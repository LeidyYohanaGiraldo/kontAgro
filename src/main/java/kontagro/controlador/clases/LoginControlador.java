
package kontagro.controlador.clases;

import javax.swing.JOptionPane;
import kontagro.controlador.gestorDeVistas.GestorDeVistas;
import kontagro.modelo.dao.clases.UsuarioDao;
import kontagro.modelo.entidad.Usuario;
import kontagro.vista.login.FrmLogin;
import kontagro.vista.menu.FrmMenu;

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
        
         this.vistaLogin.getBtnIniciarSesion().addActionListener(e -> validarLogin());
    }
   
       public void validarLogin() {
         String user = vistaLogin.getUsuario();
         String password = vistaLogin.getPassword();
           
        Usuario usuario = usuarioDAO.obtenerUsuario(user, password);

           if (usuario != null) {
                vistaLogin.limpiarcampos();

                        JOptionPane.showMessageDialog(vistaLogin, "Ingreso exitoso");
//                        SesionUsuario.getInstancia().setUsuario(usuario);
                        FrmMenu mantenimientoVista = new FrmMenu();
//                        MenuController maneteminetoController = new MenuController(mantenimientoVista, vistaLogin); // Instancia del controlador
                        GestorDeVistas.mostrarVista(vistaLogin, mantenimientoVista);
                        


            } else {
                JOptionPane.showMessageDialog(vistaLogin, "Usuario o contraseña incorrectos");
                vistaLogin.limpiarcampos();
            }

            
        }
    }
    
    
