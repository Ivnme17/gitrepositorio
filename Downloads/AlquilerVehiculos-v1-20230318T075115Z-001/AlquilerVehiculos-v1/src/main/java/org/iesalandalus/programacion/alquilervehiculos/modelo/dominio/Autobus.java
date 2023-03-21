package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.IVehiculos;

public class Autobus extends Vehiculo {
private int FACTOR_PLAZAS;
private int plazas;
private String marca;
private String modelo;
private String matricula;
	public Autobus(String marca, String modelo,int plazas, String matricula) {
		super(marca, modelo, matricula);
		this.plazas = plazas;
		if (marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo");
		}
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matricula no puede ser nula.");
		}
	}

	public Autobus Autobus (Autobus autobus) {//Constructor copia
		if(autobus == null) {
			throw new NullPointerException("ERROR: El valor de autobus no puede ser nulo.");
		}
		return autobus; 
		
	}
	private void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getPlazas() {
		return plazas;
	}

	@Override
	public double getFactorPrecio() {
		return 1.5;
	}
	
	@Override
    public Autobus copiar() {
        return new Autobus(getMatricula(), getMarca(), getPlazas(), getModelo());
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "plazas=" + plazas +
                ", " + super.toString() +
                '}';
    }

	@Override
	protected int getCilindrada() {

		return 0;
	}
}
