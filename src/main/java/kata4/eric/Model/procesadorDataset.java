package kata4.eric.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class procesadorDataset {
    public static void main(String[] args) {
        List<Registro> registros = new ArrayList<>();
        loadDataset(registros,"src/datos.csv");

        HashMap<Integer, Integer> histogramaAlturas = new HashMap<>();
        for(Registro registro: registros) {
            int altura = registro.getAltura();
            histogramaAlturas.put(altura, histogramaAlturas.getOrDefault(altura,0) + 1);
        }
        for(Integer altura: histogramaAlturas.keySet()){
            System.out.println("Altura:" + altura + ", Frecuencia: " + histogramaAlturas.get(altura));
        }
    }


    private static void loadDataset(List<Registro> registros, String datos) {
        try(BufferedReader br = new BufferedReader(new FileReader(datos))) {
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                String[] valores = line.split(";");
                registros.add(new Registro(valores[0], Integer.parseInt(valores[1])));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
