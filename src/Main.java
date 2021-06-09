import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    static final String PATH = "C:\\Progmeistars\\Words\\Files\\100000-russian-words.txt";

    public static void main(String[] args) throws IOException {
        List<String> ListOfWords = CreateListOfWords();
        GameProcess(ListOfWords);
    }
    public static List<String> CreateListOfWords() throws IOException {
        Path path = Paths.get(PATH);
        return Files.readAllLines(path);
    }
    public static void GameProcess(List<String> ListOfWords) {
        Scanner StrScanner = new Scanner(System.in);
        List<String> UsedWords = new ArrayList<String>();
        String word;
        String letter = new String();
        for (;;) {
            System.out.println("Введи слово на " + letter);
            word = StrScanner.nextLine();

            if (word.startsWith(letter) && !CheckInUsed(UsedWords, word) && !CheckInAllWords(ListOfWords, word)) {
                UsedWords.add(word);
                letter = Character.toString(word.charAt(word.length() - 1));
                letter = letter.toUpperCase(Locale.ROOT);
            } else {
                System.out.println("Ты проиграл");
                break;
            }
        }
    }
    public static boolean CheckInUsed(List<String> UsedWords, String word) {
        return UsedWords.contains(word);
    }
    public static boolean CheckInAllWords(List<String> LisOfAllWords, String word) {
        return LisOfAllWords.contains(word);
    }
}
