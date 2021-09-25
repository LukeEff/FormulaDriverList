package test.java.io.github.lukeeff.formuladriverlist;

import main.java.io.github.lukeeff.formuladriverlist.FormulaDriver;
import main.java.io.github.lukeeff.formuladriverlist.FormulaDriverParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormulaDriverParserTest {

    final FormulaDriver valtteri = new FormulaDriver("Valtteri", "Bottas", "Mercedes", 77);
    final FormulaDriver lando = new FormulaDriver("Lando", "Norris", "McLaren", 4);
    final FormulaDriver sergio = new FormulaDriver("Sergio", "Perez", "Red Bull", 11);

    @Test
    void parseFormulaDriverCsv() {
        final List<FormulaDriver> expected = new ArrayList<>() {{
           add(valtteri);
           add(lando);
           add(sergio);
        }};
        final List<FormulaDriver> actual = FormulaDriverParser.parseFormulaDriverCsv("formula-drivers-test.csv");
        assertEquals(expected, actual);
    }

    @Test
    void parseFormulaDriverMessageCsv() {
        final Map<String, String> expected = new HashMap<>() {{
           put("Valtteri Bottas", "YEET!");
        }};
        final Map<String, String> actual = FormulaDriverParser.parseFormulaDriverMessageCsv("formula-driver-display-messages-test.csv");
        assertEquals(expected, actual);
    }
}