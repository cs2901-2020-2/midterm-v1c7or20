package midterm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {
    @Test
    public void tesDataPoint() {
        DataPoint<Integer, String> dat = new DataPoint<>(1, "value");
        Assert.assertEquals((Integer) 1, dat.getIndex());
        Assert.assertTrue(dat.getValue().equals("value"));
    }

    @Test
    public void testAttach() {
    }

    @Test
    public void testNotifyAllObservers() {
    }
}
