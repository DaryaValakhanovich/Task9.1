import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        File file = new File("poem.txt");
        HashMap<Character, Integer> letters = new HashMap<>();
        String punctuationMarks = "'.,?!:;";
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))){
            while (scanner.hasNext()){
                String word = scanner.next().toLowerCase();
                for (char l : word.toCharArray()){
                    if (punctuationMarks.indexOf(l) == -1){
                        if (letters.containsKey(l)) {
                            letters.put(l, letters.get(l) + 1);
                        } else {
                            letters.put(l, 1);
                        }
                    }
                }
            }
        }

        for (Map.Entry<Character, Integer> map : letters.entrySet()){
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }
}
