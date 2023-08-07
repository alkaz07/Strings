import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Path path = Paths.get("exemple.txt");
        try {
            List<String> list = Files.readAllLines(new File("exemple.txt").toPath(), Charset.forName("UTF-8"));//"Windows-1251"
            System.out.println(list);
            String wholeText = list.toString();
            //сделать замену в тексте
            wholeText = wholeText.replaceAll("Мама|Папа", "Родитель")
                                 .replaceAll("мама|папа", "родитель")
                                 .replaceAll("маму|папу", "родителя")
                                 .replaceAll("маме|папе", "родителю")
                                 .replaceAll("мамой|папой", "родителем")
            ;
            System.out.println(wholeText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}