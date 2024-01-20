package kata4.eric;

import kata4.eric.View.DataProvider;
import kata4.eric.View.MainFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        String path = "C:\\Users\\Eric\\IdeaProjects\\kata3\\src\\main\\java\\kata3\\eric\\datos.csv";
        try{
            mainFrame.histogramDisplay().show(new DataProvider() {
                @Override
                public ArrayList<Integer> getAltura(String path) {
                    ArrayList<Integer> alturas = new ArrayList<>();
                    try(BufferedReader br = new BufferedReader(new FileReader(path))){
                        String line;
                        br.readLine();
                        while((line = br.readLine()) != null){
                            String[] fragmentos = line.split(";");
                            if(fragmentos.length >= 2){
                                alturas.add(Integer.parseInt(fragmentos[1]));
                            }else {
                                System.err.println("Error en la linea" + line);
                            }
                        }
                    }catch (IOException | NumberFormatException e){
                        e.printStackTrace();
                    }
                    return alturas;
                }
            });
            mainFrame.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Error al cargar el archivo" + e.getMessage());
        }
    }
}

