package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.IVehiculos;

public interface IFuenteDatos {

	Clientes crearClientes(Clientes IClientes);

	IVehiculos crearTurismos(IVehiculos ITurismos);

	Alquileres creaAlquiler(Alquileres IAlquileres);

}