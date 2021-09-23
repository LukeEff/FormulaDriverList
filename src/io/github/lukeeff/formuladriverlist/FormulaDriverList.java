package io.github.lukeeff.formuladriverlist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static io.github.lukeeff.formuladriverlist.FormulaDriverParser.parseFormulaDriverCsv;
import static io.github.lukeeff.formuladriverlist.FormulaDriverParser.parseFormulaDriverMessageCsv;

/**
 * Reads a list of formula 1 drivers from a csv file that can be sorted and can print special messages for specific
 * drivers.
 */
public class FormulaDriverList {

    private static final String RESOURCE_PATH = "src/resources/";
    private static final String DRIVER_TITLE = """
                2021 F1 Drivers
                ===============\s
                """;

    public static void main(String[] args) {
        final FormulaDriverList formulaDriverList = new FormulaDriverList();
    }

    public FormulaDriverList() {
        final List<FormulaDriver> formulaDrivers = parseFormulaDriverCsv(RESOURCE_PATH + "formula-drivers.csv");
        final Map<String, String> driverMessageMap = parseFormulaDriverMessageCsv(RESOURCE_PATH + "formula-driver-display-messages.csv");

        System.out.println(DRIVER_TITLE);
        sortByDriverLastName(formulaDrivers);
        printDriversWithMessages(formulaDrivers, driverMessageMap);
        System.out.println("\n");
        sortByFormulaNumber(formulaDrivers);
        printDriversWithMessages(formulaDrivers, driverMessageMap);
    }

    /**
     * Prints the list of formula drivers with any special messages that correspond to the FormulaDriver.
     *
     * @param formulaDrivers list of formula drivers to be printed.
     * @param driverMessageMap map containing special messages which correspond to a FormulaDriver.
     */
    private void printDriversWithMessages(final List<FormulaDriver> formulaDrivers,
                                          final Map<String, String> driverMessageMap) {
        formulaDrivers.forEach(driver -> {
            String displayMessage = driver.getDisplayName();
            if (driverMessageMap.containsKey(driver.getDriverName())) {
                displayMessage += " " + driverMessageMap.get(driver.getDriverName());
            }
            System.out.println(displayMessage);
        });
    }

    /**
     * Sort the list of formula drivers by driver name in alphabetical order.
     *
     * @param formulaDrivers list of FormulaDriver references.
     */
    private void sortByDriverLastName(final List<FormulaDriver> formulaDrivers) {
        formulaDrivers.sort(Comparator.comparing(FormulaDriver::driverLastName));
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
