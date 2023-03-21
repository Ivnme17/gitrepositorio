package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.IVehiculos;

public abstract class Vehiculos implements IVehiculos {

    private List<Vehiculo> coleccionVehiculos;

    public Vehiculos() {
        this.coleccionVehiculos = new ArrayList<>();
    }

    @Override
	public List<Vehiculo> get() {
        return new ArrayList<>(coleccionVehiculos);
    }

    @Override
	public int getCantidad() {
        return coleccionVehiculos.size();
    }

    @Override
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
    	 if (vehiculo == null) {
         	throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
         }
    	if (vehiculo != null && !coleccionVehiculos.contains(vehiculo)) {
            coleccionVehiculos.add(vehiculo);
            }else { throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
            }
        }

    @Override
	public Vehiculo buscar(Vehiculos vehiculo) {
        int index = coleccionVehiculos.indexOf(vehiculo);
        if (index >= 0) {
            return coleccionVehiculos.get(index);
        }else if (vehiculo==null){
            throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
        }
		return null;
    }

    @Override
	public void borrar(Vehiculos vehiculo) throws OperationNotSupportedException {
    	if (vehiculo == null) {
        	throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
        }
    
    	if (!coleccionVehiculos.remove(vehiculo)) {
            throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula."); 
}
}



}
		

