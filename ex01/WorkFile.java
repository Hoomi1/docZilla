import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WorkFile {
    private String str = "";

    public FileOutputStream createFile(String str, String separator) throws IOException {
        FileOutputStream fileOutputStream;
        if (str.charAt(str.length() - 1) == separator.charAt(0)) {
            System.out.println(str + "test.txt");
            return fileOutputStream = new FileOutputStream(str + "test.txt", false);
        }
        else {
            System.out.println(str + separator + "test.txt");
            return fileOutputStream = new FileOutputStream(str + separator + "test.txt", false);
        }
    }

    public void readText(FileInputStream fileInputStream) throws IOException {
        int i = 0;
        while ((i = fileInputStream.read()) != -1)
        {
            str += (char)i;
        }
    }

    public String getStr() {
        return str;
    }
}
