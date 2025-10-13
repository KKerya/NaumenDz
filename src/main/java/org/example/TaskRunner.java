package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskRunner {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Запускает задание 1
     * Работа с массивом
     * Пользователь вводит количество элементов, массив заполняется случайными числами и выводится минимальное по модулю число
     */
    public static void runArrayTask() {
        System.out.println("Задание 1");
        int n = scanner.nextInt();
        int[] array = ArrayUtils.generateArray(n);
        ArrayUtils.printArray(array);
        System.out.println(ArrayUtils.getMinAbs(array));
    }

    /**
     * Запускает задание 2
     * Работа со списком ArrayList
     * Пользователь вводит количество элементов, список заполняется случайными числами
     * Выполняется быстрая сортировка и результат выводится на консоль
     */
    public static void runSortingTask() {
        System.out.println("Задание 2");
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Double> list = ListUtils.generateList(n);

        System.out.print("Исходный массив:");
        System.out.println(list);

        ListUtils.quickSort(list, 0, list.size() - 1);

        System.out.print("Отсортированный массив:");
        System.out.println(list);
    }

    /**
     * Запускает задание 3
     * Работа с классов Employee
     * Employee содержит в себе полное, название отдела и заработную плату
     * Создается класс Employees содержащий внутри список с объектами типа Employee
     * Пользователь вводит название отдела и выводится средняя заработная плата в этом отделе
     */
    public static void runEmployeesTask() {
        System.out.println("Задание 3");
        Employees employees = new Employees();
        System.out.print("Введите название отдела: ");
        String department = scanner.nextLine();
        System.out.println("Средняя зарплата в отделе: " + employees.getAverageSalary(department));
    }

    /**
     * Запускает задание 4
     * Выполнение Http запроса
     * Выполняется GET запрос на сервер и выводится user-agent
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public static void runHttpsRequestTask() throws IOException, InterruptedException {
        System.out.println("Задание 4");
        System.out.println(SyncHttpClient.requestUserAgent());
    }

    /**
     * Выполняется задание 5
     * Пользователь вводит ссылку на файл и путь сохранения
     * Файл скачивается и сохраняется
     */
    public static void runDownloadTask() {
        System.out.print("Введите ссылку на файл: ");
        String url = scanner.nextLine();
        System.out.print("Введите место сохранения: ");
        String output = scanner.nextLine();
        DownloadFile downloadFile = new DownloadFile(url, output);
        downloadFile.start();

        System.out.println("Скачивание начато. Нажмите Enter для остановки");
        scanner.nextLine();

        downloadFile.stop();
        System.out.println("Скачивание остановлено");
    }
}
