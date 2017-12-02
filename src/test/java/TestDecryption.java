import decoder.Decoder;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ShiftUtil;

/**
 * Created by c-denipost on 01-Dec-17.
 **/
public class TestDecryption {

    @Test
    public void test() {

        ShiftUtil shiftUtil = new ShiftUtil();

        //System.out.println("Final result: " + shiftUtil.shift("buna", "ro", 1));
        assertFalse(shiftUtil.shift("buna", "ro", 1).equals("buna"));
        assertTrue(shiftUtil.shift("buna", "ro", 26).equals("buna"));
    }

    @Test
    public void testDecoder() {

        String msg = "messages/m2.txt";
        Decoder decoder = new Decoder(msg);
    }
}
