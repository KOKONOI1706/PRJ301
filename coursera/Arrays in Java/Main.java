public class Main {
    public static void main(String[] args) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // Can also be done as:

        String daysOfWeek_declareFirst[];

        daysOfWeek_declareFirst = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println("First Element: " + daysOfWeek_declareFirst[0]);
        System.out.println("Fourth Element: " + daysOfWeek_declareFirst[3]);
    }
}
