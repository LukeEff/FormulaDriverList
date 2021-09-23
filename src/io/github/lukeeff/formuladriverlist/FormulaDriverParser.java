package io.github.lukeeff.formuladriverlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads and parses FormulaDriver data from csv files.
 */
public class FormulaDriverParser {

    /**
     * Parses a list of FormulaDrivers from a csv file containing data about each FormulaDriver instance.
     *
     * @param path path to the csv file that contains the FormulaDriver data.
     * @return a list of FormulaDriver instances that correspond to data within the csv file pointed to by the path.
     */
    public static List<FormulaDriver> parseFormulaDriverCsv(final String path) {
        final List<FormulaDriver> formulaDrivers = new ArrayList<>();
        try {
            String row;

            final BufferedReader reader = new BufferedReader(new FileReader(path));
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
     * Parses an array of strings retrieved through reading a csv file containing formula driver data and parses it
     * to a formula driver instance.
     *
     * @param data strings of information necessary for constructing a new FormulaDriver instance.
     * @return new FormulaDriver instance that corresponds to the provided data.
     */
    private static FormulaDriver parseFormulaDriver(final String[] data) {
        final String driverName = data[0];
        final int number = Integer.parseInt(data[1]);
        final String vehicleName = data[2];
        return new FormulaDriver(driverName, vehicleName, number);
    }
}
