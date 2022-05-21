import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Visitor extends SimpleFileVisitor<Path>{
    private List<String> list = new ArrayList<>();
    private List<String> absList = new ArrayList<>();
    private int index;
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

//        int fileType = file.toString().lastIndexOf(".");
        if (!file.toAbsolutePath().toString().isEmpty())
        {
//            list.add(file.toString().substring(Program.indexRoot,
//                    fileType <= 0 ? file.toString().length() : fileType));
            list.add(file.toString().substring(Program.indexRoot));
            absList.add(file.toString());
            ++index;
        }

        return FileVisitResult.CONTINUE;
    }

    public List<String> getList() {
        return list;
    }

    public List<String> getAbsList() {
        return absList;
    }

    public int getIndex() {
        return index;
    }
}
