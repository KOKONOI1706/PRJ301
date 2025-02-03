import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            ArrayList<String> listOfEvent = new ArrayList<String>();
            listOfEvent.add("Morning meeting");
            listOfEvent.add("Email Correspondence");
            listOfEvent.add("Study Session");
            listOfEvent.add("Project Work");
            listOfEvent.add("Evening Jog");

            int indexToGet = 3;
            addElement(indexToGet,listOfEvent);
            listOfEvent.remove("Evening Jog");
            for(String list : listOfEvent){
                System.out.println(list);
            }
    }
    public static void addElement(int indexToGet, ArrayList<String> listOfEvent) {
        listOfEvent.add(indexToGet,"doctor's appointment");
    }
}
