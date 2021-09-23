package io.github.lukeeff.formuladriverlist;

import java.util.Objects;

/**
 * Information associated with formula drivers.
 */
public record FormulaDriver(String driverFirstName, String driverLastName, String vehicleName, int number) {

    /**
     * Get the data of the FormulaDriver instance in the format to be displayed to the client.
     *
     * @return data of the FormulaDriver instance in the format to be displayed to the client.
     */
    public String getDisplayName() {
        return getDriverName() + " " + number + " " + vehicleName;
    }

    public String getDriverName() {
        return driverFirstName + " " + driverLastName;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        final FormulaDriver that = (FormulaDriver) other;
        return number == that.number
                && Objects.equals(driverFirstName, that.driverFirstName)
                && Objects.equals(driverLastName, that.driverLastName)
                && Objects.equals(vehicleName, that.vehicleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverFirstName, driverLastName, vehicleName, number);
    }

    @Override
    public String toString() {
        return "FormulaDriver{" +
                "driverFirstName='" + driverFirstName + '\'' +
                ", driverLastName='" + driverLastName + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", number=" + number +
                '}';
    }
}
