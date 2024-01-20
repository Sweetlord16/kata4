package kata4.eric.View;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.util.ArrayList;

public class JFchartDisplay extends JPanel implements HistogramDisplay {

    @Override
    public void show(DataProvider provider) {
        ArrayList<Integer> alturas = provider.getAltura("C:\\Users\\Eric\\IdeaProjects\\kata3\\src\\main\\java\\kata3\\eric\\datos.csv");

        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Alturas" , alturas.stream().mapToDouble(Integer::doubleValue).toArray(),14);

        JFreeChart histogram = ChartFactory.createHistogram(
                "",
                "Alturas",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                false,false,false);
        add(new ChartPanel(histogram));
    }
}