public class CamionetaCarga extends Vehiculo {

    private double capacidadToneladas;

    public CamionetaCarga(String placa, String marca, String modelo,
                          double tarifaDiaria,
                          double capacidadToneladas) {

        super(placa, marca, modelo, tarifaDiaria);

        if (capacidadToneladas <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero."
            );
        }

        this.capacidadToneladas = capacidadToneladas;
    }

    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }

    @Override
    public double calcularCosto(int dias) {

        if (dias <= 0) {
            throw new IllegalArgumentException(
                    "Los días deben ser enteros positivos."
            );
        }

        double costoBase = getTarifaDiaria() * dias;

        double recargo =
                capacidadToneladas * 100.0 * dias;

        return costoBase + recargo;
    }

    @Override
    public String obtenerInformacion() {
        return "Camioneta de carga | "
                + super.obtenerInformacion()
                + " | Capacidad: "
                + String.format("%.2f", capacidadToneladas)
                + " toneladas";
    }
}