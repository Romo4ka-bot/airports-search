package ru.renue.service;

import ru.renue.exception.BadNumberOfColumnException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static ru.renue.service.AirportsSearchService.pathFile;

public class FileServiceImpl implements FileService {

    @Override
    public int printFoundRowsByPrefix(int rowCount, int columnNumber, String prefix) throws BadNumberOfColumnException {

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            while ((line = br.readLine()) != null) {

                String[] airportInfo = parseLine(line);
                if (airportInfo.length - 1 < columnNumber) {
                    throw new BadNumberOfColumnException("Номер колонки больше граничного значения");
                }

                if (airportInfo[columnNumber - 1].toLowerCase().startsWith(prefix.toLowerCase())) {
                    rowCount++;
                    System.out.print(airportInfo[columnNumber - 1]);
                    System.out.println(Arrays.toString(airportInfo));
                }
            }

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return rowCount;
    }

    public static String[] parseLine(String csvLine) {
        if (csvLine == null || csvLine.isEmpty()) {
            return new String[0];
        }

        String[] airportInfo = csvLine.split(",");

        deleteDoubleQuotesInColumnValue(airportInfo);

        return airportInfo;
    }

    private static void deleteDoubleQuotesInColumnValue(String[] airportInfo) {
        for (int i = 0; i < airportInfo.length; i++) {

            String columnValue = airportInfo[i];

            if (columnValue.charAt(0) == '"' && columnValue.charAt(columnValue.length() - 1) == '"') {
                airportInfo[i] = columnValue.substring(1, columnValue.length() - 1);
            }
        }
    }
}
