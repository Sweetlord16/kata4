package kata4.eric.View;


import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private HistogramDisplay histogramDisplay;
    public MainFrame() throws HeadlessException {
        this.setTitle("Histograma de Alturas Eric");
        this.setSize(700,450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createHistogramDisplay());
    }

    private Component createHistogramDisplay() {
        JFchartDisplay display = new JFchartDisplay();
        this.histogramDisplay = display;
        return display;
    }

    public HistogramDisplay histogramDisplay(){
        return histogramDisplay;
    }

}