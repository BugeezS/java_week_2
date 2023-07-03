import java.util.Scanner;

public class MeasurementsTransCalculation {
    enum Unit {
        M("m", 1),
        CM("cm", 0.01),
        MM("mm", 0.001);

        private String symbol;
        private double conversionFactor;

        Unit(String symbol, double conversionFactor) {
            this.symbol = symbol;
            this.conversionFactor = conversionFactor;
        }

        public String getSymbol() {
            return symbol;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length: ");
        String lengthStr = scanner.nextLine();
        double length = parseMeasurement(lengthStr);

        System.out.print("Enter the width: ");
        String widthStr = scanner.nextLine();
        double width = parseMeasurement(widthStr);

        double surface = length * width;

        System.out.println("The surface is: " + surface + " square meters");
    }

    private static double parseMeasurement(String measurement) {
        for (Unit unit : Unit.values()) {
            if (measurement.endsWith(unit.getSymbol())) {
                String valueStr = measurement.substring(0, measurement.length() - unit.getSymbol().length()).trim();
                double value = Double.parseDouble(valueStr);
                return value * unit.getConversionFactor();
            }
        }

        throw new IllegalArgumentException("Invalid measurement format: " + measurement);
    }
}
