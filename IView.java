import java.util.List;

public interface IView {
    void displayEntries(List<Entry> entries);
    void displayMessage(String message);
    String getInput(String prompt);
}