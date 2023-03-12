package ru.renue.util;

import ru.renue.exception.BadNumberOfColumnException;

public class ArgsParserUtil {

    public static int parseColumnNumber(String[] args) {
        int columnNumber;
        try {
            columnNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new BadNumberOfColumnException("Номер колонки должен быть целым числом");
        }

        if (columnNumber <= 0) {
            throw new BadNumberOfColumnException("Номер колонки должен быть положительным числом");
        }

        return columnNumber;
    }
}
