package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Vehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.IVehiculos;

public class Furgoneta extends Vehiculo{
private int FACTOR_PMA;
private int FACTOR_PLAZAS;
private int pma;
private int plazas;
private String marca;
private String modelo;
private String matricula;
	public Furgoneta(String marca, String modelo, int pma , int plazas, String matricula) {
		super(marca, modelo, matricula);
		this.pma = pma;
		this.plazas = plazas;
	}
	public Furgoneta  Furgoneta (Furgoneta furgoneta) { //Constructor copia
		if (furgoneta == null) {
			throw new NullPointerException("ERROR: El valor de furgoneta no puede ser nulo.");
		}
		this.pma =  2000;
		this.plazas = 2;
		return furgoneta;
	}
		@Override
	public double getFactorPrecio() {
		return 1.2;
	}
		public int getPma() {
			return pma;
		}
		public int getPlazas() {
			return plazas;
		}
		private void setPma(int pma) {
			this.pma = pma;
		}
		private void setPlazas(int plazas) {
			this.plazas = plazas;
		}
		@Override
		public Vehiculo copiar() {
		    IVehiculos vehiculo = null;
		    try {
		        vehiculo = (IVehiculos) this.clone();
		    } catch (CloneNotSupportedException ex) {
		        System.out.println("No se puede duplicar el vehículo");
		    }
		    return (Vehiculo) vehiculo;
		}
		@Override
		protected int getCilindrada() {
			// TODO Auto-generated method stub
			return 0;
		}

}


