import java.io.*;

public class file {
    public static String readFile(String fileName) throws IOException {
        StringBuilder str = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            str.append(br.read());
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
}