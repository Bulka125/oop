import java.util.List;

public interface IModel {
    void addEntry(String date, String time, String description);
    List<Entry> getEntries();
    List<Entry> getEntriesByDate(String date);
    List<Entry> getEntriesByWeek(String weekStartDate);
    void saveToFile(String filename);
    void loadFromFile(String filename);
}