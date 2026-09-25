import java.math.BigDecimal;

public class Automovil extends Vehiculo {

    private final int pasajeros;
    private final boolean automatico;

    public Automovil(String placa, String marca, String modelo,
                     BigDecimal tarifa, int pasajeros,
                     boolean automatico) {

        super(placa, marca, modelo, tarifa);

        if (pasajeros <= 0) {
            throw new IllegalArgumentException(
                "Los pasajeros deben ser mayores que cero."
            );
        }

        this.pasajeros = pasajeros;
        this.automatico = automatico;
    }

    @Override
    public BigDecimal calcularCosto(int dias) {
        BigDecimal costo = calcularBase(dias);

        if (automatico) {
            BigDecimal recargo = BigDecimal.valueOf(50)
                .multiply(BigDecimal.valueOf(dias));

            costo = costo.add(recargo);
        }

        return redondear(costo);
    }

    @Override
    public String getCategoria() {
        return "Automovil";
    }

    @Override
    public String getCaracteristicas() {
        return pasajeros + " pasajeros | "
            + (automatico ? "Automatico" : "Manual");
    }
}