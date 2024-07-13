import java.util.List;

public class NotebookPresenter implements IPresenter {
    private IModel model;
    private IView view;

    public NotebookPresenter(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void addEntry() {
        String date = view.getInput("Введите дату (yyyy-mm-dd): ");
        String time = view.getInput("Введите время (HH:mm): ");
        String description = view.getInput("Введите описание: ");
        model.addEntry(date, time, description);
        view.displayMessage("Запись добавлена.");
    }

    @Override
    public void displayEntries() {
        List<Entry> entries = model.getEntries();
        view.displayEntries(entries);
    }

    @Override
    public void displayEntriesByDate() {
        String date = view.getInput("Введите дату (yyyy-mm-dd): ");
        List<Entry> entries = model.getEntriesByDate(date);
        view.displayEntries(entries);
    }

    @Override
    public void displayEntriesByWeek() {
        String date = view.getInput("Введите дату начала недели (yyyy-mm-dd): ");
        List<Entry> entries = model.getEntriesByWeek(date);
        view.displayEntries(entries);
    }

    @Override
    public void saveToFile() {
        String filename = view.getInput("Введите имя файла для сохранения: ");
        model.saveToFile(filename);
        view.displayMessage("Данные сохранены в файл " + filename);
    }

    @Override
    public void loadFromFile() {
        String filename = view.getInput("Введите имя файла для загрузки: ");
        model.loadFromFile(filename);
        view.displayMessage("Данные загружены из файла " + filename);
    }
}
