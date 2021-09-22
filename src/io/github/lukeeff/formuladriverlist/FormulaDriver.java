package io.github.lukeeff.formuladriverlist;

import java.util.Objects;

/**
 * The information associated with formula drivers.
 */
public record FormulaDriver(String driverName, String vehicleName, int number) {

    /**
     * Get the data of the FormulaDriver instance in the format to be displayed to the client.
     *
     * @return data of the FormulaDriver instance in the format to be displayed to the client.
     */
    public String getDisplayName() {
        return driverName + " " + number + " " + vehicleName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        FormulaDriver that = (FormulaDriver) other;
        return number == that.number && Objects.equals(driverName, that.driverName) && Objects.equals(vehicleName, that.vehicleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverName, vehicleName, number);
    }

    @Override
    public String toString() {
        return "FormulaDriver{" +
                "driverName='" + driverName + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", number=" + number +
                '}';
    }
}
