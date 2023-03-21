package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;

public class FuenteDatosMemoria implements IFuenteDatos {
@Override
public Clientes crearClientes(Clientes IClientes) {
	return IClientes;
}
@Override
public IVehiculos crearTurismos(IVehiculos ITurismos) {
	return ITurismos;
}
@Override
public Alquileres creaAlquiler(Alquileres IAlquileres) {
	return IAlquileres;
}
}
