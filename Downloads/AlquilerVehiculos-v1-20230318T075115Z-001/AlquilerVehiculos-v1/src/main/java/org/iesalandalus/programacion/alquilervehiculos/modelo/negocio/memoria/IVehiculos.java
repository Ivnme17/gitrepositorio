package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Vehiculos;

public interface IVehiculos {

	List<Vehiculo> get();

	int getCantidad();

	void insertar(Vehiculo vehiculo) throws OperationNotSupportedException;

	Vehiculo buscar(Vehiculos vehiculo);

	void borrar(Vehiculos vehiculo) throws OperationNotSupportedException;

}