package ru.renue.service;

import java.util.Objects;
import java.util.Scanner;

public class AirportsSearchService {

    static final String pathFile = "src/main/resources/airports.csv";
    private static final String commandExitProgram = "!quit";
    private static final String inputString = "Введите строку:";

    public static void searchAirports(int columnNumber) {
        Scanner sc = new Scanner(System.in);

        System.out.println(inputString);
        String prefix = sc.nextLine();

        while (!Objects.equals(prefix, commandExitProgram)) {
            int rowCount = 0;

            long startTime = System.currentTimeMillis();

            FileService fileService = new FileServiceImpl();

            rowCount = fileService.printFoundRowsByPrefix(rowCount, columnNumber, prefix);
            System.out.println("Количество найденных строк: " + rowCount + " Время затраченное на поиск: " + (System.currentTimeMillis() - startTime) + " мс");

            System.out.println(inputString);
            prefix = sc.nextLine();
        }
    }
}
