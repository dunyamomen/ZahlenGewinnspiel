public class GewinnController {
    private GewinnModel model;

    public GewinnController() {
        // Erstellt ein neues Spiel mit 30 Punkten
        model = new GewinnModel();
    }

    // Prüft die Eingabe und startet eine Runde
    public boolean spieleRunde(int zahl) {
        if (zahl < 1 || zahl > 9) {
            return false;
        }

        // Ein beendetes Spiel darf nicht weiterlaufen
        if (model.hatGewonnen() || model.hatVerloren()) {
            return false;
        }

        // Zuerst die Computerzahl erzeugen, dann vergleichen
        model.berechneComputerZahl();
        model.berechneRunde(zahl);

        // Die Runde wurde erfolgreich berechnet
        return true;
    }

    // Liefert der Oberfläche den Gesamtpunktestand
    public int getGesamtPunkte() {
        return model.getGesamtPunkte();
    }

    // Liefert der Oberfläche die Computerzahl
    public int getComputerZahl() {
        return model.getComputerZahl();
    }

    // Liefert die gewonnenen oder verlorenen Punkte
    public int getRundenErgebnis() {
        return model.getRundenErgebnis();
    }

    // Fragt beim Model ab, ob das Spiel gewonnen ist
    public boolean hatGewonnen() {
        return model.hatGewonnen();
    }

    // Fragt beim Model ab, ob das Spiel verloren ist
    public boolean hatVerloren() {
        return model.hatVerloren();
    }
}