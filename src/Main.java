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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Path path = Paths.get("exemple.txt");
       //task1();
       task2();


    }

    static void task2() {
        System.out.println("Введите имя файла");
        Scanner scanner = new Scanner(System.in);
        String nameOfFile = scanner.next();
        try {
            List<String> list = Files.readAllLines(new File(nameOfFile).toPath(), Charset.forName("UTF-8"));//"Windows-1251"
            String wholeText = list.toString();
            //Узнать количество (b.txt
            //Узнать количество )
            System.out.println(wholeText);
            int counterRoundOpen  = countOccurences(wholeText, "(");
            int counterRoundClose = countOccurences(wholeText, ")");
            int counterSlashOpen  = countOccurences(wholeText, "/*");
            int counterSlashClose = countOccurences(wholeText, "*/");
            int counterFigureOpen  = countOccurences(wholeText, "{");
            int counterFigureClose = countOccurences(wholeText, "}");
            int counterSquareOpen = (int) wholeText.chars().filter(x -> x == '[').count();
            int counterSquareClose= (int) wholeText.chars().filter(x -> x == ']').count();
            System.out.println("[ "+counterSquareOpen);
            System.out.println("] "+counterSquareClose);
//            for (int i = 0; i < wholeText.length(); i++) {
//                char c = wholeText.charAt(i);
//                if(c == '(')
//                    counterRoundOpen++;
//                if(c == ')')
//                    counterRoundClose++;
//                if(c == '/' && i<wholeText.length()-1 && wholeText.charAt(i+1)=='*')
//                    counterSlashOpen++;
  //          }
            if(counterRoundClose != counterRoundOpen
                    || counterSlashOpen != counterSlashClose
                    || counterSquareOpen!= counterSquareClose
                    || counterFigureOpen!= counterFigureClose)
                System.out.println("все плохо");
            else
                System.out.println("все хорошо");
        } catch (IOException e) {
            System.out.println("С файлом что-то не то");
        }

    }

    static int countOccurences(String source, String toFind)
    {
        String s = source.replace(toFind, "");
        int delta = source.length() - s.length();
        int result = delta / toFind.length();
        return result;
    }

    static void task1() {
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