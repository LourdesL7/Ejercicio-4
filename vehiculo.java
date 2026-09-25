import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public abstract class Vehiculo {

    private final String placa;
    private final String marca;
    private final String modelo;
    private final BigDecimal tarifaDiaria;
    private boolean disponible;

    public Vehiculo(String placa, String marca, String modelo,
                    BigDecimal tarifaDiaria) {

        this.placa = normalizarPlaca(placa);
        this.marca = textoValido(marca);
        this.modelo = textoValido(modelo);
        this.tarifaDiaria = positivo(tarifaDiaria);
        this.disponible = true;
    }

    public static String normalizarPlaca(String placa) {
        return textoValido(placa).toUpperCase(Locale.ROOT);
    }

    private static String textoValido(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "La placa, marca y modelo no pueden estar vacios."
            );
        }

        return texto.trim();
    }

    protected static BigDecimal positivo(BigDecimal valor) {
        if (valor == null || valor.signum() <= 0) {
            throw new IllegalArgumentException(
                "La tarifa y la capacidad deben ser mayores que cero."
            );
        }

        return valor;
    }

    protected BigDecimal calcularBase(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException(
                "Los dias deben ser enteros positivos."
            );
        }

        return tarifaDiaria.multiply(BigDecimal.valueOf(dias));
    }

    protected BigDecimal redondear(BigDecimal monto) {
        return monto.setScale(2, RoundingMode.HALF_UP);
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    void alquilar() {
        if (!disponible) {
            throw new IllegalStateException(
                "El vehiculo ya esta alquilado."
            );
        }

        disponible = false;
    }

    void devolver() {
        if (disponible) {
            throw new IllegalStateException(
                "El vehiculo ya esta disponible."
            );
        }

        disponible = true;
    }

    public abstract BigDecimal calcularCosto(int dias);

    public abstract String getCategoria();

    public abstract String getCaracteristicas();

    @Override
    public String toString() {
        return getCategoria()
            + " | " + placa
            + " | " + marca + " " + modelo
            + " | tarifa: Q" + redondear(tarifaDiaria).toPlainString()
            + " | " + getCaracteristicas()
            + " | " + (disponible ? "Disponible" : "Alquilado");
    }
}