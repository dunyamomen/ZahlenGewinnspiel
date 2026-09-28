import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Startet die Oberfläche im Swing-Thread
        SwingUtilities.invokeLater(() -> {
            GewinnView view = new GewinnView();

            view.setVisible(true);
        });
    }
}