import java.util.List;
import java.util.Scanner;

public class ConsoleView implements IView {
    private Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayEntries(List<Entry> entries) {
        for (Entry entry : entries) {
            System.out.println(entry);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
