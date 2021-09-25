package main.java.io.github.lukeeff.formuladriverlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads and parses FormulaDriver data from csv files.
 */
public class FormulaDriverParser {

    private static final String RESOURCE_PATH = "src/resources/";

    /**
     * Parses a list of FormulaDrivers from a csv file containing data about each FormulaDriver instance.
     *
     * @param fileName name of the csv file containing the data.
     * @return a list of FormulaDriver instances that correspond to data within the csv file pointed to by the path.
     */
    public static List<FormulaDriver> parseFormulaDriverCsv(final String fileName) {
        final List<FormulaDriver> formulaDrivers = new ArrayList<>();
        try {
            String row;
            final BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_PATH + fileName));
            while ((row = reader.readLine()) != null) {
                final String[] data = row.split(",");
                final FormulaDriver formulaDriver = parseFormulaDriver(data);
                formulaDrivers.add(formulaDriver);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formulaDrivers;
    }

    /**
     * Parses a map containing a driver name and the message that should correspond to that name.
     *
     * @param fileName name of the csv file containing the data.
     * @return a map containing driver names and the messages that should correspond to each name.
     */
    public static Map<String, String> parseFormulaDriverMessageCsv(final String fileName) {
        final Map<String, String> nameMessageMap = new HashMap<>();
        try {
            String row;
            final BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_PATH + fileName));
            while ((row = reader.readLine()) != null) {
                final String[] data = row.split(",");
                final String driverName = data[0];
                final String message = data[1];
                nameMessageMap.put(driverName, message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameMessageMap;
    }

    /**
     * Parses an array of strings retrieved through reading a csv file containing formula driver data and parses it
     * to a formula driver instance.
     *
     * @param data strings of information necessary for constructing a new FormulaDriver instance.
     * @return new FormulaDriver instance that corresponds to the provided data.
     */
    private static FormulaDriver parseFormulaDriver(final String[] data) {
        final String driverFirstName = data[0];
        final String driverLastName = data[1];
        final int number = Integer.parseInt(data[2]);
        final String vehicleName = data[3];
        return new FormulaDriver(driverFirstName, driverLastName, vehicleName, number);
    }
}
