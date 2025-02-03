import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Toni");
        friends.add("Alex");
        friends.add("Bob");
        String out = "";
        String nameString;
        do {
            System.out.print("Enter the name of the friend: ");
            Scanner sc = new Scanner(System.in);
            nameString = sc.nextLine();

            int indexOfSearch = friends.indexOf(nameString);

            if (indexOfSearch != -1) {
                String name = friends.get(indexOfSearch);
                System.out.println("The name is " + name);

            } else {
                System.out.println("The name is not found");

            }
        } while (!nameString.equals("exit"));

        System.out.println("shutting down ...");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(2, 30);
        System.out.println(list);
    }

}
