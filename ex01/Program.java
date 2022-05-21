import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class Program {

    public static int indexRoot;

    public static void main(String[] args) {
        String separator = File.separator;
        if (args.length != 1)
        {
            System.out.println("[ java program absolute_path_directory ]");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists())
        {
            System.out.println("path does not exist!!!");
            System.exit(1);
        }
        indexRoot = file.toString().length() + 1;
        System.out.println("Folder 2/File 2-1".compareTo("Folder 1/File 1-1"));
        Visitor visitor = new Visitor();
        WorkFile workfile = new WorkFile();

        try {

            FileInputStream inputStream = null;
            Files.walkFileTree(Paths.get(args[0]), visitor);
            Collections.sort(visitor.getList());
            Collections.sort(visitor.getAbsList());

            for (String s : visitor.getList())
                System.out.println(s);

            FileOutputStream fileOutput = workfile.createFile(file.toString(), separator);
            for (int i = 0; i < visitor.getIndex() - 1; ++i)
            {
                inputStream = new FileInputStream(visitor.getAbsList().get(i));
                workfile.readText(inputStream);
            }

            fileOutput.write(workfile.getStr().getBytes());
            fileOutput.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




