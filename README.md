# Ejercicio - 4
María Chávez y Lourdes Lemus

# RentaMovil
RentaMovil es una aplicación de consola desarrollada en Java para administrar una empresa de alquiler de vehículos. El sistema permite trabajar con automóviles, motocicletas y camionetas de carga, cada uno con características y reglas de cobro diferentes.

## Funcionalidades
El programa permite:

- Registrar nuevos vehículos.
- Consultar la flota de vehículos.
- Buscar vehículos por placa.
- Realizar cotizaciones.
- Confirmar alquileres.
- Registrar devoluciones.
- Generar un reporte general.
- Controlar la disponibilidad de los vehículos.
- Llevar el control de los ingresos obtenidos por alquileres confirmados.
- Manejar entradas inválidas sin finalizar inesperadamente el programa.

## Estructura del programa
El programa utiliza herencia para organizar las características comunes y particulares de los vehículos.

### Vehiculo
Es una clase abstracta que contiene los datos y comportamientos comunes de todos los vehículos:

- Placa.
- Marca.
- Modelo.
- Tarifa diaria.
- Disponibilidad.

También define el método calcularCosto(int dias), el cual es implementado por cada tipo de vehículo según su regla de cobro.

### Automovil
Hereda de Vehiculo y agrega:

- Cantidad de pasajeros.
- Tipo de transmisión.

Si el automóvil tiene transmisión automática, se aplica un recargo de Q50.00 por cada día de alquiler.

### Motocicleta
Hereda de Vehiculo y agrega el cilindraje en centímetros cúbicos.
Si la motocicleta tiene un cilindraje mayor a 250 cc, se aplica un recargo único de Q75.00 por todo el alquiler.

### CamionetaCarga
Hereda de Vehiculo y agrega la capacidad máxima de carga expresada en toneladas.
Se aplica un recargo de Q100.00 por cada tonelada de capacidad máxima por cada día de alquiler.

### RentaMovil
Esta clase administra la flota de vehículos y coordina las operaciones principales del sistema:

- Registro de vehículos.
- Búsqueda de vehículos por placa.
- Cotizaciones.
- Confirmación de alquileres.
- Devoluciones.
- Consulta de la flota.
- Generación del reporte general.
- Control de los ingresos acumulados.

Las cotizaciones no modifican la disponibilidad de los vehículos ni los ingresos acumulados. Los ingresos solamente aumentan cuando un alquiler es confirmado.

### Main
Contiene el método main y se encarga de iniciar la aplicación y manejar el menú de consola.
El programa inicia con al menos dos vehículos de cada categoría para permitir observar las diferentes reglas de cobro.

## Reglas de cobro

### Automóvil

Automóvil con transmisión manual:

- Costo = tarifa diaria × días

Automóvil con transmisión automática:

- Costo = (tarifa diaria + Q50.00) × días

### Motocicleta

Motocicleta con cilindraje igual o menor a 250 cc:

- Costo = tarifa diaria × días

Motocicleta con cilindraje mayor a 250 cc:

- Costo = (tarifa diaria × días) + Q75.00

El recargo de Q75.00 se aplica una sola vez durante todo el alquiler.

### Camioneta de carga

- Costo = (tarifa diaria × días) + (capacidad máxima × Q100.00 × días)

El recargo se calcula utilizando la capacidad máxima de la camioneta.

## Compilación y ejecución

Para compilar el programa, abrir una terminal en la carpeta donde se encuentran los archivos .java y ejecutar:
- javac *.java

Una vez compilado, ejecutar el programa con:
- java Main

## Menú del programa

El programa presenta las siguientes opciones:

1. Registrar vehículo.
2. Consultar flota.
3. Cotizar alquiler.
4. Confirmar alquiler.
5. Registrar devolución.
6. Mostrar reporte general.
7. Salir.

El menú permanece disponible hasta que el usuario seleccione la opción de salir.

## Validaciones

El programa controla las siguientes condiciones:

- Las placas no pueden estar vacías.
- No pueden existir dos vehículos con la misma placa.
- Las tarifas diarias deben ser mayores que cero.
- La cantidad de pasajeros debe ser mayor que cero.
- El cilindraje debe ser mayor que cero.
- La capacidad de carga debe ser mayor que cero.
- Los días de alquiler deben ser números enteros positivos.
- No se puede alquilar un vehículo que se encuentre ocupado.
- No se puede devolver un vehículo que ya se encuentre disponible.
- Si una placa no existe, se muestra un mensaje correspondiente.
- Las entradas con formato incorrecto son controladas para evitar que el programa finalice inesperadamente.

## Disponibilidad e ingresos

Las cotizaciones no modifican la disponibilidad del vehículo ni los ingresos acumulados.
Si un alquiler es cancelado, la disponibilidad y los ingresos permanecen sin cambios.
Cuando un alquiler es confirmado, el vehículo cambia a estado ocupado y el costo total del alquiler se agrega a los ingresos acumulados.
Cuando se registra una devolución, el vehículo vuelve a estar disponible y los ingresos acumulados no se modifican.