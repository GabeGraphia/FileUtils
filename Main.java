import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        FileUtils.writeFile("test.txt", "test");
        // System.out.println(file.readFile("test.txt"));
        File x = new File("test.txt");
        System.out.println(FileUtils.readFile(x));
    }
}
