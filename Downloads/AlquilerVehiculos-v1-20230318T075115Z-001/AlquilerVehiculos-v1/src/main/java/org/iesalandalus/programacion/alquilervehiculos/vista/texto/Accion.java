package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

public enum Accion {
SALIR, INSERTAR_CLIENTE, INSERTAR_VEHICULO, INSERTAR_ALQUILER,
BUSCAR_CLIENTE, BUSCAR_VEHICULO, BUSCAR_ALQUILER, MODIFICAR_CLIENTE,
DEVOLVER_ALQUILER_CLIENTE, DEVOLVER_ALQUILER_VEHICULO, BORRAR_CLIENTE,
BORRAR_VEHICULO, BORRAR_ALQUILER, LISTAR_CLIENTES, LISTAR_VEHICULOS, LISTAR_ALQUILERES,
LISTAR_ALQUILERES_CLIENTE, LISTAR_ALQUILERES_VEHICULO,VEHICULO, MOSTRAR_ESTADISTICAS_MENSUALES;

private String texto;

private Accion() {
	this.texto = texto;
}

private static boolean esOrdinalValido(int ordinal) {
	if(ordinal == 1) {
	return true;
	}else
		return false;
	}

@Override
public String toString() {
	return texto;
}
}
