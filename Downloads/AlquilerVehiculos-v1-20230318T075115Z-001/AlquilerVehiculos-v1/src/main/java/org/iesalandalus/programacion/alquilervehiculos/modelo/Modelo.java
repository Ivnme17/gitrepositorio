package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Vehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.IVehiculos;

public class Modelo {
	private IClientes clientes;
	private IAlquileres alquileres;
	private IVehiculos vehiculos;

	public Modelo() {
 }

	
	public void comenzar() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();
	}

	public void terminar() {
		System.out.println("AVISO: El modelo ha terminado");
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(new Cliente(cliente));
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		vehiculos.insertar(new Turismo(turismo));
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}

		Cliente cliente = buscar(alquiler.getCliente());
		Vehiculo vehiculo = buscar(alquiler.getVehiculo());

		if (cliente == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}

		if (vehiculo == null) {
			throw new OperationNotSupportedException("ERROR: No existe el vehiculo del alquiler.");
		}

		alquileres.insertar(new Alquiler(new Cliente(cliente), new Vehiculo (vehiculo)), alquiler.getFechaAlquiler()));
	}

	public Cliente buscar(Cliente cliente) {
		Cliente clienteBuscado = clientes.buscar(cliente);
		return (clienteBuscado == null) ? null : new Cliente(clienteBuscado);
	}

	public Vehiculo buscar(Vehiculos vehiculo) {
		Vehiculo vehiculoBuscado = vehiculos.buscar(vehiculo);
		return (vehiculoBuscado == null) ? null : new Vehiculo(vehiculoBuscado);
	}

	public Alquiler buscar(Alquiler alquiler) {
		return new Alquiler(alquileres.buscar(alquiler));
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		alquiler = alquileres.buscar(alquiler);

		if (alquiler == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}

		alquiler.devolver(fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquilerAux : alquileres.get(cliente)) {
			borrar(alquilerAux);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Vehiculos vehiculo) throws OperationNotSupportedException {
		for (Alquiler alquilerAux : alquileres.get(vehiculo)) {
			borrar(alquilerAux);
		}
		vehiculos.borrar(vehiculo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		List<Cliente> listaCliente = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			listaCliente.add(new Cliente(cliente));
		}
		return listaCliente;
	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaTurismo = new ArrayList<>();
		for (Vehiculo turismo : vehiculos.get()) {
			listaTurismo.add(new Turismo(turismo));
		}
		return listaTurismo;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaAlquiler = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			listaAlquiler.add(new Alquiler(alquiler));
		}
		return listaAlquiler;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		ArrayList<Alquiler> alquilerArray = new ArrayList<>();
		for (Alquiler alquilerAux : alquileres.get(cliente)) {
			alquilerArray.add(new Alquiler(alquilerAux));
		}
		return alquilerArray;
	}

	public List<Alquiler> getAlquileres(Vehiculos vehiculo) {
		ArrayList<Alquiler> alquilerArray = new ArrayList<>();
		for (Alquiler alquilerAux : alquileres.get(vehiculo)) {
			alquilerArray.add(new Alquiler(alquilerAux));
		}
		return alquilerArray;
	}


	public List<Vehiculo> getVehiculos() {
		// TODO Auto-generated method stub
		return null;
	}

}