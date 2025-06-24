package kontagro;

import kontagro.controlador.clases.LoginControlador;
import kontagro.modelo.conexion.Conexion;
import kontagro.modelo.dao.clases.UsuarioDao;
import kontagro.vista.login.FrmLogin;

public class MainKontAgro {
    public static void main(String[] args) {
        
        UsuarioDao usuarioDAO = new UsuarioDao(Conexion.getConnection());
        FrmLogin vista = new FrmLogin();

        // Crear controlador
        LoginControlador login = new LoginControlador(usuarioDAO, vista);
        
//        // Mostrar la vista
        vista.setVisible(true);

    }

}
