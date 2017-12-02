package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

/**
 * Created by Dennis on 02-Dec-17.
 **/
public class DictionaryChecker {

    private static List<String> availableLanguages = Arrays.asList("eng", "ro", "ru", "fr", "it", "esp", "de");

    private URL url = this.getClass().getClassLoader().getResource("languages");

    public DictionaryChecker(List<String> allCombinations) {

        //availableLanguages = new ArrayList<String>();
        //setAvailableLanguages();

        analyze(allCombinations);
    }

    private void analyze(List<String> allCombinations) {

        for (String s: allCombinations) {
            System.out.println("comb: " + s);
        }

        /*for (String msg: allCombinations) {

            String[] words = msg.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                // You may want to check for a non-word character before blindly
                // performing a replacement
                // It may also be necessary to adjust the character class
                words[i] = words[i].replaceAll("[^\\w]", "");
            }


        }*/
    }

    private void setAvailableLanguages() {

        try {
            File directory = new File(url.toURI());

            File[] fList = directory.listFiles();
            for (File file : fList) {
                if (file.isFile()) {
                    availableLanguages.add(file.getName().split(".txt")[0]);
                }
            }
        } catch (Exception e) {

            System.out.println("Error reading languages resources!");
            e.printStackTrace();
        }
    }

    private Set<String> getDictionary(String language) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(url.toString().substring(5) + "/" + language + ".txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary for language " + language + " was not found.");
            e.printStackTrace();
        }

        LinkedHashSet<String> dictionary = new LinkedHashSet<String>();
        while (scanner.hasNext()) {
            dictionary.add(scanner.next().trim().toLowerCase());
        }
        return dictionary;
    }
}
