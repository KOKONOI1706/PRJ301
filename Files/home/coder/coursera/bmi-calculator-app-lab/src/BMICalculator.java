// BMICalculator class is a utility class that's used to calculate the BMI value in both Imperial and Metric systems
public class BMICalculator {

    // Please declare 4 attributes/properties to represent weight in pounds, height in inches, weight in kilos and height in meters
    double weightInPounds;
    double heightInInches;
    double weightInKilos;
    double heightInMeters;

    // Please use this default no arguments constructor to initialize the 4 properties to some initial values
    public BMICalculator() {
        this.heightInInches = 0;
        this.heightInMeters = 0;
        this.weightInKilos = 0;
        this.weightInPounds = 0;
    }

    // Please implement the cal
    // culateBmiImperial() method to take in weight and height to calculate and return the BMI value in the Imperial system
    public double calculateBmiImperial(double weightInPounds, double heightInInches) {
        this.weightInPounds = weightInPounds;
        this.heightInInches = heightInInches;
        return (703 * weightInPounds) / (heightInInches * heightInInches);
    }

    // Please implement the calculateBmiMetric() method to take in weight and height to calculate and return the BMI value in the Metric system
    public double calculateBmiMetric(double weightInKilos, double heightInMeters) {
        this.weightInKilos = weightInKilos;
        this.heightInMeters = heightInMeters;
        return weightInKilos / (heightInMeters * heightInMeters);
    }

    // Please implement the getBMICategory() method so that it takes the BMI value and returns the BMI category based on it
    public String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
