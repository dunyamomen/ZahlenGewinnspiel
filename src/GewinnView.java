import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {
    // Zeigt das Ergebnis der aktuellen Runde
    private JLabel lblErgebnis;

    // Zeigt den gesamten Punktestand
    private JLabel lblPunkte;
    // Eingabefeld für die Zahl des Spielers
    private JTextField txtSpieler;
    // Zeigt die zufällige Computerzahl
    private JTextField txtComputer;
    // Bereitet die nächste Runde vor
    private JButton btnNochmal;
    // Verbindet die Oberfläche mit der Spiellogik
    private GewinnController controller = new GewinnController();
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
        // Mittlerer Bereich mit zwei Zeilen und zwei Spalten
        JPanel mitte = new JPanel(new GridLayout(2, 2, 10, 10));

        // Beschriftungen über den Zahlenfeldern
        mitte.add(new JLabel("Deine Zahl:", SwingConstants.CENTER));
        mitte.add(new JLabel("Computer:", SwingConstants.CENTER));

        // Erstellt beide Zahlenfelder
        txtSpieler = new JTextField();
        txtComputer = new JTextField();

        // Die Computerzahl darf nicht selbst eingegeben werden
        txtComputer.setEditable(false);

        // Zahlen mittig anzeigen
        txtSpieler.setHorizontalAlignment(JTextField.CENTER);
        txtComputer.setHorizontalAlignment(JTextField.CENTER);

        // Große Schrift für beide Zahlenfelder
        Font zahlenSchrift = new Font("SansSerif", Font.BOLD, 48);
        txtSpieler.setFont(zahlenSchrift);
        txtComputer.setFont(zahlenSchrift);

        // Zahlenfelder zum mittleren Bereich hinzufügen
        mitte.add(txtSpieler);
        mitte.add(txtComputer);

        // Mittleren Bereich im Fenster platzieren
        add(mitte, BorderLayout.CENTER);

        // FlowLayout platziert den Button mittig
        JPanel unten = new JPanel(new FlowLayout());

        // Button erstellen und unten hinzufügen
        btnNochmal = new JButton("Noch einmal!");
        unten.add(btnNochmal);
        add(unten, BorderLayout.SOUTH);
        // Zeigt den Startpunktestand aus dem Model
        lblPunkte.setText("Gesamtpunkte: " + controller.getGesamtPunkte());

        // Enter im Eingabefeld startet eine Runde
                txtSpieler.addActionListener(e -> spieleRunde());

        // Der Button leert die Anzeigen für die nächste Runde
                btnNochmal.addActionListener(e -> {
                    // Nach dem Spielende bleiben die Ergebnisse sichtbar
                    if (controller.hatGewonnen() || controller.hatVerloren()) {
                        return;
                    }

                    // Gesamtpunkte bleiben erhalten
                    txtSpieler.setText("");
                    txtComputer.setText("");
                    lblErgebnis.setText("Tippe eine Zahl von 1 bis 9");

                    // Setzt den Cursor zurück ins Eingabefeld
                    txtSpieler.requestFocusInWindow();
                });
                // Fenster auf dem Bildschirm zentrieren
                setLocationRelativeTo(null);
    }
    // Liest die Eingabe und übergibt sie dem Controller
    private void spieleRunde() {
        // Nach dem Spielende keine weitere Eingabe auswerten
        if (controller.hatGewonnen() || controller.hatVerloren()) {
            return;
        }

        try {
            // Wandelt den eingegebenen Text in eine ganze Zahl um
            int zahl = Integer.parseInt(txtSpieler.getText().trim());

            // Der Controller prüft die Zahl und berechnet die Runde
            if (controller.spieleRunde(zahl)) {
                aktualisiereAnzeige();
            } else {
                lblErgebnis.setText("Bitte eine Zahl von 1 bis 9 eingeben!");
            }
        } catch (NumberFormatException ex) {
            // Fängt leere Eingaben, Buchstaben und Dezimalzahlen ab
            lblErgebnis.setText("Bitte eine ganze Zahl von 1 bis 9 eingeben!");
        }
    }

    // Zeigt die aktuellen Ergebnisse des Models an
    private void aktualisiereAnzeige() {
        txtComputer.setText("" + controller.getComputerZahl());
        lblErgebnis.setText("Rundenpunkte: " + controller.getRundenErgebnis());
        lblPunkte.setText("Gesamtpunkte: " + controller.getGesamtPunkte());

        // Ergänzt beim Spielende eine passende Nachricht
        if (controller.hatGewonnen()) {
            lblPunkte.setText("Gewonnen! Punkte: " + controller.getGesamtPunkte());
        } else if (controller.hatVerloren()) {
            lblPunkte.setText("Verloren! Punkte: " + controller.getGesamtPunkte());
        }
    }
}