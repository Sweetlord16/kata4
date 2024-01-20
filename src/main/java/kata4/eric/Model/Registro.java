package kata4.eric.Model;

public class Registro {
    private String nombre_planta;
    private int altura;

    public Registro(String nombre_planta, int altura) {
        this.nombre_planta = nombre_planta;
        this.altura = altura;
    }

    public String getNombre_planta() {
        return nombre_planta;
    }

    public void setNombre_planta(String nombre_planta) {
        this.nombre_planta = nombre_planta;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "nombre_planta='" + nombre_planta + '\'' +
                ", altura=" + altura +
                '}';
    }
}
