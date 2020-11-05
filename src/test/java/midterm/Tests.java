package midterm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
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
        File file = new File("dummyPath.jpeg");
        Assert.assertTrue(file.exists());
    }

    @Test
    public void testBarChart() throws IOException {
        BarChartMonitor barChartMonitor = new BarChartMonitor(new Subject(), "dummyPath2");
        barChartMonitor.executeAndUpdate();
        File file = new File("dummyPath2.jpeg");
        Assert.assertTrue(file.exists());
    }

    @Test
    public void testPieChart() throws IOException {
        PieChartMonitor pieChartMonitor = new PieChartMonitor(new Subject(), "dummyPath3");
        pieChartMonitor.executeAndUpdate();
        File file = new File("dummyPath3.jpeg");
        Assert.assertTrue(file.exists());
    }
}
