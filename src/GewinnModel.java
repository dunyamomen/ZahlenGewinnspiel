public class GewinnModel {
    // Speichert die gesamten Punkte des Spielers
    private int gesamtPunkte;

    // Speichert die eingegebene Zahl des Spielers
    private int spielerZahl;

    // Speichert die zufällig erzeugte Zahl des Computers
    private int computerZahl;

    // Speichert die Punkte der letzten Runde: +20, +5 oder -10
    private int rundenErgebnis;

    // Der Konstruktor wird beim Erstellen eines neuen Objekts aufgerufen
    public GewinnModel() {
        // Ein neues Spiel beginnt mit 30 Punkten
        gesamtPunkte = 30;
    }

    // Gibt den aktuellen Gesamtpunktestand zurück
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    // Gibt die gespeicherte Computerzahl zurück
    public int getComputerZahl() {
        return computerZahl;
    }

    // Gibt den Punktgewinn oder Punktverlust der letzten Runde zurück
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
    // Erzeugt und speichert eine neue Computerzahl
    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * 9) + 1;
    }
    // Wertet eine Runde mit der bereits erzeugten Computerzahl aus
    public void berechneRunde(int spielerZahl) {
        // Ungültige Zahlen verändern den Spielstand nicht
        if (spielerZahl < 1 || spielerZahl > 9) {
            return;
        }
        // Nach dem Spielende werden keine weiteren Runden berechnet
        if (hatGewonnen() || hatVerloren()) {
            return;
        }
        // Speichert die übergebene Zahl im Attribut
        this.spielerZahl = spielerZahl;
        if (this.spielerZahl == computerZahl) {
            rundenErgebnis = 20;
        } else if (Math.abs(this.spielerZahl - computerZahl) == 1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }

        // Addiert den Gewinn oder Verlust zum Gesamtpunktestand
        gesamtPunkte += rundenErgebnis;
    }
    // Ab 100 Punkten ist das Spiel gewonnen
    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }
    // Bei 0 oder weniger Punkten ist das Spiel verloren
    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}