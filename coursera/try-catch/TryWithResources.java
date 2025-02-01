import java.io.FileInputStream;

public class TryWithResources {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test.txt"))
    }
}
