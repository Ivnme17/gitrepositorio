package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;

public class Clientes implements IClientes {
    private List<Cliente> coleccionClientes;

    public Clientes() {
        coleccionClientes = new ArrayList<>();
    }

    @Override
	public List<Cliente> get() {
        return new ArrayList<>(coleccionClientes);
    }

    @Override
	public int getCantidad() {
        return coleccionClientes.size();
    }

    @Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException{
        if (cliente == null) {
        	throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
        }
    	if (cliente != null && !coleccionClientes.contains(cliente)) {
            coleccionClientes.add(cliente);
        }else {
        	throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
        }
    }

    @Override
	public Cliente buscar(Cliente cliente)  {
        if(cliente==null) {
        	throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
        }
    	int indice = coleccionClientes.indexOf(cliente);
        if (indice != -1) {
            return coleccionClientes.get(indice);
        }
        return null;
    }

    @Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
    	if(cliente==null) {
    		throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
    	}
    	if (!coleccionClientes.remove(cliente)) {
            throw new  OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
        }
    }

    @Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
        if (cliente==null) {
        	throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
        }
    	if (cliente != null && coleccionClientes.contains(cliente)) {
            if (nombre != null && !nombre.isBlank()) {
                cliente.setNombre(nombre);
            }
            if (telefono != null && !telefono.isBlank()) {
                cliente.setTelefono(telefono);
            }
        } else {
            throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
        }
    }
}