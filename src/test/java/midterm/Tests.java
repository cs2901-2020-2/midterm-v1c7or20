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

    @Test
    public void testSubject() throws IOException{
        Subject subject = new Subject();
        DataPoint<String, Integer> dat1 = subject.addData("dat1", 1);
        DataPoint<String, Integer> dat2 = subject.addData("dat2", 2);
        DataPoint<String, Integer> dat3 = subject.addData("dat3", 3);
        Assert.assertEquals("dat1", dat1.getIndex());
        Assert.assertEquals((Integer) 1, dat1.getValue());
        Assert.assertEquals("dat2", dat2.getIndex());
        Assert.assertEquals((Integer) 2, dat2.getValue());
        Assert.assertEquals("dat3", dat3.getIndex());
        Assert.assertEquals((Integer) 3, dat3.getValue());
        DataPoint<String, Integer> dat1R = subject.removeData("dat1");
        DataPoint<String, Integer> datNR = subject.removeData("datN");
        Assert.assertNull(datNR);
        Assert.assertEquals(dat1R.getIndex(), dat1.getIndex());
    }
}
