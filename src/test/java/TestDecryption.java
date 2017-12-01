import org.junit.Test;
import util.ShiftUtil;

/**
 * Created by c-denipost on 01-Dec-17.
 */
public class TestDecryption {


    @Test
    public void test() {

        ShiftUtil shiftUtil = new ShiftUtil();

        System.out.println("Final result: " + shiftUtil.shift("buna", "ro", 26));
    }
}
