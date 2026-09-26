public abstract class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private double tarifaDiaria;
    private boolean disponible;

    public Vehiculo(String placa, String marca, String modelo,
                    double tarifaDiaria) {

        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La placa no puede estar vacía."
            );
        }

        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La marca no puede estar vacía."
            );
        }

        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El modelo no puede estar vacío."
            );
        }

        if (tarifaDiaria <= 0) {
            throw new IllegalArgumentException(
                    "La tarifa diaria debe ser mayor que cero."
            );
        }

        this.placa = placa.trim();
        this.marca = marca.trim();
        this.modelo = modelo.trim();
        this.tarifaDiaria = tarifaDiaria;
        this.disponible = true;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void alquilar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    public abstract double calcularCosto(int dias);

    public String obtenerInformacion() {
        return "Placa: " + placa
                + " | Marca: " + marca
                + " | Modelo: " + modelo
                + " | Tarifa diaria: Q"
                + String.format("%.2f", tarifaDiaria)
                + " | Disponible: "
                + (disponible ? "Sí" : "No");
    }
}