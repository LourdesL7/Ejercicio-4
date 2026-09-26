import java.util.ArrayList;

public class RentaMovil {

    private ArrayList<Vehiculo> vehiculos;
    private double ingresosAcumulados;

    public RentaMovil() {
        vehiculos = new ArrayList<>();
        ingresosAcumulados = 0.0;
    }

    public boolean registrarVehiculo(Vehiculo vehiculo) {

        if (vehiculo == null) {
            return false;
        }

        if (buscarVehiculo(vehiculo.getPlaca()) != null) {
            return false;
        }

        vehiculos.add(vehiculo);
        return true;
    }

    public Vehiculo buscarVehiculo(String placa) {

        if (placa == null || placa.trim().isEmpty()) {
            return null;
        }

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getPlaca().equalsIgnoreCase(
                    placa.trim())) {

                return vehiculo;
            }
        }

        return null;
    }

    public double cotizar(String placa, int dias) {

        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null || dias <= 0) {
            return -1;
        }

        return vehiculo.calcularCosto(dias);
    }

    public boolean confirmarAlquiler(String placa, int dias) {

        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null || dias <= 0) {
            return false;
        }

        if (!vehiculo.isDisponible()) {
            return false;
        }

        double costo = vehiculo.calcularCosto(dias);

        vehiculo.alquilar();
        ingresosAcumulados += costo;

        return true;
    }

    public boolean registrarDevolucion(String placa) {

        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null) {
            return false;
        }

        if (vehiculo.isDisponible()) {
            return false;
        }

        vehiculo.devolver();
        return true;
    }

    public void mostrarFlota() {

        if (vehiculos.isEmpty()) {
            System.out.println(
                    "No hay vehículos registrados."
            );
            return;
        }

        System.out.println("\n--- FLOTA DE RENTAMOVIL ---");

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(
                    vehiculo.obtenerInformacion()
            );
        }
    }

    public void mostrarReporte() {

        int disponibles = 0;
        int automovilesAlquilados = 0;
        int motocicletasAlquiladas = 0;
        int camionetasAlquiladas = 0;

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.isDisponible()) {

                disponibles++;

            } else if (vehiculo instanceof Automovil) {

                automovilesAlquilados++;

            } else if (vehiculo instanceof Motocicleta) {

                motocicletasAlquiladas++;

            } else if (vehiculo instanceof CamionetaCarga) {

                camionetasAlquiladas++;
            }
        }

        System.out.println("\n--- REPORTE GENERAL ---");

        System.out.println(
                "Total de vehículos: " + vehiculos.size()
        );

        System.out.println(
                "Vehículos disponibles: " + disponibles
        );

        System.out.println(
                "Automóviles alquilados: "
                        + automovilesAlquilados
        );

        System.out.println(
                "Motocicletas alquiladas: "
                        + motocicletasAlquiladas
        );

        System.out.println(
                "Camionetas de carga alquiladas: "
                        + camionetasAlquiladas
        );

        System.out.printf(
                "Ingresos acumulados: Q%.2f%n",
                ingresosAcumulados
        );
    }

    public double getIngresosAcumulados() {
        return ingresosAcumulados;
    }
}