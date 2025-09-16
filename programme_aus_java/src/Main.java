//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Einfaches Beispiel: Notepad starten (unter Windows)
            Process process = Runtime.getRuntime().exec("notepad.exe");

            // Warten, bis das Programm beendet wird
            process.waitFor();

            System.out.println("Notepad wurde beendet.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
