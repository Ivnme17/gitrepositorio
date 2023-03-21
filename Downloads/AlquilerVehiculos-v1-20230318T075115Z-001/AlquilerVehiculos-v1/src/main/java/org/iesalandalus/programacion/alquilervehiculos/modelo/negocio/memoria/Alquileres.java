package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Vehiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.OperationNotSupportedException;


public class Alquileres implements IAlquileres {
    private List<Alquiler> Coleccionalquileres;

    public Alquileres() {
        Coleccionalquileres = new ArrayList<>();
    }

    public List<Alquiler> get(Vehiculos vehiculo) {
		ArrayList<Alquiler> arrayAlquileresCliente = new ArrayList<>();

		for (Alquiler alquilerLista : Coleccionalquileres) {
			if (alquilerLista.getVehiculo().equals(vehiculo)) {
				arrayAlquileresCliente.add(alquilerLista);}}
		return arrayAlquileresCliente;
			
		}

    @Override
	public List<Alquiler> get(Cliente cliente) {
		ArrayList<Alquiler> arrayAlquileresCliente = new ArrayList<>();

		for (Alquiler alquilerLista2 : Coleccionalquileres) {
			if (alquilerLista2.getCliente().equals(cliente)) {
				arrayAlquileresCliente.add(alquilerLista2);
			}
		}

		return arrayAlquileresCliente;
	}
    @Override
	public int getCantidad() {
        return Coleccionalquileres.size();
    }

    @Override
	public boolean comprobarAlquiler(Alquiler alquiler) {
        if (alquiler == null || Coleccionalquileres.contains(alquiler)) {
            return false;
        }
        for (Alquiler a : Coleccionalquileres) {
            if (a.getCliente().equals(alquiler.getCliente()) && a.getFechaDevolucion() == null) {
                return false;
            }
            if (a.getVehiculo().equals(alquiler.getVehiculo()) && a.getFechaDevolucion() == null) {
                return false;
            }
            if (a.getCliente().equals(alquiler.getCliente()) && a.getVehiculo().equals(alquiler.getVehiculo())
                    && a.getFechaAlquiler().isBefore(alquiler.getFechaDevolucion())
                    && (a.getFechaDevolucion() == null || a.getFechaDevolucion().isAfter(alquiler.getFechaAlquiler()))) {
                return false;
            }
        }
        return true;
    }

    @Override
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException  {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		if (!Coleccionalquileres.contains(alquiler)) {
			comprobarAlquiler(alquiler.getCliente(), alquiler.getVehiculo(), alquiler.getFechaAlquiler());
			Coleccionalquileres.add(alquiler);
		}

		

	}


	private void comprobarAlquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {
		for (Alquiler alquiler : Coleccionalquileres) {
		
			if (alquiler.getFechaDevolucion() == null) {

				if (alquiler.getCliente().equals(cliente)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				}
				if (alquiler.getVehiculo().equals(vehiculo)) {

					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}

			} else {
				
				if (alquiler.getCliente().equals(cliente) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
						|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
				if (alquiler.getVehiculo().equals(vehiculo) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
						|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
			}
		}
	}

	@Override
	public void devolver(Alquiler alquiler , LocalDate fechaDevolucion) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}

		if (Coleccionalquileres.contains(alquiler)) {
			
			alquiler.devolver(fechaDevolucion);
			
		}else {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}

	}

	@Override
	public Alquiler buscar(Alquiler alquiler) {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}

		
		if (Coleccionalquileres.indexOf(alquiler) == -1) { 
											
			alquiler=null;  
		}else {
			Coleccionalquileres.get(Coleccionalquileres.indexOf(alquiler));
		}

		return alquiler; 

	}


    @Override
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}

		if (Coleccionalquileres.contains(alquiler)) { 
			Coleccionalquileres.remove(alquiler);
		}else {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}

		
	}

}
    