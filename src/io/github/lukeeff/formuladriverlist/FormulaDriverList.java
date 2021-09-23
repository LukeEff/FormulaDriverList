package io.github.lukeeff.formuladriverlist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static io.github.lukeeff.formuladriverlist.FormulaDriverParser.parseFormulaDriverCsv;

/**
 * Reads a list of formula 1 drivers from a csv file that can be sorted and can print special messages for specific
 * drivers.
 */
public class FormulaDriverList {

    public static void main(String[] args) {
        final FormulaDriverList formulaDriverList = new FormulaDriverList();
    }

    public FormulaDriverList() {
        final List<FormulaDriver> formulaDrivers = parseFormulaDriverCsv("src/resources/formula-drivers.csv");
    }

    /**
     * Prints the list of formula drivers with any special messages that correspond to the FormulaDriver.
     *
     * @param formulaDrivers list of formula drivers to be printed.
     * @param driverMessageMap map containing special messages which correspond to a FormulaDriver.
     */
    private void printDriversWithMessages(final List<FormulaDriver> formulaDrivers,
                                          final Map<FormulaDriver, String> driverMessageMap) {
        formulaDrivers.forEach(driver -> {
            String message = driverMessageMap.get(driver);
            message = message == null ? "" : message;
            System.out.println(driver.getDisplayName() + " " + message);
        });
    }

    /**
     * Sort the list of formula drivers by driver name in alphabetical order.
     *
     * @param formulaDrivers list of FormulaDriver references.
     */
    private void sortByDriverName(final List<FormulaDriver> formulaDrivers) {
        formulaDrivers.sort(Comparator.comparing(FormulaDriver::driverName));
    }

    /**
     * Sort the list of formula drivers by the number that corresponds to the driver and vehicle.
     *
     * @param formulaDrivers list of FormulaDriver references.
     */
    private void sortByFormulaNumber(final List<FormulaDriver> formulaDrivers) {
        formulaDrivers.sort(Comparator.comparing(FormulaDriver::number));
    }
}
