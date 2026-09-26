public class Motocicleta extends Vehiculo {

    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo,
                       double tarifaDiaria, int cilindraje) {

        super(placa, marca, modelo, tarifaDiaria);

        if (cilindraje <= 0) {
            throw new IllegalArgumentException(
                    "El cilindraje debe ser mayor que cero."
            );
        }

        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    @Override
    public double calcularCosto(int dias) {

        if (dias <= 0) {
            throw new IllegalArgumentException(
                    "Los días deben ser enteros positivos."
            );
        }

        double costo = getTarifaDiaria() * dias;

        if (cilindraje > 250) {
            costo += 75.0;
        }

        return costo;
    }

    @Override
    public String obtenerInformacion() {
        return "Motocicleta | "
                + super.obtenerInformacion()
                + " | Cilindraje: " + cilindraje + " cc";
    }
}