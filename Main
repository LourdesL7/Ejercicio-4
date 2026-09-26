import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        RentaMovil rentaMovil = new RentaMovil();

        cargarVehiculosIniciales(rentaMovil);

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarVehiculo(rentaMovil);
                    break;

                case 2:
                    rentaMovil.mostrarFlota();
                    break;

                case 3:
                    cotizarAlquiler(rentaMovil);
                    break;

                case 4:
                    confirmarAlquiler(rentaMovil);
                    break;

                case 5:
                    registrarDevolucion(rentaMovil);
                    break;

                case 6:
                    rentaMovil.mostrarReporte();
                    break;

                case 7:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    private static void cargarVehiculosIniciales(RentaMovil rentaMovil) {

        // Automóvil automático
        rentaMovil.registrarVehiculo(
                new Automovil(
                        "AUT001",
                        "Toyota",
                        "Corolla",
                        250.0,
                        5,
                        true
                )
        );

        // Automóvil manual
        rentaMovil.registrarVehiculo(
                new Automovil(
                        "AUT002",
                        "Honda",
                        "Civic",
                        225.0,
                        5,
                        false
                )
        );

        // Motocicleta de hasta 250 cc
        rentaMovil.registrarVehiculo(
                new Motocicleta(
                        "MOT001",
                        "Honda",
                        "CB190R",
                        100.0,
                        190
                )
        );

        // Motocicleta de más de 250 cc
        rentaMovil.registrarVehiculo(
                new Motocicleta(
                        "MOT002",
                        "Yamaha",
                        "MT-03",
                        150.0,
                        321
                )
        );

        // Camioneta con capacidad decimal
        rentaMovil.registrarVehiculo(
                new CamionetaCarga(
                        "CAM001",
                        "Toyota",
                        "Hilux",
                        200.0,
                        1.5
                )
        );

        rentaMovil.registrarVehiculo(
                new CamionetaCarga(
                        "CAM002",
                        "Ford",
                        "Ranger",
                        250.0,
                        2.0
                )
        );
    }

    private static void mostrarMenu() {

        System.out.println("\n==============================");
        System.out.println("          RENTAMOVIL");
        System.out.println("==============================");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Consultar flota");
        System.out.println("3. Cotizar alquiler");
        System.out.println("4. Confirmar alquiler");
        System.out.println("5. Registrar devolución");
        System.out.println("6. Mostrar reporte general");
        System.out.println("7. Salir");
        System.out.println("==============================");
    }

    private static void registrarVehiculo(RentaMovil rentaMovil) {

        System.out.println("\n--- REGISTRAR VEHÍCULO ---");
        System.out.println("1. Automóvil");
        System.out.println("2. Motocicleta");
        System.out.println("3. Camioneta de carga");

        int tipo = leerEntero("Seleccione el tipo: ");

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de vehículo inválido.");
            return;
        }

        String placa = leerTextoNoVacio("Placa: ");

        if (rentaMovil.buscarVehiculo(placa) != null) {
            System.out.println(
                    "Error: ya existe un vehículo con esa placa."
            );
            return;
        }

        String marca = leerTextoNoVacio("Marca: ");
        String modelo = leerTextoNoVacio("Modelo: ");

        double tarifaDiaria = leerDoublePositivo(
                "Tarifa diaria: Q"
        );

        Vehiculo nuevoVehiculo;

        switch (tipo) {

            case 1:

                int pasajeros = leerEnteroPositivo(
                        "Cantidad de pasajeros: "
                );

                boolean automatico = leerSiNo(
                        "¿La transmisión es automática? (S/N): "
                );

                nuevoVehiculo = new Automovil(
                        placa,
                        marca,
                        modelo,
                        tarifaDiaria,
                        pasajeros,
                        automatico
                );

                break;

            case 2:

                int cilindraje = leerEnteroPositivo(
                        "Cilindraje (cc): "
                );

                nuevoVehiculo = new Motocicleta(
                        placa,
                        marca,
                        modelo,
                        tarifaDiaria,
                        cilindraje
                );

                break;

            case 3:

                double capacidad = leerDoublePositivo(
                        "Capacidad máxima en toneladas: "
                );

                nuevoVehiculo = new CamionetaCarga(
                        placa,
                        marca,
                        modelo,
                        tarifaDiaria,
                        capacidad
                );

                break;

            default:
                return;
        }

        if (rentaMovil.registrarVehiculo(nuevoVehiculo)) {
            System.out.println(
                    "Vehículo registrado correctamente."
            );
        } else {
            System.out.println(
                    "No fue posible registrar el vehículo."
            );
        }
    }

    private static void cotizarAlquiler(RentaMovil rentaMovil) {

        System.out.println("\n--- COTIZAR ALQUILER ---");

        String placa = leerTextoNoVacio("Placa: ");

        Vehiculo vehiculo = rentaMovil.buscarVehiculo(placa);

        if (vehiculo == null) {
            System.out.println(
                    "No existe un vehículo con la placa ingresada."
            );
            return;
        }

        int dias = leerEnteroPositivo(
                "Cantidad de días: "
        );

        double costo = rentaMovil.cotizar(placa, dias);

        System.out.println("\n--- COTIZACIÓN ---");
        System.out.println(vehiculo.obtenerInformacion());

        System.out.printf(
                "Costo total: Q%.2f%n",
                costo
        );

        System.out.println(
                "Esta cotización no modifica la disponibilidad "
                        + "ni los ingresos."
        );
    }

    private static void confirmarAlquiler(RentaMovil rentaMovil) {

        System.out.println("\n--- CONFIRMAR ALQUILER ---");

        String placa = leerTextoNoVacio("Placa: ");

        Vehiculo vehiculo = rentaMovil.buscarVehiculo(placa);

        if (vehiculo == null) {
            System.out.println(
                    "No existe un vehículo con la placa ingresada."
            );
            return;
        }

        if (!vehiculo.isDisponible()) {
            System.out.println(
                    "El vehículo se encuentra ocupado "
                            + "y no puede alquilarse."
            );
            return;
        }

        int dias = leerEnteroPositivo(
                "Cantidad de días: "
        );

        double costo = rentaMovil.cotizar(
                placa,
                dias
        );

        System.out.println(
                vehiculo.obtenerInformacion()
        );

        System.out.printf(
                "Total del alquiler: Q%.2f%n",
                costo
        );

        boolean confirmar = leerSiNo(
                "¿Desea confirmar el alquiler? (S/N): "
        );

        if (!confirmar) {
            System.out.println(
                    "Alquiler cancelado. "
                            + "No se realizó ningún cambio."
            );
            return;
        }

        if (rentaMovil.confirmarAlquiler(placa, dias)) {

            System.out.println(
                    "Alquiler confirmado correctamente."
            );

            System.out.printf(
                    "Monto cobrado: Q%.2f%n",
                    costo
            );

        } else {

            System.out.println(
                    "No fue posible realizar el alquiler."
            );
        }
    }

    private static void registrarDevolucion(RentaMovil rentaMovil) {

        System.out.println("\n--- REGISTRAR DEVOLUCIÓN ---");

        String placa = leerTextoNoVacio("Placa: ");

        Vehiculo vehiculo = rentaMovil.buscarVehiculo(placa);

        if (vehiculo == null) {

            System.out.println(
                    "No existe un vehículo con la placa ingresada."
            );

            return;
        }

        if (vehiculo.isDisponible()) {

            System.out.println(
                    "El vehículo ya se encuentra disponible. "
                            + "No se puede registrar la devolución."
            );

            return;
        }

        if (rentaMovil.registrarDevolucion(placa)) {

            System.out.println(
                    "Devolución registrada correctamente."
            );

            System.out.println(
                    "El vehículo vuelve a estar disponible."
            );
        }
    }

    private static int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String entrada = scanner.nextLine();

            try {

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Entrada inválida. "
                                + "Debe ingresar un número entero."
                );
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {

        while (true) {

            int valor = leerEntero(mensaje);

            if (valor > 0) {
                return valor;
            }

            System.out.println(
                    "El valor debe ser mayor que cero."
            );
        }
    }

    private static double leerDoublePositivo(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String entrada = scanner.nextLine();

            try {

                double valor = Double.parseDouble(entrada);

                if (valor > 0) {
                    return valor;
                }

                System.out.println(
                        "El valor debe ser mayor que cero."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Entrada inválida. "
                                + "Debe ingresar un número."
                );
            }
        }
    }

    private static String leerTextoNoVacio(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println(
                    "El valor no puede estar vacío."
            );
        }
    }

    private static boolean leerSiNo(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String respuesta = scanner.nextLine().trim();

            if (respuesta.equalsIgnoreCase("S")) {
                return true;
            }

            if (respuesta.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println(
                    "Entrada inválida. Ingrese S o N."
            );
        }
    }
}