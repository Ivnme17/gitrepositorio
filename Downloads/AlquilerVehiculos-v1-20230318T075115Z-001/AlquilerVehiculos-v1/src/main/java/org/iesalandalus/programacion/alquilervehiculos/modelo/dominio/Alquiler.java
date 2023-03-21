package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;
	
	public class Alquiler {
	public static DateTimeFormatter FORMATO_FECHA;
	private  int PRECIO_DIA = 20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Vehiculo vehiculo;
	
	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setVehiculo(vehiculo);
		setFechaAlquiler(fechaAlquiler);
	}
		
	
	public Alquiler (Alquiler alquiler ) { // constructor copia
		 
		if (alquiler == null) { 
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
		
		
		cliente=new Cliente(alquiler.getCliente());
		vehiculo = new Vehiculo(alquiler.getVehiculo());
		setFechaAlquiler(alquiler.getFechaAlquiler());
		setFechaDevolucion(alquiler.getFechaDevolucion());
		
		
			
 }
	
	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		LocalDate hoy = LocalDate.now();
	    if (fechaAlquiler.isAfter(hoy)) {
	      throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
	    }
		this.fechaAlquiler = fechaAlquiler;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {

		if (fechaDevolucion == null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if(fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (fechaDevolucion.isBefore(fechaAlquiler) || fechaDevolucion.isEqual(getFechaAlquiler()) )  {
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		
		
		
		this.fechaDevolucion = fechaDevolucion;
	}
	
public void devolver (LocalDate fechaDevolucion) throws OperationNotSupportedException {
		
		if(this.fechaDevolucion != null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada."); 
		}
		
		setFechaDevolucion(fechaDevolucion); 
		
	}
	

		public int getPrecio () {
			int precio = 0;
			
			if (this.fechaDevolucion != null) {
				
				int factorCilindrada = vehiculo.getCilindrada() / 10;
				
				int calcularNumDias = (int) (ChronoUnit.DAYS.between(fechaAlquiler,fechaDevolucion)); 
				
				 precio = (PRECIO_DIA + factorCilindrada) * calcularNumDias;
				
			}else {
				precio = 0;
			}
				
			return precio;
		}

	private void setCliente(Cliente cliente) {
		if(cliente == null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		this.cliente = cliente;
	}

	private void setVehiculo(Vehiculo vehiculo) {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: El vehiculo no puede ser nulo.");
		}
		this.vehiculo = vehiculo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, fechaDevolucion, vehiculo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(fechaDevolucion, other.fechaDevolucion) && Objects.equals(vehiculo, other.vehiculo);
	}

	@Override
	public String toString() {
		String cadenaFrase = null;
		if (this.fechaDevolucion == null) {
			
			cadenaFrase = String.format("%s <---> %s, %s - %s (%d€)" , cliente ,vehiculo , getFechaAlquiler().format(FORMATO_FECHA),"Aún no devuelto",getPrecio());
			
		}else {
			cadenaFrase = String.format("%s <---> %s, %s - %s (%d€)" ,cliente ,vehiculo , getFechaAlquiler().format(FORMATO_FECHA),getFechaDevolucion().format(FORMATO_FECHA),getPrecio());
		}
		
		return cadenaFrase;
	}
	public int getHoras() {
		return 0;
	}
	public int getKilometros() {
		return 0;
	}

	
	}
