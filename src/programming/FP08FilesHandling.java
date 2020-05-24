package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP08FilesHandling {

    public static void main(String[] args) throws IOException  {

        Files.lines(Paths.get("file.txt"))
                .map( words ->words.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .filter(word->word.length() >10)
                .forEach(System.out::println);


        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
}
