import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class CheckMapTest {
    CheckMap checkMap = new CheckMap();
    @Test
    public void check() {
        Calendar calendar = new GregorianCalendar(1975,
                Calendar.DECEMBER, 31);
        System.out.println(new JSONObject(checkMap.addUsers(new User("Alex", 3, calendar), new User("Alex", 3, calendar))).toString());
    }

}