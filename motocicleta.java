import java.math.BigDecimal;

public class Motocicleta extends Vehiculo {

    private final int cilindraje;

    public Motocicleta(String placa, String marca, String modelo,
                       BigDecimal tarifa, int cilindraje) {

        super(placa, marca, modelo, tarifa);

        if (cilindraje <= 0) {
            throw new IllegalArgumentException(
                "El cilindraje debe ser mayor que cero."
            );
        }

        this.cilindraje = cilindraje;
    }

    @Override
    public BigDecimal calcularCosto(int dias) {
        BigDecimal costo = calcularBase(dias);

        if (cilindraje > 250) {
            costo = costo.add(BigDecimal.valueOf(75));
        }

        return redondear(costo);
    }

    @Override
    public String getCategoria() {
        return "Motocicleta";
    }

    @Override
    public String getCaracteristicas() {
        return cilindraje + " cc";
    }
}