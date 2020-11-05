package midterm;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

public class BarChartMonitor implements CommandsObservers {

    private final Subject data;
    private final String path;

    public BarChartMonitor(Subject newData, String newPath){
        data = newData;
        path = newPath;
    }

    public void executeAndUpdate() throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (DataPoint<String, Integer> point : data.getData()){
            dataset.addValue(point.getValue(), point.getIndex(), "");
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "BarChart",
                "Index", "Value",
                dataset, PlotOrientation.VERTICAL,
                true,true,false);
        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File barChartFile = new File( path );

        ChartUtilities.saveChartAsJPEG( barChartFile , barChart , width , height );

    }
}
