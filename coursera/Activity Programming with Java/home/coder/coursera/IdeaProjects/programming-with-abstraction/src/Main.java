import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Calculating Area of Rectangle: ");
        System.out.print("Enter Width:");
        float w = keyBoard.nextFloat();
        System.out.print("Enter height: ");
        float h = keyBoard.nextFloat();
        Rectangle rct = new Rectangle(w, h);
        rct.draw();
        System.out.println("Area: " + rct.calculateArea());
        System.out.println("Perimeter: " + rct.perimeter());

        System.out.println("Calculating Area of Circle: ");
        System.out.print("Enter radius:");
        float r = keyBoard.nextFloat();
        Circle cr = new Circle(r);
        cr.draw();
        System.out.println("Area: " + cr.calculateArea());
        System.out.println("Perimeter: " + cr.perimeter());
    }
}
