package main.java.io.github.lukeeff.formuladriverlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static main.java.io.github.lukeeff.formuladriverlist.FormulaDriverParser.parseFormulaDriverCsv;
import static main.java.io.github.lukeeff.formuladriverlist.FormulaDriverParser.parseFormulaDriverMessageCsv;

/**
 * Reads a list of formula 1 drivers from a csv file that can be sorted and can print special messages for specific
 * drivers.
 * 
 * @author Luke Fernandez
 */
public class FormulaDriverList {

    private static final String DRIVER_TITLE = """
            2021 F1 Drivers
            ===============\s
            """;

    private final List<FormulaDriver> formulaDrivers;
    private final Map<String, String> driverMessageMap;

    public static void main(String[] args) {
        final List<FormulaDriver> formulaDrivers = parseFormulaDriverCsv("formula-drivers.csv");
        final Map<String, String> driverMessageMap = parseFormulaDriverMessageCsv("formula-driver-display-messages.csv");
        final FormulaDriverList formulaDriverList = new FormulaDriverList(formulaDrivers, driverMessageMap);

        System.out.println(DRIVER_TITLE);
        formulaDriverList.sortByDriverLastName();
        printDriversWithMessages(formulaDriverList);
        System.out.println();
        formulaDriverList.sortByFormulaNumber();
        printDriversWithMessages(formulaDriverList);
    }

    private static void printDriversWithMessages(final FormulaDriverList formulaDriverList) {
        formulaDriverList.getDriverDisplayMessages().forEach(System.out::println);
    }

    public FormulaDriverList(final List<FormulaDriver> formulaDrivers, final Map<String, String> driverMessageMap) {
        this.formulaDrivers = formulaDrivers;
        this.driverMessageMap = driverMessageMap;
    }

    /**
     * Gets a list containing formula driver display messages with any special messages that corresponds to the
     * FormulaDriver.
     *
     * @return list containing formula driver display messages with any special messages that corresponds to the
     * FormulaDriver.
     */
    public List<String> getDriverDisplayMessages() {
        final List<String> driverMessages = new ArrayList<>();
        formulaDrivers.forEach(driver -> {
            String displayMessage = driver.getDisplayName();
            if (driverMessageMap.containsKey(driver.getDriverName())) {
                displayMessage += " " + driverMessageMap.get(driver.getDriverName());
            }
            driverMessages.add(displayMessage);
        });
        return driverMessages;
    }

    /**
     * Sort the list of formula drivers by driver name in alphabetical order.
     */
    public void sortByDriverLastName() {
        formulaDrivers.sort(Comparator.comparing(FormulaDriver::driverLastName));
    }

    /**
     * Sort the list of formula drivers by the number that corresponds to the driver and vehicle.
     */
    public void sortByFormulaNumber() {
        formulaDrivers.sort(Comparator.comparing(FormulaDriver::number));
    }
}
