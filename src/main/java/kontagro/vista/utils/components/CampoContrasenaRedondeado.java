
package kontagro.vista.utils.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author LeidyGiraldo
 */
public class CampoContrasenaRedondeado extends JPasswordField {
    private int radioEsquinas = 20;

    public CampoContrasenaRedondeado() {
        setOpaque(false);
        setBorder(new EmptyBorder(10, 15, 10, 15));
        setBackground(new Color(255, 255, 255, 180));
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 16));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radioEsquinas, radioEsquinas);
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
         Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radioEsquinas, radioEsquinas);
        g2.dispose();
    }
    
}
