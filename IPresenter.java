public interface IPresenter {
    void addEntry();
    void displayEntries();
    void displayEntriesByDate();
    void displayEntriesByWeek();
    void saveToFile();
    void loadFromFile();
}