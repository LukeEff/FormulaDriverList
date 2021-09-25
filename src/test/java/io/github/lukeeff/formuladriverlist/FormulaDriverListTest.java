package test.java.io.github.lukeeff.formuladriverlist;

import main.java.io.github.lukeeff.formuladriverlist.FormulaDriver;
import main.java.io.github.lukeeff.formuladriverlist.FormulaDriverList;
import main.java.io.github.lukeeff.formuladriverlist.FormulaDriverParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormulaDriverListTest {

    private final FormulaDriver lewis = new FormulaDriver("Lewis", "Hamilton", "Mercedes", 44);
    private final FormulaDriver esteban = new FormulaDriver("Esteban", "Ocon", "Alpine", 31);
    private final FormulaDriver sergio = new FormulaDriver("Sergio", "Perez", "Red Bull", 11);

    private final List<FormulaDriver> formulaDrivers = new ArrayList<>() {{
        add(lewis);
        add(esteban);
        add(sergio);
    }};

    private final Map<String, String> driverMessageMap = new HashMap<>() {{
        put("Lewis Hamilton", "YEET!");
    }};

    private final FormulaDriverList formulaDriverList = new FormulaDriverList(formulaDrivers, driverMessageMap);

    @Test
    void getDriverDisplayMessages() {
        final List<String> expected = new ArrayList<>() {{
           add(lewis.getDisplayName() + " YEET!");
           add(esteban.getDisplayName());
           add(sergio.getDisplayName());
        }};
        final List<String> actual = formulaDriverList.getDriverDisplayMessages();
        assertEquals(expected, actual);
    }

    @Test
    void sortByDriverLastName() {
        final List<FormulaDriver> expected = new ArrayList<>() {{
            add(new FormulaDriver("Lewis", "Hamilton", "Mercedes", 44));
            add(new FormulaDriver("Esteban", "Ocon", "Alpine", 31));
            add(new FormulaDriver("Sergio", "Perez", "Red Bull", 11));
        }};
        formulaDriverList.sortByDriverLastName();
        assertEquals(expected, formulaDrivers);
    }

    @Test
    void sortByFormulaNumber() {
        final List<FormulaDriver> expected = new ArrayList<>() {{
            add(new FormulaDriver("Sergio", "Perez", "Red Bull", 11));
            add(new FormulaDriver("Esteban", "Ocon", "Alpine", 31));
            add(new FormulaDriver("Lewis", "Hamilton", "Mercedes", 44));
        }};
        formulaDriverList.sortByFormulaNumber();
        assertEquals(expected, formulaDrivers);
    }
}