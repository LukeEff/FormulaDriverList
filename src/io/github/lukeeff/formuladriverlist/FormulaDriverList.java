package io.github.lukeeff.formuladriverlist;

import java.util.Comparator;
import java.util.List;

public class FormulaDriverList {

    public static void main(String[] args) {
    }

    /**
     * Sorts the list of formula drivers by driver name in alphabetical order.
     *
     * @param formulaDrivers list of FormulaDriver references.
     */
    private static void sortByDriverName(List<FormulaDriver> formulaDrivers) {
        formulaDrivers.sort(Comparator.comparing(FormulaDriver::driverName));
    }

    /**
     * Sorts the list of formula drivers by the number that corresponds to the driver and vehicle.
     *
     * @param formulaDrivers list of FormulaDriver references.
     */
    private static void sortByFormulaNumber(List<FormulaDriver> formulaDrivers) {
        formulaDrivers.sort(Comparator.comparing(FormulaDriver::number));
    }
}
