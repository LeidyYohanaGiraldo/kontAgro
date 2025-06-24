package kontagro.vista.utils.components;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author LeidyGiraldo
 */
public class PanelRedondeado extends JPanel {

    private int radioEsquinas = 25;
    private Color colorFondo = new Color(204, 255, 204, 200); // Verde claro con algo de transparencia

    public PanelRedondeado() {
        setOpaque(false);
    }

    public void setRadioEsquinas(int radio) {
        this.radioEsquinas = radio;
        repaint();
    }

    public void setColorFondo(Color color) {
        this.colorFondo = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(colorFondo);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radioEsquinas, radioEsquinas);
        g2d.dispose();
        super.paintComponent(g);
    }
}
