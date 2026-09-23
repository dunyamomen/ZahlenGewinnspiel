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
}