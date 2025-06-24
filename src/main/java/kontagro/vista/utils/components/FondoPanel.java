/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontagro.vista.utils.components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LeidyGiraldo
 */
public class FondoPanel extends JPanel{
    
     //Atributos
    private Image imagenFondo;

    //Métodos
    
    // Método para cambiar la imagen del fondo
    public void setImagenFondo(String rutaImagen) {
        imagenFondo = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
        repaint(); // Para redibujar el fondo con la nueva imagen
    }
    
    
    @Override
     protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Asegura que el resto del componente se pinte correctamente
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
        setOpaque(false); // Para que no pinte el fondo "por defecto"
    }   
}
