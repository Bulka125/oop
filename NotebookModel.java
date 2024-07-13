import java.util.*;
import java.io.*;

public class NotebookModel implements IModel {
    private List<Entry> entries;

    public NotebookModel() {
        entries = new ArrayList<>();
    }

    @Override
    public void addEntry(String date, String time, String description) {
        entries.add(new Entry(date, time, description));
    }

    @Override
    public List<Entry> getEntries() {
        return entries;
    }

    @Override
    public List<Entry> getEntriesByDate(String date) {
        List<Entry> result = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getDate().equals(date)) {
                result.add(entry);
            }
        }
        return result;
    }

    @Override
    public List<Entry> getEntriesByWeek(String weekStartDate) {
        List<Entry> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(java.sql.Date.valueOf(weekStartDate));
        for (int i = 0; i < 7; i++) {
            String date = new java.sql.Date(calendar.getTimeInMillis()).toString();
            result.addAll(getEntriesByDate(date));
            calendar.add(Calendar.DATE, 1);
        }
        return result;
    }

    @Override
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(entries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            entries = (List<Entry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}