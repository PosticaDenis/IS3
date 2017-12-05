package util;

import java.util.List;

/**
 * Created by Dennis on 02-Dec-17.
 **/
public class StatsAnalyzer {

    private List<String> combinations;

    public StatsAnalyzer(List<String> combinations) {

        this.combinations = combinations;
    }

    public void process(List<String> stats) {


        String bingo = stats.get(0);
        //int tmp = 0;

        for (int i = 0; i < stats.size() - 1; i++) {

            if (Integer.parseInt(stats.get(i+1).split(":")[0]) > Integer.parseInt(stats.get(i).split(":")[0])) {

                bingo = stats.get(i+1);
            }
        }

        String lang = bingo.split(":")[2];
        String cipherKey = bingo.split(":")[1];

        System.out.println("Mostly probable the language used is " + lang + ". The cipher key is " + cipherKey + ".");
        System.out.println("MESSAGE: " + combinations.get(Integer.parseInt(cipherKey)));
        System.out.println("");
    }
}
