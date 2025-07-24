import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> toDoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите операцию и введите ее номер: ");
            System.out.println();
            System.out.println("0. Выход из прораммы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать делa");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.println("5. Удаление по ключевому слову через поиск по совпадению");

            String input = scanner.nextLine();
            System.out.println("Ваш выбор " + input);

            if (input.equals("0")) {
                break;
            }

//            int operations = Integer.parseInt(input);

            switch (input) {
                case "1":
                    addTasks();
                    break;
                case "2":
                    showTasks();
                    break;
                case "3":
                    removeTasksForNumber();
                    break;
                case "4":
                    removeTasksForName(toDoList, scanner);
                    break;
                case "5":
                    removeTasksForSearch(toDoList, scanner);
                    break;
                default:
                    System.out.println("Такой операции нет!");
            }
        }

    }

    private static void addTasks() {
        System.out.println("Введите название задачи: ");
        String input = scanner.nextLine();
        toDoList.add(input);
        System.out.println();
        System.out.println("Добавлено!");
        System.out.println("Ваш список дел: ");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i + 1) + ". " + toDoList.get(i));
        }


    }

    private static void showTasks() {
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст!");
        } else {
            System.out.println("Ваш список дел: ");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i).toString());
            }
        }

    }

    private static void removeTasksForNumber() {
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст!");
        }
        showTasks();
        System.out.println("Введите номер для удаления: ");
        String input = scanner.nextLine();
        try {
            int userNum = Integer.parseInt(input);
            int del = userNum - 1;
            if (del >= 0 && del < toDoList.size()) {
                toDoList.remove(del);
                System.out.println("Удалено!");
                showTasks();
            } else {
                System.out.println("Задача " + userNum + " не найдена");
            }
        } catch (Exception e) {
            System.out.println("Ошибка - Введите корректный номер!");
        }

    }

    private static void removeTasksForName(List<String> toDoList, Scanner scanner) {
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст!");
        }
        System.out.println("Введите дело для удаления: ");
        String input = scanner.nextLine();
        if (toDoList.contains(input)) {
            toDoList.remove(input);
            System.out.println("Удалено!");
            showTasks();
        } else {
            System.out.println("Ошибка - дело не найдено!");
        }
    }

    private static void removeTasksForSearch(List<String> toDoList, Scanner scanner) {

        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст!");
        } else {
            System.out.println("Введите ключевое слово для удаления: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Ошибка - введена путсая строка!");
            } else {
                Iterator<String> iterator = toDoList.iterator();
                int count = 0;

                while (iterator.hasNext()) {
                    String delTasks = iterator.next();
                    if (delTasks != null && delTasks.toLowerCase().contains(input)) {
                        iterator.remove();
                        count++;
                    } else {
                        System.out.println("Ошибка - запись не найдена!");
                    }
                }
                System.out.println("Удалены дела с словом: " + input);
                System.out.println("В количестве: " + count + " дел");
            }
        }

    }
}


