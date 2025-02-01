import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("coursera/try-catch/test.txt")){
            int content;
            while((content = fis.read()) != -1){
                System.out.print((char)content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
