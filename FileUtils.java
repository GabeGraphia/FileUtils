import java.io.*;

public class FileUtils {
    public static String readFile(File fileName) {

        StringBuilder str = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while (br.ready()) {
                str.append((char) br.read());
            }
            br.close();

        } catch (Exception E) {
            System.out.println("bruh:\n" + E);
        }
        return str.toString();
    }

    /*
     * tries to write text to File fileName, if file doesn't exist, then creates
     * file with name fileName
     */
    public static boolean writeFile(String fileName, String text) {
        try {
            PrintWriter pr = new PrintWriter(fileName);
            pr.write(text);
            pr.close();
        } catch (Exception fileNotFoundException) {
            File fl = new File(fileName);
            PrintWriter pr;
            try {
                pr = new PrintWriter(fl);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            pr.write(text);
            pr.close();
        }
        return true;
    }

    public static int countCharacters(String fileName) {
        int characterCount = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while (br.ready()) {
                br.read();
                characterCount++;
            }
            br.close();

        } catch (Exception E) {
            System.out.println("bruh:\n" + E);
        }
        return characterCount;
    }

    public static void main(String[] args) {
        String text = "123456789";
        String fileName = "NamedFile";
        // test writeFile
        writeFile(fileName, text);
        // test readFile
        File testFile = new File(
                "c:/Users/benja/Documents/VSCode/HTopics Repos&Notes/HTopics Day 002/HTopicsDay002/NamedFile.txt");
        System.out.println(readFile(testFile));
        // test countCharacters
        System.out.println(countCharacters(fileName));
        // make sure we finished the tester
        System.out.println("end tester");
    }

}