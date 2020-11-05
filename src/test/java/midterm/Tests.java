package midterm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tests {
    @Test
    public void tesDataPoint() {
        DataPoint<Integer, String> dat = new DataPoint<>(1, "value");
        Assert.assertEquals((Integer) 1, dat.getIndex());
        Assert.assertTrue(dat.getValue().equals("value"));
    }

    @Test
    public void testAttach() throws IOException {
        Observable toTest = new Observable();
        Subject subject = new Subject();
        subject.addData("val", 12);
        BarChartMonitor bar = new BarChartMonitor(subject,"dummyPath");
        toTest.attach(bar);
        toTest.notifyAllObservers();
        Assert.assertTrue(true,"testAttachAndNotify");
    }

}
