package decoder;

import util.DictionaryChecker;
import util.FileReader;
import util.SomeUtil;

/**
 * Created by Dennis on 02-Dec-17.
 **/
public class Decoder {

    private FileReader fileReader;
    private SomeUtil someUtil;
    private DictionaryChecker dictionaryChecker;

    private String decodedMessage;

    public Decoder(String msgPath) {

        fileReader = new FileReader(msgPath);
        someUtil = new SomeUtil(fileReader.getMessage());
        dictionaryChecker = new DictionaryChecker(someUtil.getAllCombinations());
    }
}
