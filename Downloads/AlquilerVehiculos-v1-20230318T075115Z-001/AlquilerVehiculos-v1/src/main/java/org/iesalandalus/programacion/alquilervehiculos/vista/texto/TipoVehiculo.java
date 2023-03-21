package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.IVehiculos;

public enum TipoVehiculo {
TURISMO , AUTOBUS , FURGONETA;
	private String nombre;
	private TipoVehiculo() {
		this.nombre = nombre;
	}
	private static boolean esOrdinalValido(int ordinal) {
		if(ordinal == 1) {
		return true;
		}else
			return false;
		}
	public static void getVehiculo(IVehiculos vehiculo) {
		
	}
	
	@Override
	public String toString(){
		return nombre;
	}
}
