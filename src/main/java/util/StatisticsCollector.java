package util;

import com.google.common.base.CharMatcher;

import java.util.List;
import java.util.Set;

/**
 * Created by Dennis on 02-Dec-17.
 **/
public class StatisticsCollector{

    private String language;
    private List<String> combinations;
    private Set<String> dictionary;

    //private int stat;
    //private int key;

    public StatisticsCollector(String lang, List<String> aCombinations, Set<String> dictionary) {

        this.language = lang;
        this.combinations = aCombinations;
        this.dictionary = dictionary;

    }

    public String generateStats() {

        int stat = 0;
        int key = 0;

        int tmpStat;
        int counter = -1;

        for (String combination: combinations) {
            counter ++;
            tmpStat =0;

            String charsToRemove = "\uFEFF~!@#$%^&*1234567890-_=+[{]};:'|?/>.<,";

            String filtered = CharMatcher.anyOf(charsToRemove).removeFrom(combination);

            String[] words = filtered.split("\\s+");

            for (String word: words) {

                if (!SomeUtil.isIsCyrillic()) {
                    if (dictionary.contains(word.toLowerCase())) {
                        tmpStat += word.length();
                    }
                } else {

                    for (String w: dictionary) {
                        if (w.equals(word.toLowerCase())) {
                            tmpStat += word.length();
                        }
                    }
                }
            }

            if (stat < tmpStat) {

                key = counter;
                stat = tmpStat;
            }
        }

        return stat + ":" + key + ":" + language;
    }
}
