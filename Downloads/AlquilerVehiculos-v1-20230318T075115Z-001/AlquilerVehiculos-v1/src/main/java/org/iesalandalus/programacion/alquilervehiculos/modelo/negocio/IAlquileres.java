package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public interface IAlquileres {

	List<Alquiler> get(Vehiculos vehiculo);

	List<Alquiler> get(Cliente cliente);

	int getCantidad();

	boolean comprobarAlquiler(Alquiler alquiler);

	void insertar(Alquiler alquiler) throws OperationNotSupportedException;

	void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException;

	Alquiler buscar(Alquiler alquiler);

	void borrar(Alquiler alquiler) throws OperationNotSupportedException;



	

}