import java.io.*;

public class FileUtils {
    public static String readFile(File fileName) throws IOException {
        StringBuilder str = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            str.append((char) br.read());
        }
        br.close();
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

    public static int countCharacters(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int characterCount = 0;
        while (br.ready()) {
            br.read();
            characterCount++;
        }
        br.close();
        return characterCount;
    }

}