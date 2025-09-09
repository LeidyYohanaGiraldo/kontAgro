package kontagro.vista.utils.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author LeidyGiraldo
 */
public class FechaHoraUtil {

    private static final DateTimeFormatter dtf
            = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy - HH:mm:ss", new Locale("es", "ES"));

    private Timer reloj;

    // Inicia el reloj y actualiza automáticamente el JLabel
    public void iniciarReloj(JLabel etiqueta) {
        reloj = new Timer(1000, e -> {
            String fechaHora = LocalDateTime.now().format(dtf);
            fechaHora = Character.toUpperCase(fechaHora.charAt(0)) + fechaHora.substring(1);
            etiqueta.setText(fechaHora);
        });
        reloj.setInitialDelay(0);
        reloj.start();
    }

    // Detener al cerrar ventana
    public void detenerReloj() {
        if (reloj != null) {
            reloj.stop();
        }
    }

}
