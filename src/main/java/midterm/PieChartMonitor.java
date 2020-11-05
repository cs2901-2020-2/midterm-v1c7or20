package midterm;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.ChartUtilities;
import org.jfree.data.general.DefaultPieDataset;

import java.io.File;
import java.io.IOException;

public class PieChartMonitor implements CommandsObservers {
    final private Subject data;
    final private String path;

    public PieChartMonitor(Subject newData, String newPath){
        data = newData;
        path = newPath;
    }

    public void executeAndUpdate() throws IOException {
        DefaultPieDataset  dataset = new DefaultPieDataset();

        for (DataPoint<String, Integer> point : data.getData()){
            dataset.setValue(point.getIndex(), point.getValue());
        }

        JFreeChart pieChart = ChartFactory.createPieChart("PieChart", dataset,true, true, false);
        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File pierChartString = new File( path );

        ChartUtilities.saveChartAsJPEG( pierChartString , pieChart , width , height );

    }
}
