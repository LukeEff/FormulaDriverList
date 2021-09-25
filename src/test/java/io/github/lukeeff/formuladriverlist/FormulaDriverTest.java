package test.java.io.github.lukeeff.formuladriverlist;

import main.java.io.github.lukeeff.formuladriverlist.FormulaDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormulaDriverTest {

    final FormulaDriver formulaDriver = new FormulaDriver("Max", "Verstappen", "Red Bull", 33);

    @Test
    void getDisplayName() {
        assertEquals("Max Verstappen 33 Red Bull", formulaDriver.getDisplayName());
    }

    @Test
    void getDriverName() {
        assertEquals("Max Verstappen", formulaDriver.getDriverName());
    }
}