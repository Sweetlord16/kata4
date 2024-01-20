package kata4.eric.View;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.util.ArrayList;

public class JFchartDisplay extends JPanel implements HistogramDisplay {
    @Override
    public void show(DataProvider provider) {
        ArrayList<Integer> datos = provider.getAltura(); // Cambia a un nombre más genérico si es necesario
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Datos", datos.stream().mapToDouble(Integer::doubleValue).toArray(), 5);

        JFreeChart histo = ChartFactory.createHistogram(
                "",
                "Valores",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                false, false, false
        );
        XYPlot plot = (XYPlot) histo.getPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

        xAxis.setTickUnit(new NumberTickUnit(5));
        // Puedes ajustar los valores del rango según tus necesidades
        xAxis.setRange(20, 30);
        yAxis.setTickUnit(new NumberTickUnit(1));
        // Puedes ajustar los valores del rango según tus necesidades
        yAxis.setRange(0, 7);

        add(new ChartPanel(histo));
    }
}
