package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Vehiculos;

public class Turismo extends Vehiculo {
	private int cilindrada;
	private int FACTOR_CILINDRADA;
	
	public Turismo(String marca, String modelo,int cilindrada, String matricula) {
		super(marca,modelo,matricula);
		this.cilindrada = cilindrada;
	}
	public Turismo (Vehiculo vehiculo) { //Turismo copia
	super(vehiculo);
	if (vehiculo == null) {
		throw new NullPointerException("ERROR: No se puede copiar un turismo nulo");
	}
	setCilindrada(cilindrada);
	}

	@Override
	public double getFactorPrecio() {
		return 1.5;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return String.format("Turismo [cilindrada=%s, FACTOR_CILINDRADA=%s]", cilindrada, FACTOR_CILINDRADA);
	}




}
