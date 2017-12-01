package util;

/**
 * Created by c-denipost on 01-Dec-17.
 *
 * Supports russian language, without Ё,ё
 * Supports latin based languages, without special characters (à, á, â, Ì, Ò, Ù, Î, Ă, Ș, Ț, etc)
 **/
public class ShiftUtil {



    public String shift(String letter, String language, int times) {

        //try {
            //byte bytes[] = letter.getBytes("ISO-8859-1");
            //System.out.println("Initial letter: " + new String(bytes, "UTF-8"));
            System.out.println(letter);
        //} catch (UnsupportedEncodingException e) {
        //    e.printStackTrace();
        //}

        String bar = "";

        if (language.equals("ru")) {

            for (char c : letter.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    bar += Character.toString((char) (((c - 'А' + times) % 32) + 'А'));
                }
                else {
                    bar += Character.toString((char) (((c - 'а' + times) % 32) + 'а'));
                }
            }
        }
        /*if (language.equals("ro")) {
            for (char c : letter.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    bar += Character.toString((char) (((c - 'А' + times) % 32) + 'А'));
                }
                else {
                    bar += Character.toString((char) (((c - 'а' + times) % 32) + 'а'));
                }
            }
        }*/
        else {
            for (char c : letter.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    bar += Character.toString((char) (((c - 'A' + times) % 26) + 'A'));
                }
                else {
                    bar += Character.toString((char) (((c - 'a' + times) % 26) + 'a'));
                }
            }
        }

        return bar;
    }
}
