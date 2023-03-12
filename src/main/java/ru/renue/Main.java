package ru.renue;

import static ru.renue.service.AirportsSearchService.searchAirports;
import static ru.renue.util.ArgsParserUtil.parseColumnNumber;

public class Main {

    public static void main(String[] args) {

        int columnNumber = parseColumnNumber(args);

        searchAirports(columnNumber);
    }
}
