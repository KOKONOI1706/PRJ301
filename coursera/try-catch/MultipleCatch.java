public class MultipleCatch {
    public static void main(String[] args) {
        try {
            int[] numbers = new int[5];
            numbers[5] = 10 / 2;
            System.out.println(numbers[5]);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
