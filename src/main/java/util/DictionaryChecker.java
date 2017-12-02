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

    private StatsAnalyzer statsAnalyzer;

    public DictionaryChecker(List<String> allCombinations) {

        //availableLanguages = new ArrayList<String>();
        //setAvailableLanguages();
        statsAnalyzer = new StatsAnalyzer(allCombinations);

        analyze(allCombinations);
    }

    private void analyze(List<String> allCombinations) {

        List<String> stats = new ArrayList<String>();

        for (String lang: availableLanguages) {

            StatisticsCollector statisticsCollector = new StatisticsCollector(lang, allCombinations, getDictionary(lang));
            stats.add(statisticsCollector.generateStats());
        }

        statsAnalyzer.process(stats);
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
