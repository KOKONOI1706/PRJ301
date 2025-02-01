import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchTest {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number a: ");
            int a = sc.nextInt();
            System.out.print("Enter number b: ");
            int b = sc.nextInt();
            int result = a / b;
            System.out.println("Result: " + result);
        }catch(ArithmeticException e){
            System.out.println("Division by zero is not allowed!");

        }catch (InputMismatchException e){
            System.out.println("Please an integer " +
                    "!");
        }
        finally{
            System.out.println("Shutting down...");
        }


    }
}
