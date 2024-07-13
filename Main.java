
public class Main {
    public static void main(String[] args) {
        IModel model = new NotebookModel();
        IView view = new ConsoleView();
        IPresenter presenter = new NotebookPresenter(model, view);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить запись");
            System.out.println("2. Показать все записи");
            System.out.println("3. Показать записи за дату");
            System.out.println("4. Показать записи за неделю");
            System.out.println("5. Сохранить в файл");
            System.out.println("6. Загрузить из файла");
            System.out.println("0. Выйти");
            String choice = view.getInput("Выберите опцию: ");

            switch (choice) {
                case "1":
                    presenter.addEntry();
                    break;
                case "2":
                    presenter.displayEntries();
                    break;
                case "3":
                    presenter.displayEntriesByDate();
                    break;
                case "4":
                    presenter.displayEntriesByWeek();
                    break;
                case "5":
                    presenter.saveToFile();
                    break;
                case "6":
                    presenter.loadFromFile();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    view.displayMessage("Неверный выбор, попробуйте снова.");
            }
        }
    }
}
