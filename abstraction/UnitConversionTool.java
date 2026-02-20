public class UnitConversionTool {

    public static void main(String[] args) {
        System.out.println("100 km = " + UnitConverter.kmToMiles(100) + " miles");
        System.out.println("50 kg = " + UnitConverter.kgToLbs(50) + " lbs");
        System.out.println("10 miles = " + UnitConverter.milesToKm(10) + " km");
        System.out.println("110 lbs = " + UnitConverter.lbsToKg(110) + " kg");
    }
}

interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double milesToKm(double miles) {
        return miles * 1.60934;
    }

    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }

    static double lbsToKg(double lbs) {
        return lbs / 2.20462;
    }
}
