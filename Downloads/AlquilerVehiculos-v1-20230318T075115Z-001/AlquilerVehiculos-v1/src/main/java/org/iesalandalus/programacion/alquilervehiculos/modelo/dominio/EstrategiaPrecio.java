package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public interface EstrategiaPrecio {
	public double calcularPrecio1(Alquiler alquiler);
	 
	public default double calcularPrecio(Alquiler alquiler) {
	        return alquiler.getHoras() * ((Alquiler) alquiler.getVehiculo()).getPrecio() * ((Vehiculo) alquiler.getVehiculo()).getFactorPrecio();
	    }
	}

	public class EstrategiaPrecioPorKilometro implements EstrategiaPrecio {
	    @Override
	    public double calcularPrecio1(Alquiler alquiler) {
	        return alquiler.getKilometros() * ((Alquiler) alquiler.getVehiculo()).getPrecio() * ((Vehiculo) alquiler.getVehiculo()).getFactorPrecio();
	   }
}


