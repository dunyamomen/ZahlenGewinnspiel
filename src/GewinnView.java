import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {
    // Zeigt das Ergebnis der aktuellen Runde
    private JLabel lblErgebnis;

    // Zeigt den gesamten Punktestand
    private JLabel lblPunkte;

    public GewinnView() {
        // Titel des Fensters
        super("Zahlen-Gewinnspiel (v1.0)");

        // Beim Schließen des Fensters wird das Programm beendet
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Legt die Fenstergröße fest
        setSize(600, 350);

        // Teilt das Fenster in oben, Mitte und unten auf
        setLayout(new BorderLayout(10, 10));

        // Oben: zwei Zeilen und zwei Spalten
        JPanel oben = new JPanel(new GridLayout(2, 2, 5, 5));

        // Überschriften über den Ergebnisanzeigen
        oben.add(new JLabel("Rundenergebnis:", SwingConstants.CENTER));
        oben.add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));

        // Anfangstexte für das neue Spiel
        lblErgebnis = new JLabel(
                "Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        lblPunkte = new JLabel(
                "Gesamtpunkte: 30", SwingConstants.CENTER);

        // Opaque sorgt dafür, dass die Hintergrundfarbe sichtbar ist
        lblErgebnis.setOpaque(true);
        lblPunkte.setOpaque(true);

        // In Version 1.0 bleiben beide Anzeigen weiß
        lblErgebnis.setBackground(Color.WHITE);
        lblPunkte.setBackground(Color.WHITE);

        // Ergebnisanzeigen zum oberen Panel hinzufügen
        oben.add(lblErgebnis);
        oben.add(lblPunkte);

        // Das Panel oben im Fenster platzieren
        add(oben, BorderLayout.NORTH);

        // Fenster auf dem Bildschirm zentrieren
        setLocationRelativeTo(null);
    }
}