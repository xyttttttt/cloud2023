import org.junit.Test;

import java.time.ZonedDateTime;

public class Test1 {

    @Test
    public void test1(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
